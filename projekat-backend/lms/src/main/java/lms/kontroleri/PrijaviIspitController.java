package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.PrijaviIspitDTO;
import lms.modeli.PrijaviIspit;
import lms.servisi.CrudService;
import lms.servisi.PrijaviIspitService;

@RestController
@RequestMapping("/api/prijave-ispita")
public class PrijaviIspitController extends AbstractCrudController<PrijaviIspitDTO, Long> {

    @Autowired
    private PrijaviIspitService service;

    @Override
    protected CrudService<PrijaviIspitDTO, Long> getService() {
        return service;
    }

    
    @GetMapping("/dostupni/{studentId}")
    public ResponseEntity<?> getDostupniZaStudenta(@PathVariable Long studentId) {
        try {
            
            return ResponseEntity.ok(service.getDostupniZaStudenta(studentId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Greška pri dohvatanju ispita.");
        }
    }

    @PostMapping("/prijavi")
    public ResponseEntity<?> prijaviIspit(@RequestBody PrijaviIspitDTO dto) {
        try {
            PrijaviIspit sacuvanaPrijava = service.prijaviIspit(dto);
            return new ResponseEntity<>(sacuvanaPrijava, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Greška prilikom prijave.");
        }
    }
}