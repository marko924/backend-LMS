package lms.repozitorijumi;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import lms.modeli.StudijskiProgram;

@Repository
public interface StudijskiProgramRepository extends LogickoBrisanjeRepozitorijum<StudijskiProgram, Long> { 
	
	@Query("SELECT DISTINCT sp FROM StudijskiProgram sp " +
	           "LEFT JOIN FETCH sp.fakultet f " +
	           "LEFT JOIN FETCH sp.rukovodilac r " +
	           "LEFT JOIN FETCH sp.godineStudija gs " +
	           "LEFT JOIN FETCH gs.predmeti p " +
	           "WHERE sp.id = :id AND sp.obrisan = false")
	Optional<StudijskiProgram> findByIdWithDetails(@Param("id") Long id);
}
