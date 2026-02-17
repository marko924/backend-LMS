package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.StudentDTO;
import lms.servisi.CrudService;
import lms.servisi.StudentService;

@RestController
@RequestMapping("/api/studenti")
public class StudentController extends AbstractCrudController<StudentDTO, Long> {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    protected CrudService<StudentDTO, Long> getService() {
        return studentService;
    }
}
