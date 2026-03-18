package lms.util;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

//Ovo je klas koja definise ko sme da pristupi kojoj ruti u sistemu

@Configuration  //govori springu da je ovo klasa sa podesavanjima koja treba da se ucita pri samom startu
@EnableWebSecurity  //anotacija koja aktivira spring security za web aplikaciju
@EnableMethodSecurity  //ovo mi omogucava da iznad konkretnih metoda u kontroleru napisem anotaciju @PreAuthorize
                       //sa kojoj mogu da direktno zabranim pristup specificnoj funkciji
public class SecurityConfig {
	
	private final JwtRequestFilter jwtRequestFilter; //uvezao sam ovu komponentu kako bi mogao da proverim token

    public SecurityConfig(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean //ova anotacija znaci da je ova metoda alat
    //Lanac filtera kroz koji prolazi svaki zahtev (ovde sam definisao zakone aplikacije)
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .csrf(csrf -> csrf.disable()) //iskljucio sam csrf zastitu jer ne koristim sesije
            .authorizeHttpRequests(auth -> auth  //sa ovim delim rute na javne i privatne (zasticene)
                .requestMatchers("/api/auth/**").permitAll() //dozvoljavamo sve rute za login i registraciju
                .requestMatchers("/api/**").permitAll() //dopustam svim korisnicima da pristupe svim putanjama
                .anyRequest().authenticated() //niko ne moze da pristupi nekom delu aplikacije bez da se prvo nije ulogovao
            )
            //dodavanjem ovog sam rekao serveru da ne treba da cuva nikakve podatke o korisniku u svojoj memoriji
            //svaki zahtev mora da nosi token sa sobom
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) 
            )
            //ovde kazem ovoj metodi da pre nego sto uradi bilo kakvu standardnu proveru da pusti JwtRequestFilter
            //da proveri token
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    //Ova metoda koristi AuthenticationManager koji rukuje procesom autentifikacije tako sto proverava 
    //korisnicko ime i lozinku za nas
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    //Ova metoda sluzi da osigura da se lozinke ne cuvaju kao obicni stringovi vec kao hes podaci
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    //Ovde sam podesio Cross-Origin Resource Sharing politiku kako bi frontend mogao bezbedno
    //da komunicira sa backendom
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
    
        // 1. Dozvoli odakle dolazi zahtev (Angular port)
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
    
        // 2. Dozvoli HTTP metode
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    
        // 3. Dozvoli zaglavlja (Authorization je kljucan za JWT)
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Cache-Control"));
    
        // 4. Dozvoli slanje tokena i kolačića
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
