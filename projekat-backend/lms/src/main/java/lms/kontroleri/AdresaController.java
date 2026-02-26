package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.AdresaDTO;
import lms.servisi.AdresaService;
import lms.servisi.CrudService;

@RestController
@RequestMapping("/api/adrese")
public class AdresaController extends AbstractCrudController<AdresaDTO, Long>{
	
	@Autowired
	private AdresaService service;

	@Override
	protected CrudService<AdresaDTO, Long> getService() {
		return service;
	}

}
