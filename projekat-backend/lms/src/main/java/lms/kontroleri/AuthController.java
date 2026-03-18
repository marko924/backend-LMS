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
import lms.modeli.KorisnikUloga;
import lms.modeli.Nastavnik;
import lms.modeli.OsobljeStudentskeSluzbe;
import lms.modeli.RegistrovaniKorisnik;
import lms.modeli.Student;
import lms.modeli.Uloga;
import lms.servisi.RegistrovaniKorisnikService;
import lms.servisi.UlogaService;
import lms.util.JwtUtil;
import lms.util.MyUserDetailsService;

//Ovo je glavni kontroler za obradu registracije i prijave

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;  //zbog provere lozinke

    @Autowired
    private JwtUtil jwtUtil;  //za kreiranje tokena

    @Autowired
    private MyUserDetailsService userDetailsService;  //da bih ucitao sve uloge za tog korisnika iz baze

    @Autowired
    private RegistrovaniKorisnikService korisnikService;  

    @Autowired
    private UlogaService ulogaService;

    @Autowired
    private PasswordEncoder passwordEncoder;  //da bih hesovao lozinku iz RegisterRequest zahteva

    @PostMapping("/login")
    //Ova metoda prima korisnicko ime i lozniku koju klijent salje
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) {
    	//Prvo sta radim je da pomocu authenticationManager-a proveravam korisnicko ime i lozinku 
    	//tako sto hesiram lozinku i uporedjujem je sa onom u bazi
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        //Ako se ne poklapaju lozinke onda bacam gresku 401
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Neispravno korisničko ime ili lozinka");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Došlo je do serverske greške");
        }
        //Ako je lozinka tacna moj userDetailService povlaci sve podatke o ulogama tog korisnika
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        
        //Ovde pomocu korisnickog imena prijavljenog korisnika trazim odgovarajuceg iz baze
        RegistrovaniKorisnik korisnik = korisnikService.findByKorisnickoIme(authRequest.getUsername());

        if (korisnik == null) {
            return ResponseEntity.status(404).body("Korisnik nije pronađen u bazi podataka.");
        }
        //Za pronadjenog korisnika pomocu JwtUtil klase generisem mu token
        final String jwt = jwtUtil.generateToken(userDetails, korisnik.getId());

        //Na kraju upakujem taj jwt token u AuthResponse objekat i posaljem ga nazad u angular (koji ga cuva u localStorage) 
        return ResponseEntity.ok(new AuthResponse(jwt));
    }

    @PostMapping("/register")
    @Transactional //stavljam ovu anotaciju da se ne bi poslali nedovrseni podaci
    //Ova metoda prima RegisterRequest u kojem se nalaze svi potrebni parametri za registrovanje novog korisnika
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request) {
    	
    	//Ovde sam dodao proveru da li vec takav korisnik sa tim korisnickim imenom vec postoji u bazi
    	//da ne bih imao dva koisnika sa istim podatkom
        if (korisnikService.proveriPostojanjePoImenu(request.getKorisnickoIme())) {
            return ResponseEntity.badRequest().body("Greška: Korisničko ime je zauzeto!");
        }
        //Isto kao to gore sam uradio i za email
        if (korisnikService.proveriPostojanjePoEmailu(request.getEmail())) {
            return ResponseEntity.badRequest().body("Greška: Korisnik sa tim email-om već postoji!");
        }
        
        //U zasvisnosti od toga koju ulogu je poslao klijent u zahtevu takav korisnik se registruje
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
        //Kada se lozinka dodaje registrovanom korisniku ona se prvo hesuje zbog sigurnosti
        korisnik.setLozinka(passwordEncoder.encode(request.getLozinka()));
        
        //Na osnovu uloge koja je pristigla u zahtevu ja je trazim objekat uloga iz baze sa tim nazivom
        Uloga uloga = ulogaService.findByNaziv(nazivUloge);

        //To radim zato sto sam napravio tabelu vise na vise koja mi sluzi da dodelim ulogu korisniku
        //I ja ovde pravim jedan takav podatak koji ce se posle ubaciti u Set uloge
        KorisnikUloga novaVeza = new KorisnikUloga();
        novaVeza.setKorisnik(korisnik);
        novaVeza.setUloga(uloga);
        novaVeza.setObrisan(false);

        //Zbog toga sto u entitteu RegistrovaniKorisink imam vezu @OneToMany preba entitetu KorisnikUloga
        //ja ga ovde dodajem
        Set<KorisnikUloga> uloge = new HashSet<>();
        uloge.add(novaVeza);
        korisnik.setUloge(uloge);

        //Na kraju pozivam metodu za cuvanje tog registrovanog korisnika u bazu
        korisnikService.saveEntity(korisnik);

        return ResponseEntity.ok("Korisnik tipa " + request.getUloga() + " uspešno registrovan!");
    }
}