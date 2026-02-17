package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.TipEvaluacijeDTO;
import lms.servisi.CrudService;
import lms.servisi.TipEvaluacijeService;

@RestController
@RequestMapping("/api/tipoviEvaluacije")
public class TipEvaluacijeController extends AbstractCrudController<TipEvaluacijeDTO, Long>{
	
	private final TipEvaluacijeService service;

	public TipEvaluacijeController(TipEvaluacijeService service) {
		this.service = service;
	}

	@Override
	protected CrudService<TipEvaluacijeDTO, Long> getService() {
		return service;
	}

}
