package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.IspitniRokDTO;
import lms.servisi.CrudService;
import lms.servisi.IspitniRokService;

@RestController
@RequestMapping("/api/ispitniRokovi")
public class IspitniRokController extends AbstractCrudController<IspitniRokDTO, Long>{

	@Autowired
	private IspitniRokService service;
	
	@Override
	protected CrudService<IspitniRokDTO, Long> getService() {
		return service;
	}

}
