package lms.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lms.modeli.RegistrovaniKorisnik;
import lms.servisi.RegistrovaniKorisnikService;

//Ovaj servis sluzi da na osnovu korisnickog imena iz login-a pronadje sve informacije o tom korisniku
//u bazi i da ih prevede na jezik koji ce razumeti spring security

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	//UserDetailsService je ugradjeni mehanizam iz spring security-ja za proveru korisnika

	//Posto taj mehanizam ne zna kako izgleda moj korisnik u bazi ja sam injektovao servis za registrovanog korisnika
	//kako bih mogao da ucitam podatke koji su mi potrebni
	@Autowired
    private RegistrovaniKorisnikService korisnikService;

    @Override
    //Ovo je metoda iz UserDetailsService mehanizma koja ce na osnovu username-a ucitati mog korisnika
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
    	try {
    		//Sa ovom metodom ja na osnovu korisnickog imena vadim ceo objekat tog korisnika
            RegistrovaniKorisnik korisnik = korisnikService.findByKorisnickoIme(username);
            
            //Ovde popunjavam listu dozvola tako sto iz dobavljenog korisnika ucitavam sve njegove uloge
            //pa pre nego sto u listu dodam ulogu ja gledam da li je taj podatak obrisan i ako nije onda
            //ubacujem naziv uloge u listu dozvola
            List<SimpleGrantedAuthority> authorities = korisnik.getUloge().stream()
                    .filter(veza -> !veza.isObrisan())
                    .map(veza -> new SimpleGrantedAuthority(veza.getUloga().getNaziv()))
                    .collect(Collectors.toList());

            //Na kraju vracam springov ugradjeni User objekat koji u sebi nosi username, lozinku i listu dozvola
            return new org.springframework.security.core.userdetails.User(
                korisnik.getKorisnickoIme(), 
                korisnik.getLozinka(), 
                authorities
            );
            
          //I onda spring uzima lozinku iz objekta provlaci je kroz BCrypt i uporedi sa hesovanom lozinkom koju sam
          //mu ja vratio u UserDetails objektu i ako se poklope korisnik je uspesno ulogovan i prelazi se na generisanje
          //jwt tokena (u JwtUtil)
            
        } catch (EntityNotFoundException e) {
            throw new UsernameNotFoundException("Korisnik nije pronađen: " + username);
        }
    }
}
