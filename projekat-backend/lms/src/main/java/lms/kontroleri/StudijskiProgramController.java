package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.StudijskiProgramDTO;
import lms.servisi.CrudService;
import lms.servisi.StudijskiProgramService;

@RestController
@RequestMapping("/api/studijskiProgrami")
public class StudijskiProgramController extends AbstractCrudController<StudijskiProgramDTO, Long> {

	@Autowired
	private StudijskiProgramService service;

    
    @Override
    protected CrudService<StudijskiProgramDTO, Long> getService() {
        return service;
    }
}

