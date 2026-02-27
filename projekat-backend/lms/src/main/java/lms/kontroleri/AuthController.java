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
    private MyUserDetailsService userDetailsService;

    @Autowired
    private RegistrovaniKorisnikService korisnikService;

    @Autowired
    private UlogaService ulogaService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Neispravno korisničko ime ili lozinka");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Došlo je do serverske greške");
        }

        // 1. Učitavamo UserDetails (potrebno za JwtUtil i uloge)
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());

        // 2. KLJUČNI KORAK: Pronalazimo entitet korisnika u bazi da izvučemo ID
        RegistrovaniKorisnik korisnik = korisnikService.findByKorisnickoIme(authRequest.getUsername());

        if (korisnik == null) {
            return ResponseEntity.status(404).body("Korisnik nije pronađen u bazi podataka.");
        }

        // 3. Generišemo token sa UserDetails i ID-em korisnika
        final String jwt = jwtUtil.generateToken(userDetails, korisnik.getId());

        return ResponseEntity.ok(new AuthResponse(jwt));
    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request) {
        if (korisnikService.proveriPostojanje(request.getKorisnickoIme())) {
            return ResponseEntity.badRequest().body("Greška: Korisničko ime je zauzeto!");
        }

        RegistrovaniKorisnik korisnik;
        String nazivUloge;

        switch (request.getUloga().toUpperCase()) {
            case "ROLE_STUDENT":
                Student student = new Student();
                student.setIme(request.getIme());
                student.setPrezime(request.getPrezime());
                student.setJmbg(request.getJmbg());
                korisnik = student;
                nazivUloge = "ROLE_STUDENT";
                break;
            
            case "ROLE_NASTAVNIK":
                Nastavnik nastavnik = new Nastavnik();
                nastavnik.setIme(request.getIme());
                nastavnik.setPrezime(request.getPrezime());
                nastavnik.setBiografija(request.getBiografija());
                korisnik = nastavnik;
                nazivUloge = "ROLE_NASTAVNIK";
                break;

            case "ROLE_SLUZBA":
                OsobljeStudentskeSluzbe sluzba = new OsobljeStudentskeSluzbe();
                sluzba.setIme(request.getIme());
                sluzba.setPrezime(request.getPrezime());
                korisnik = sluzba;
                nazivUloge = "ROLE_SLUZBA";
                break;

            case "ROLE_ADMIN":
                Administartor admin = new Administartor();
                korisnik = admin;
                nazivUloge = "ROLE_ADMIN";
                break;

            default:
                return ResponseEntity.badRequest().body("Greška: Nepoznata uloga.");
        }

        korisnik.setKorisnickoIme(request.getKorisnickoIme());
        korisnik.setEmail(request.getEmail());
        korisnik.setLozinka(passwordEncoder.encode(request.getLozinka()));

        Uloga uloga = ulogaService.findByNaziv(nazivUloge);
        Set<Uloga> uloge = new HashSet<>();
        uloge.add(uloga);
        korisnik.setUloge(uloge);

        korisnikService.saveEntity(korisnik);

        return ResponseEntity.ok("Korisnik tipa " + request.getUloga() + " uspešno registrovan!");
    }
}