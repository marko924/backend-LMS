package lms.kontroleri;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.UlogaDTO;
import lms.servisi.CrudService;
import lms.servisi.UlogaService;

@RestController
@RequestMapping("/api/uloge")
public class UlogaController extends AbstractCrudController<UlogaDTO, Long>{
	
	private final UlogaService service;

	public UlogaController(UlogaService service) {
		this.service = service;
	}

	@Override
	protected CrudService<UlogaDTO, Long> getService() {
		return service;
	}
	
	@GetMapping("/naziv/{naziv}")
    public ResponseEntity<UlogaDTO> getByNaziv(@PathVariable String naziv) {
        // Pozivamo servisnu metodu
        UlogaDTO dto = service.findDTOByNaziv(naziv);
        return ResponseEntity.ok(dto);
    }

}
