package lms.repozitorijumi;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import lms.modeli.Uloga;

@Repository
public interface UlogaRepository extends LogickoBrisanjeRepozitorijum<Uloga, Long>{

	Optional<Uloga> findByNaziv(String naziv);
}
