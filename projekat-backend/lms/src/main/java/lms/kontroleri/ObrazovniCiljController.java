package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.ObrazovniCiljDTO;
import lms.servisi.CrudService;
import lms.servisi.ObrazovniCiljService;

@RestController
@RequestMapping("/api/obrazovniCiljevi")
public class ObrazovniCiljController extends AbstractCrudController<ObrazovniCiljDTO, Long>{
	
	@Autowired
	private ObrazovniCiljService service;

	@Override
	protected CrudService<ObrazovniCiljDTO, Long> getService() {
		return service;
	}

}
