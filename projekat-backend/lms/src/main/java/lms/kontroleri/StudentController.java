package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.StudentDTO;
import lms.servisi.CrudService;
import lms.servisi.StudentService;

@RestController
@RequestMapping("/api/studenti")
public class StudentController extends AbstractCrudController<StudentDTO, Long> {
	
	@Autowired
    StudentService studentService;

    
    @Override
    protected CrudService<StudentDTO, Long> getService() {
        return studentService;
    }
}
