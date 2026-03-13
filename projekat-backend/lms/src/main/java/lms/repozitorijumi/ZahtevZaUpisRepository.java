package lms.repozitorijumi;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lms.modeli.StatusZahteva;
import lms.modeli.ZahtevZaUpis;

@Repository
public interface ZahtevZaUpisRepository extends LogickoBrisanjeRepozitorijum<ZahtevZaUpis, Long>{

	@Query("SELECT z FROM ZahtevZaUpis z " +
	           "JOIN FETCH z.student s " +
	           "JOIN FETCH z.fakultet f " +
	           "JOIN FETCH z.studijskiProgram sp " +
	           "JOIN FETCH z.godinaStudija gs " +
	           "WHERE z.status = :status AND z.obrisan = false " +
	           "ORDER BY z.vremePodnosenja ASC")
	List<ZahtevZaUpis> findAllByStatusWithDetails(@Param("status") StatusZahteva status);
}
