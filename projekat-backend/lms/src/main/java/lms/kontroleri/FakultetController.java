package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.FakultetDTO;
import lms.servisi.CrudService;
import lms.servisi.FakultetService;

@RestController
@RequestMapping("/api/fakulteti")
public class FakultetController extends AbstractCrudController<FakultetDTO, Long> {

	@Autowired
	FakultetService service;

   

    @Override
    protected CrudService<FakultetDTO, Long> getService() {
        return service;
    }
}
