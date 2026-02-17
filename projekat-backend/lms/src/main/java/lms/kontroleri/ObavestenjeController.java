package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.ObavestenjeDTO;
import lms.servisi.CrudService;
import lms.servisi.ObavestenjeService;

@RestController
@RequestMapping("/api/obavestenja")
public class ObavestenjeController extends AbstractCrudController<ObavestenjeDTO, Long>{
	
	private final ObavestenjeService service;

	public ObavestenjeController(ObavestenjeService service) {
		this.service = service;
	}

	@Override
	protected CrudService<ObavestenjeDTO, Long> getService() {
		return service;
	}

}
