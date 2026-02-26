package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.TipEvaluacijeDTO;
import lms.servisi.CrudService;
import lms.servisi.TipEvaluacijeService;

@RestController
@RequestMapping("/api/tipoviEvaluacije")
public class TipEvaluacijeController extends AbstractCrudController<TipEvaluacijeDTO, Long>{
	
	@Autowired
	private TipEvaluacijeService service;

	@Override
	protected CrudService<TipEvaluacijeDTO, Long> getService() {
		return service;
	}

}
