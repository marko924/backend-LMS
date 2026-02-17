package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.ObjavaDTO;
import lms.servisi.CrudService;
import lms.servisi.ObjavaService;

@RestController
@RequestMapping("/api/objave")
public class ObjavaController extends AbstractCrudController<ObjavaDTO, Long>{
	
	private final ObjavaService service;

	public ObjavaController(ObjavaService service) {
		this.service = service;
	}

	@Override
	protected CrudService<ObjavaDTO, Long> getService() {
		return service;
	}

}
