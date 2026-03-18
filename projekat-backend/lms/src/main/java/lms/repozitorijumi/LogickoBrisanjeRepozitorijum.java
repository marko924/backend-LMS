package lms.repozitorijumi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

//Ovaj interfejs predstavlja moj genricki sablon za ostale repozitorijume
@NoRepositoryBean //sa ovim sam rekao da JPA ne napravi instancu od ovog repozitorijuma vec da on samo sluzi za nasledjivanje
public interface LogickoBrisanjeRepozitorijum<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
	//Iz JpaRepository<T, ID> mi stizu standardne crud operacije za bilo koji entitet
	//JpaSpecificationExecutor<T> mi omogucava da navedem specifikaciju za repozitorijum koja dinamicki upisuje WHERE sql upite
}