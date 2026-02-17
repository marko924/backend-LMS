package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.AdministratorDTO;
import lms.servisi.AdministartorService;
import lms.servisi.CrudService;

@RestController
@RequestMapping("/api/adminisratori")
public class AdministratorController extends AbstractCrudController<AdministratorDTO, Long>{
	
	private final AdministartorService service;

	public AdministratorController(AdministartorService service) {
		this.service = service;
	}

	@Override
	protected CrudService<AdministratorDTO, Long> getService() {
		return service;
	}

}
