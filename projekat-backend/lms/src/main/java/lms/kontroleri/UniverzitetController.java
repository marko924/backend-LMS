package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.UniverzitetDTO;
import lms.servisi.CrudService;
import lms.servisi.UniverzitetService;

@RestController
@RequestMapping("/api/univerziteti")
public class UniverzitetController extends AbstractCrudController<UniverzitetDTO, Long> {

	@Autowired
	UniverzitetService service;

    

    @Override
    protected CrudService<UniverzitetDTO, Long> getService() {
        return service;
    }
}
