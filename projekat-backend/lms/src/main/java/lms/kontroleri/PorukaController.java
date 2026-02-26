package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.PorukaDTO;
import lms.servisi.CrudService;
import lms.servisi.PorukaService;

@RestController
@RequestMapping("/api/poruke")
public class PorukaController extends AbstractCrudController<PorukaDTO, Long>{
	
	@Autowired
	private PorukaService service;

	@Override
	protected CrudService<PorukaDTO, Long> getService() {
		return service;
	}

}
