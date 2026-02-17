package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.InstrumentEvaluacijeDTO;
import lms.servisi.CrudService;
import lms.servisi.InstrumentEvaluacijeService;

@RestController
@RequestMapping("/api/instrumentiEvaluacije")
public class InstrumentEvaluacijeController extends AbstractCrudController<InstrumentEvaluacijeDTO, Long>{
	
	private final InstrumentEvaluacijeService service;

	public InstrumentEvaluacijeController(InstrumentEvaluacijeService service) {
		this.service = service;
	}

	@Override
	protected CrudService<InstrumentEvaluacijeDTO, Long> getService() {
		return service;
	}

}
