package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.GodinaStudijaDTO;
import lms.servisi.CrudService;
import lms.servisi.GodinaStudijaService;

@RestController
@RequestMapping("/api/godine-studija")
public class GodinaStudijaController extends AbstractCrudController<GodinaStudijaDTO, Long> {

	@Autowired
	private GodinaStudijaService service;

    

    @Override
    protected CrudService<GodinaStudijaDTO, Long> getService() {
        return service;
    }
}

