package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.StudentNaGodiniDTO;
import lms.servisi.CrudService;
import lms.servisi.StudentNaGodiniService;

@RestController
@RequestMapping("/api/studenti-na-godini")
public class StudentNaGodiniController extends AbstractCrudController<StudentNaGodiniDTO, Long> {

    private final StudentNaGodiniService service;

    public StudentNaGodiniController(StudentNaGodiniService service) {
        this.service = service;
    }

    @Override
    protected CrudService<StudentNaGodiniDTO, Long> getService() {
        return service;
    }
}
