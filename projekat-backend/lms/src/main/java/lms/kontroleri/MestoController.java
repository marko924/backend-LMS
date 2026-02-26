package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.MestoDTO;
import lms.servisi.CrudService;
import lms.servisi.MestoService;

@RestController
@RequestMapping("/api/mesta")
public class MestoController extends AbstractCrudController<MestoDTO, Long>{
	
	@Autowired
	private MestoService service;

	@Override
	protected CrudService<MestoDTO, Long> getService() {
		return service;
	}

}
