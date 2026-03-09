package lms.repozitorijumi;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import lms.modeli.Fakultet;

@Repository
public interface FakultetRepository extends LogickoBrisanjeRepozitorijum<Fakultet, Long> { 
	
	@Query("SELECT f FROM Fakultet f " +
	           "LEFT JOIN FETCH f.univerzitet u " +
	           "LEFT JOIN FETCH f.dekan d " +
	           "LEFT JOIN FETCH f.adresa a " +
	           "LEFT JOIN FETCH a.mesto m " +
	           "WHERE f.id = :id AND f.obrisan = false")
	Optional<Fakultet> findByIdWithDetails(@Param("id") Long id);
}
