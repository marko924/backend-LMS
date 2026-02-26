package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.TemaDTO;
import lms.servisi.CrudService;
import lms.servisi.TemaService;

@RestController
@RequestMapping("/api/teme")
public class TemaController extends AbstractCrudController<TemaDTO, Long>{
	
	@Autowired
	private TemaService service;

	@Override
	protected CrudService<TemaDTO, Long> getService() {
		return service;
	}

}
