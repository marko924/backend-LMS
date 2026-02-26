package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.PolaganjeDTO;
import lms.servisi.CrudService;
import lms.servisi.PolaganjeService;

@RestController
@RequestMapping("/api/polaganja")
public class PolaganjeController extends AbstractCrudController<PolaganjeDTO, Long>{
	
	@Autowired
	private PolaganjeService service;

	@Override
	protected CrudService<PolaganjeDTO, Long> getService() {
		return service;
	}

}
