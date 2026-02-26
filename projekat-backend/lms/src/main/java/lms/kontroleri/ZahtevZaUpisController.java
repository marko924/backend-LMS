package lms.kontroleri;

import lms.dtos.OdobravanjeZahtevaDTO;
import lms.dtos.ZahtevZaUpisDTO;
import lms.servisi.CrudService;
import lms.servisi.ZahtevZaUpisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/zahteviZaUpis")
public class ZahtevZaUpisController extends AbstractCrudController<ZahtevZaUpisDTO, Long> {

    @Autowired
    private ZahtevZaUpisService service;

	@Override
    protected CrudService<ZahtevZaUpisDTO, Long> getService() {
        return service;
    }

    @PutMapping("/{id}/odobri")
    public ResponseEntity<Void> odobri(@PathVariable Long id, @RequestBody OdobravanjeZahtevaDTO dto) {
    	service.odobriZahtev(id, dto.getBrojIndeksa());
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/{id}/odbij")
    public ResponseEntity<Void> odbij(@PathVariable Long id, @RequestBody String napomena) {
    	service.odbijZahtev(id, napomena);
        return ResponseEntity.ok().build();
    }
}
