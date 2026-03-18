package lms.util;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Ovo je filter koji se pokrece pri svakom HTTP zahtevu (OncePerRequestFilter) kako bi iznova utvrdio ko salje zahtev

@Component //sa ovim govorim springu da automatski napravi ovaj objekat i drzi ga spremnim
public class JwtRequestFilter extends OncePerRequestFilter {
    
    @Autowired private JwtUtil jwtUtil; //injektuje ovaj servis da bih mogao da koristim njegove metode za validaciju tokena

    @Override
    //Ova metoda presrece zahtev pre nego sto on uopste dodje do mog kontrolera
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        
    	//Prvi korak je pronalazenje tokena koji se nalazi u Authorization zaglavlju
    	final String authorizationHeader = request.getHeader("Authorization");

        String username = null;  //promenljiva u kojoj ce se upisati username nosioca
        String jwt = null;  //token tog nosioca

        //Ako postoji zaglavlje postoji onda gleda da li tekst pocinje sa Bearer sto mu daje do znanja da 
        //sledi jwt token
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7); //sece prvih 7 karaktera ("Bearer ") da bi mu ostao cist token
            try {
                username = jwtUtil.extractUsername(jwt); //iz tokena se izvlaci username nosioca
            } catch (Exception e) {
                // Ako je token istekao ili je nevalidan, JwtUtil će baciti izuzetak
                logger.warn("JWT token je nevalidan ili istekao: " + e.getMessage());
            }
        }

        //Ako smo izvukli username filter proverava da li je korisnik vec ulogovan u trenutnom kontekstu
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            //Ako nije ide dalje na jwtUtil.isTokenExpired(jwt) da vidi da li je propusnica i dalje vazeca
            if (!jwtUtil.isTokenExpired(jwt)) {

                //Izvlačimo uloge direktno iz tokena (bez upita u bazu)
            	@SuppressWarnings("unchecked")
                List<String> roles = jwtUtil.extractClaim(jwt, claims -> claims.get("roles", List.class));

                //Pretvaramo String uloge u Spring Security GrantedAuthority objekte kako bi znao sta korisniku  
            	//sme da dopusti
                List<SimpleGrantedAuthority> authorities = roles.stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

                //Kreiramo token za autentifikaciju 
                //Umesto punog UserDetails objekta iz baze, prosledjujemo samo username i njegove uloge
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        username, null, authorities);
                
                //Ovde kontroler prikaci informacije o trenutnom korisniku
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                //Postavljamo korisnika u Spring Security kontekst 
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        
        //Pustamo zahtev dalje ka kontroleru
        chain.doFilter(request, response);
    }
}
