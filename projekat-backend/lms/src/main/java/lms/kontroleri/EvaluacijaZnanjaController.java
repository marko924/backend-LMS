package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.EvaluacijaZnanjaDTO;
import lms.servisi.CrudService;
import lms.servisi.EvaluacijaZnanjaService;

@RestController
@RequestMapping("/api/evaluacijeZnanja")
public class EvaluacijaZnanjaController extends AbstractCrudController<EvaluacijaZnanjaDTO, Long>{
	
	@Autowired
	private EvaluacijaZnanjaService service;

	@Override
	protected CrudService<EvaluacijaZnanjaDTO, Long> getService() {
		return service;
	}
	
	@PostMapping("/zakazi-ispit")
    public ResponseEntity<?> zakaziIspit(@RequestBody EvaluacijaZnanjaDTO dto) {
        try {
        	EvaluacijaZnanjaDTO sacuvanaEvaluacijaDto = service.zakaziIspit(dto);
            return new ResponseEntity<>(sacuvanaEvaluacijaDto, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
        	e.printStackTrace(); 
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Došlo je do greške na serveru.");
        }
    }

}
