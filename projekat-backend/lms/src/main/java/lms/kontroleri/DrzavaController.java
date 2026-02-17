package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.DrzavaDTO;
import lms.servisi.CrudService;
import lms.servisi.DrzavaService;

@RestController
@RequestMapping("/api/drzave")
public class DrzavaController extends AbstractCrudController<DrzavaDTO, Long>{
	
	private final DrzavaService service;

	public DrzavaController(DrzavaService service) {
		this.service = service;
	}

	@Override
	protected CrudService<DrzavaDTO, Long> getService() {
		return service;
	}

}
