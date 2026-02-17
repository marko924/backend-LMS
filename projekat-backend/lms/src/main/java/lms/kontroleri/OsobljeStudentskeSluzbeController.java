package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.OsobljeStudentskeSluzbeDTO;
import lms.servisi.CrudService;
import lms.servisi.OsobljeStudentskeSluzbeService;

@RestController
@RequestMapping("/api/osobljeStudentskeSluzbe")
public class OsobljeStudentskeSluzbeController extends AbstractCrudController<OsobljeStudentskeSluzbeDTO, Long>{
	
	private final OsobljeStudentskeSluzbeService service;

	public OsobljeStudentskeSluzbeController(OsobljeStudentskeSluzbeService service) {
		this.service = service;
	}

	@Override
	protected CrudService<OsobljeStudentskeSluzbeDTO, Long> getService() {
		return service;
	}

}
