package lms.kontroleri;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import lms.dtos.AuthRequest;
import lms.dtos.AuthResponse;
import lms.dtos.RegisterRequest;
import lms.modeli.Administartor;
import lms.modeli.Nastavnik;
import lms.modeli.OsobljeStudentskeSluzbe;
import lms.modeli.RegistrovaniKorisnik;
import lms.modeli.Student;
import lms.modeli.Uloga;
import lms.servisi.RegistrovaniKorisnikService;
import lms.servisi.UlogaService;
import lms.util.JwtUtil;
import lms.util.MyUserDetailsService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailsService userDetailsService; //Klasa koja vuče korisnika iz baze

    @Autowired
    private RegistrovaniKorisnikService korisnikService;

    @Autowired
    private UlogaService ulogaService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            // 1. Spring Security proverava da li su username i password tačni
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Neispravno korisničko ime ili lozinka", e);
        }

        // 2. Ako je kredo tačan, izvlačimo podatke o korisniku (uključujući uloge)
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authRequest.getUsername());

        // 3. Generišemo JWT token
        final String jwt = jwtUtil.generateToken(userDetails);

        // 4. Vraćamo token klijentu (Angularu)
        return ResponseEntity.ok(new AuthResponse(jwt));
    }

    //Poboljsana metoda za registraciju sa automatskom dodelom uloge ako ona nije poslata iz frontenda
    @PostMapping("/register")
    @Transactional
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request) {
        // 1. Provera da li korisničko ime već postoji
        if (korisnikService.findByKorisnickoIme(request.getKorisnickoIme()) != null) {
            return ResponseEntity.badRequest().body("Greška: Korisničko ime je zauzeto!");
        }

        // 2. Kreiranje adekvatnog objekta na osnovu uloge
        RegistrovaniKorisnik korisnik;
        String nazivUloge;

        switch (request.getUloga().toUpperCase()) {
            case "STUDENT":
                Student student = new Student();
                student.setIme(request.getIme());
                student.setPrezime(request.getPrezime());
                student.setJmbg(request.getJmbg());
                korisnik = student;
                nazivUloge = "ROLE_STUDENT";
                break;
            
            case "NASTAVNIK":
                Nastavnik nastavnik = new Nastavnik();
                nastavnik.setIme(request.getIme());
                nastavnik.setPrezime(request.getPrezime());
                nastavnik.setBiografija(request.getBiografija());
                korisnik = nastavnik;
                nazivUloge = "ROLE_NASTAVNIK";
                break;

            case "SLUZBA":
            	OsobljeStudentskeSluzbe sluzba = new OsobljeStudentskeSluzbe();
            	sluzba.setIme(request.getIme());
            	sluzba.setPrezime(request.getPrezime());
            	korisnik = sluzba;
            	nazivUloge = "ROLE_SLUZBA";
            	break;

            case "ADMIN":
            	Administartor admin = new Administartor();
            	korisnik = admin;
            	nazivUloge = "ROLE_ADMIN";
            	break;

            default:
            	return ResponseEntity.badRequest().body("Greška: Nepoznata uloga.");
        }

        // 3. Postavljanje zajedničkih polja
        korisnik.setKorisnickoIme(request.getKorisnickoIme());
        korisnik.setEmail(request.getEmail());
        korisnik.setLozinka(passwordEncoder.encode(request.getLozinka()));

        // 4. Dodela uloge iz baze
        Uloga uloga = ulogaService.findByNaziv(nazivUloge);
    
        Set<Uloga> uloge = new HashSet<>();
        uloge.add(uloga);
        korisnik.setUloge(uloge);

        // 5. Čuvanje u bazu
        // Zahvaljujući polimorfizmu, Spring Data JPA će prepoznati o kom entitetu je reč
        // i popuniti i osnovnu tabelu i specifičnu tabelu (ako je JOINED strategija)
        korisnikService.saveEntity(korisnik);

        return ResponseEntity.ok("Korisnik tipa " + request.getUloga() + " uspešno registrovan!");
    }
}

