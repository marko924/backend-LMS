package lms.servisi;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudService<T, ID> {
	//Čuva novi zapis ili ažurira postojeći.
    T save(T dto);

    /**
     * Pronalazi objekat na osnovu ID-a.
     * Baca EntityNotFoundException ako objekat ne postoji ili je logički obrisan.
     */
    T findById(ID id);

    //Vraća listu svih objekata koji nisu logički obrisani.
    List<T> findAll();

    /**
     * Vraća paginiranu listu objekata koji nisu logički obrisani.
     * Podržava sortiranje i filtriranje po stranicama.
     */
    Page<T> findAll(Pageable pageable);

    //Ažurira postojeći objekat na osnovu ID-a i podataka iz DTO-a.
    T update(ID id, T dto);

    //Logički briše objekat postavljanje polja 'deleted' na true.
    void delete(ID id);
}
