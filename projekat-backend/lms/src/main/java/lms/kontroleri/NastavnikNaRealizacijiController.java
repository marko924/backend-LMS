package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.NastavnikNaRealizacijiDTO;
import lms.servisi.CrudService;
import lms.servisi.NastavnikNaRealizacijiService;

@RestController
@RequestMapping("/api/nastavnici-na-realizaciji")
public class NastavnikNaRealizacijiController extends AbstractCrudController<NastavnikNaRealizacijiDTO, Long> {

    @Autowired
    private NastavnikNaRealizacijiService service;

    

    @Override
    protected CrudService<NastavnikNaRealizacijiDTO, Long> getService() {
        return service;
    }
}
