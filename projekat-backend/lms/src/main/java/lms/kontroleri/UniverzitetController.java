package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.UniverzitetDTO;
import lms.dtos.UniverzitetDetaljiDTO;
import lms.servisi.CrudService;
import lms.servisi.UniverzitetService;

@RestController
@RequestMapping("/api/univerziteti")
public class UniverzitetController extends AbstractCrudController<UniverzitetDTO, Long> {

	@Autowired
	private UniverzitetService service;

    

    @Override
    protected CrudService<UniverzitetDTO, Long> getService() {
        return service;
    }
    
    @GetMapping("/{id}/detalji")
    public ResponseEntity<UniverzitetDetaljiDTO> getDetaljiUniverziteta(@PathVariable Long id) {
        UniverzitetDetaljiDTO detalji = service.getDetaljiUniverziteta(id);
        return ResponseEntity.ok(detalji);
    }
}
