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

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    
    @Autowired private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            try {
                username = jwtUtil.extractUsername(jwt);
            } catch (Exception e) {
                // Ako je token istekao ili je nevalidan, JwtUtil će baciti izuzetak
                logger.warn("JWT token je nevalidan ili istekao: " + e.getMessage());
            }
        }

        // 2. Ako imamo username i korisnik još uvek nije autentifikovan u trenutnom kontekstu
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // 3. Proveravamo da li je token validan (nije istekao)
            if (!jwtUtil.isTokenExpired(jwt)) {

                // 4. KLJUČNI DEO: Izvlačimo uloge direktno iz tokena (Bez upita u bazu!)
            	@SuppressWarnings("unchecked")
                List<String> roles = jwtUtil.extractClaim(jwt, claims -> claims.get("roles", List.class));

                // 5. Pretvaramo String uloge u Spring Security GrantedAuthority objekte
                List<SimpleGrantedAuthority> authorities = roles.stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

                // 6. Kreiramo token za autentifikaciju. 
                // Umesto punog UserDetails objekta iz baze, prosleđujemo samo username i njegove uloge.
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        username, null, authorities);
                
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // 7. Postavljamo korisnika u Spring Security kontekst
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        
        // 8. Puštamo zahtev dalje ka kontroleru
        chain.doFilter(request, response);
    }
}
