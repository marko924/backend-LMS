package lms.repozitorijumi;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import lms.modeli.RegistrovaniKorisnik;

@Repository
public interface RegistrovaniKorisnikRepository extends LogickoBrisanjeRepozitorijum<RegistrovaniKorisnik, Long>{

	Optional<RegistrovaniKorisnik> findByKorisnickoImeAndObrisanFalse(String korisnickoIme);
	
	boolean existsByKorisnickoImeAndObrisanFalse(String korisnickoIme);
	
	boolean existsByEmailAndObrisanFalse(String email);
}
