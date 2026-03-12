package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.StudijskiProgramDTO;
import lms.dtos.StudijskiProgramDetaljiDTO;
import lms.servisi.CrudService;
import lms.servisi.StudijskiProgramService;

@RestController
@RequestMapping("/api/studijskiProgrami")
public class StudijskiProgramController extends AbstractCrudController<StudijskiProgramDTO, Long> {

	@Autowired
	private StudijskiProgramService service;

    
    @Override
    protected CrudService<StudijskiProgramDTO, Long> getService() {
        return service;
    }
    
    @GetMapping("/{id}/detalji")
    public ResponseEntity<StudijskiProgramDetaljiDTO> getDetaljiPrograma(@PathVariable Long id) {
        StudijskiProgramDetaljiDTO detalji = service.getDetaljiPrograma(id);
        return ResponseEntity.ok(detalji);
    }
}

