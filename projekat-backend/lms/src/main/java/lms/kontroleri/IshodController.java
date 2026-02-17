package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.IshodDTO;
import lms.servisi.CrudService;
import lms.servisi.IshodService;

@RestController
@RequestMapping("/api/ishodi")
public class IshodController extends AbstractCrudController<IshodDTO, Long>{
	
	private final IshodService service;

	public IshodController(IshodService service) {
		this.service = service;
	}

	@Override
	protected CrudService<IshodDTO, Long> getService() {
		return service;
	}

}
