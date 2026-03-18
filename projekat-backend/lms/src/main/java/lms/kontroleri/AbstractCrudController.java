package lms.kontroleri;

import java.util.List;

import jakarta.validation.Valid;

import lms.servisi.CrudService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Sa ovim generickim kontrolerom uveo sam standardizaciju gde ce svaki entitet u sistemu imati iste url rute i ponasati se na identican nacin

public abstract class AbstractCrudController<DTO, ID> {

    protected abstract CrudService<DTO, ID> getService(); //ovu metodu ce implementirati samo kontroler koji ga nasledi kako bi mogao da mu 
                                                          //dostavi odgovarajuci servis
    
    @GetMapping("/{id}")
    public ResponseEntity<DTO> getOne(@PathVariable ID id) {   //@PathVariable uzima vrednost iz url-a i prosledjuje ka parametar metodi
        return ResponseEntity.ok(getService().findById(id));  //Svaka metoda ce vratiti response zbog mog ObradjivacaIzuzetaka
    }

    
    @GetMapping
    public ResponseEntity<Page<DTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(getService().findAll(pageable));
    }

    
    @GetMapping("/all")
    public ResponseEntity<List<DTO>> getAllWithoutPagination() {
        return ResponseEntity.ok(getService().findAll());
    }

    
    @PostMapping
    public ResponseEntity<DTO> create(@Valid @RequestBody DTO dto) {  //ova metoda validira pristigle json podatke iz zahteva i pretvara ih u dto objekat
        DTO saved = getService().save(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<DTO> update(@PathVariable ID id,
                                      @Valid @RequestBody DTO dto) {
        DTO updated = getService().update(id, dto);
        return ResponseEntity.ok(updated);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }
}
