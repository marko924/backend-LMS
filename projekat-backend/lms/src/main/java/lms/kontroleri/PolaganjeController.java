package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.PolaganjeDTO;
import lms.servisi.CrudService;
import lms.servisi.PolaganjeService;

@RestController
@RequestMapping("/api/polaganja")
public class PolaganjeController extends AbstractCrudController<PolaganjeDTO, Long>{
	
	private final PolaganjeService service;

	public PolaganjeController(PolaganjeService service) {
		this.service = service;
	}

	@Override
	protected CrudService<PolaganjeDTO, Long> getService() {
		return service;
	}

}
