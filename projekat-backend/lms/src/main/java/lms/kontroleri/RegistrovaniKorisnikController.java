package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.RegistrovaniKorisnikDTO;
import lms.servisi.CrudService;
import lms.servisi.RegistrovaniKorisnikService;

@RestController
@RequestMapping("/api/registrovaniKorisnici")
public class RegistrovaniKorisnikController extends AbstractCrudController<RegistrovaniKorisnikDTO, Long>{
	
	@Autowired
	private RegistrovaniKorisnikService service;

	@Override
	protected CrudService<RegistrovaniKorisnikDTO, Long> getService() {
		return service;
	}
	
	@GetMapping("/username/{username}")
    public ResponseEntity<RegistrovaniKorisnikDTO> getByUsername(@PathVariable String username) {
        RegistrovaniKorisnikDTO dto = service.findDTOByKorisnickoIme(username);
        return ResponseEntity.ok(dto);
    }

}
