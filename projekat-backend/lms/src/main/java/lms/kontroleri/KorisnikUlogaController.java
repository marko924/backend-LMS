package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.KorisnikUlogaDTO;
import lms.servisi.CrudService;
import lms.servisi.KorisnikUlogaService;

@RestController
@RequestMapping("/api/korisniciUloge")
public class KorisnikUlogaController extends AbstractCrudController<KorisnikUlogaDTO, Long>{

	@Autowired
	private KorisnikUlogaService service;
	
	@Override
	protected CrudService<KorisnikUlogaDTO, Long> getService() {
		return service;
	}

}
