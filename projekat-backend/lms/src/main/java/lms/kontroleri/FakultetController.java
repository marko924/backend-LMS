package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.FakultetDTO;
import lms.dtos.FakultetDetaljiDTO;
import lms.servisi.CrudService;
import lms.servisi.FakultetService;

@RestController
@RequestMapping("/api/fakulteti")
public class FakultetController extends AbstractCrudController<FakultetDTO, Long> {

	@Autowired
	private FakultetService service;

   

    @Override
    protected CrudService<FakultetDTO, Long> getService() {
        return service;
    }
    
    @GetMapping("/{id}/detalji")
    public ResponseEntity<FakultetDetaljiDTO> getDetaljiFakulteta(@PathVariable Long id) {
        FakultetDetaljiDTO detalji = service.getDetaljiFakulteta(id);
        return ResponseEntity.ok(detalji);
    }
}
