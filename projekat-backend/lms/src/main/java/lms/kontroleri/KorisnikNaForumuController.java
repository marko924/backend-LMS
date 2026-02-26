package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.KorisnikNaForumuDTO;
import lms.servisi.CrudService;
import lms.servisi.KorisnikNaForumuService;

@RestController
@RequestMapping("/api/korisnikNaForumima")
public class KorisnikNaForumuController extends AbstractCrudController<KorisnikNaForumuDTO, Long>{
	
	@Autowired
	private KorisnikNaForumuService service;

	@Override
	protected CrudService<KorisnikNaForumuDTO, Long> getService() {
		return service;
	}

}
