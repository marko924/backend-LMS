package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.TerminNastaveDTO;
import lms.servisi.CrudService;
import lms.servisi.TerminNastaveService;

@RestController
@RequestMapping("/api/terminiNastave")
public class TerminNastaveController extends AbstractCrudController<TerminNastaveDTO, Long> {

	@Autowired
	private TerminNastaveService service;

    

    @Override
    protected CrudService<TerminNastaveDTO, Long> getService() {
        return service;
    }
}

