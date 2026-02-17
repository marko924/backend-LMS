package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.KorisnikNaForumuDTO;
import lms.servisi.CrudService;
import lms.servisi.KorisnikNaForumuService;

@RestController
@RequestMapping("/api/korisnikNaForumima")
public class KorisnikNaForumuController extends AbstractCrudController<KorisnikNaForumuDTO, Long>{
	
	private final KorisnikNaForumuService service;

	public KorisnikNaForumuController(KorisnikNaForumuService service) {
		this.service = service;
	}

	@Override
	protected CrudService<KorisnikNaForumuDTO, Long> getService() {
		return service;
	}

}
