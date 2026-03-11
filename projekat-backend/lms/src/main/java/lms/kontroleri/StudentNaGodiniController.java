package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.StudentNaGodiniDTO;
import lms.servisi.CrudService;
import lms.servisi.StudentNaGodiniService;

@RestController
@RequestMapping("/api/studentiNaGodini")
public class StudentNaGodiniController extends AbstractCrudController<StudentNaGodiniDTO, Long> {
	
	@Autowired
	private StudentNaGodiniService service;

   

    @Override
    protected CrudService<StudentNaGodiniDTO, Long> getService() {
        return service;
    }
}
