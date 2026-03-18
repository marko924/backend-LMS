package lms.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Ovo je servis koji je zaduzen za kreiranje, desifrovanje i proveru validnosti tokena

@Service
public class JwtUtil {

	//Ova promenljiva je kao lozinka tokena (kljuc za digitalni potpis)
    private final String SECRET_STRING = "moj_vrlo_dugacki_tajni_kljuc_koji_ima_vise_od_32_karaktera";
    
    //U ovoj promenljivoj ja sifrujem tu moju lozinku gde pravim kljuc koji se koristi za genrisanje
    //digitalnog potpisa na kraju svakog tokena
    private final SecretKey KEY = Keys.hmacShaKeyFor(SECRET_STRING.getBytes(StandardCharsets.UTF_8));

    //Ovo je pomocna funkcija koja mi vraca informaciju o vlasniku tokena na citljiv nacin
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    //Ovo je pomocna funkcija koja mi vraca informaciju o isteku tokena na citljiv nacin
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    //Ovo je genericka pomocna funkcija. Ona uzima sve podatke iz tokena, a onda koristi "funkciju-resavac" (claimsResolver) 
    //da izvuce samo ono sto mi treba (npr. samo username ili samo datum isteka).
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //Ovde proveravamo da li je potpis tokena ispravan i ako je neko nesto menjao ovde ce biti greska
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    //Ovde proveravamo da li je token istekao
    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    //Kada se korisnik uspesno uloguje, ova metoda mu pravi token 
    public String generateToken(UserDetails userDetails, Long userId) {
    	
    	//U payload deo tokena ubacujem sledece podatke (claims)
        Map<String, Object> claims = new HashMap<>();
        
        //Ovde pretvaram listu autoriteta iz spring security-ja u listu stringova 
        claims.put("roles", userDetails.getAuthorities().stream()  
                .map(auth -> auth.getAuthority())
                .collect(Collectors.toList()));
        
        //Ovde dodajem id prijavljenog korisnika kako bi angular znao ko je ulogovan
        claims.put("userId", userId);

        return createToken(claims, userDetails.getUsername());
    }

    //Ovde pravimo token gde mu prosledjuejmo podatke koje u njega satvlja i username korisnika
    //po kome se prepoznaje da je on vlasnik
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .claims(claims) //sve uloge
                .subject(subject)  //username
                .issuedAt(new Date(System.currentTimeMillis()))  //vreme kreiranja
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))  //vreme isteka (10h) 
                .signWith(KEY) //sa ovim se dodaje digitalni pacat gde ako se makar jedan karakter promeni token neci biti validan
                .compact();
    }

    //Ova je najbitniji deo koji proverava da li se username iz tokena poklapa sa onim koji Spring Security 
    //trenutno ima u bazi i proverava da li je token i dalje vremenski vazeci
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}