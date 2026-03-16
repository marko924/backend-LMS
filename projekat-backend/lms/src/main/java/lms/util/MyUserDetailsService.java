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

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
    private RegistrovaniKorisnikService korisnikService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
    	try {
            RegistrovaniKorisnik korisnik = korisnikService.findByKorisnickoIme(username);
            
            List<SimpleGrantedAuthority> authorities = korisnik.getUloge().stream()
                    .filter(veza -> !veza.isObrisan())
                    .map(veza -> new SimpleGrantedAuthority(veza.getUloga().getNaziv()))
                    .collect(Collectors.toList());

            return new org.springframework.security.core.userdetails.User(
                korisnik.getKorisnickoIme(), 
                korisnik.getLozinka(), 
                authorities
            );
        } catch (EntityNotFoundException e) {
            throw new UsernameNotFoundException("Korisnik nije pronađen: " + username);
        }
    }
}
