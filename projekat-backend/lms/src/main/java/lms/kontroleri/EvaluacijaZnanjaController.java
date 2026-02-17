package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.EvaluacijaZnanjaDTO;
import lms.servisi.CrudService;
import lms.servisi.EvaluacijaZnanjaService;

@RestController
@RequestMapping("/api/evaluacijeZnanja")
public class EvaluacijaZnanjaController extends AbstractCrudController<EvaluacijaZnanjaDTO, Long>{
	
	private final EvaluacijaZnanjaService service;

	public EvaluacijaZnanjaController(EvaluacijaZnanjaService service) {
		this.service = service;
	}

	@Override
	protected CrudService<EvaluacijaZnanjaDTO, Long> getService() {
		return service;
	}

}
