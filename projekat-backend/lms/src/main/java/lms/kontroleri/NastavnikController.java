package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.NastavnikDTO;
import lms.servisi.CrudService;
import lms.servisi.NastavnikService;

@RestController
@RequestMapping("/api/nastavnici")
public class NastavnikController extends AbstractCrudController<NastavnikDTO, Long> {

    @Autowired
    private NastavnikService service;

    

    @Override
    protected CrudService<NastavnikDTO, Long> getService() {
        return service;
    }
}

