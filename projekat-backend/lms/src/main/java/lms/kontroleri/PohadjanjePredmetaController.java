package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.PohadjanjePredmetaDTO;
import lms.servisi.CrudService;
import lms.servisi.PohadjanjePredmetaService;

@RestController
@RequestMapping("/api/pohadjanjaPredmeta")
public class PohadjanjePredmetaController extends AbstractCrudController<PohadjanjePredmetaDTO, Long> {

	@Autowired
	private PohadjanjePredmetaService service;

    

    @Override
    protected CrudService<PohadjanjePredmetaDTO, Long> getService() {
        return service;
    }
}
