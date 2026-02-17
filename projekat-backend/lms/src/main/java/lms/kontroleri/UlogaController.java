package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.UlogaDTO;
import lms.servisi.CrudService;
import lms.servisi.UlogaService;

@RestController
@RequestMapping("/api/uloge")
public class UlogaController extends AbstractCrudController<UlogaDTO, Long>{
	
	private final UlogaService service;

	public UlogaController(UlogaService service) {
		this.service = service;
	}

	@Override
	protected CrudService<UlogaDTO, Long> getService() {
		return service;
	}

}
