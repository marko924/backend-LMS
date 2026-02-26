package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.FajlDTO;
import lms.servisi.CrudService;
import lms.servisi.FajlService;

@RestController
@RequestMapping("/api/fajlovi")
public class FajlController extends AbstractCrudController<FajlDTO, Long>{
	
	@Autowired
	private FajlService service;

	@Override
	protected CrudService<FajlDTO, Long> getService() {
		return service;
	}

}
