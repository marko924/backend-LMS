package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.NastavniMaterijalDTO;
import lms.servisi.CrudService;
import lms.servisi.NastavniMaterijalService;

@RestController
@RequestMapping("/api/nastavni-materijali")
public class NastavniMaterijalController extends AbstractCrudController<NastavniMaterijalDTO, Long> {

    private final NastavniMaterijalService service;

    public NastavniMaterijalController(NastavniMaterijalService service) {
        this.service = service;
    }

    @Override
    protected CrudService<NastavniMaterijalDTO, Long> getService() {
        return service;
    }
}

