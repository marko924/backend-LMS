package lms.repozitorijumi;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import lms.modeli.Univerzitet;

@Repository
public interface UniverzitetRepository extends LogickoBrisanjeRepozitorijum<Univerzitet, Long> { 
	
	@Query("SELECT u FROM Univerzitet u " +
	           "LEFT JOIN FETCH u.adresa a " +
	           "LEFT JOIN FETCH a.mesto m " +
	           "LEFT JOIN FETCH u.rektor r " +
	           "WHERE u.id = :id AND u.obrisan = false")
	Optional<Univerzitet> findByIdWithDetails(@Param("id") Long id);
}
