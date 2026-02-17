package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.GodinaStudijaDTO;
import lms.servisi.CrudService;
import lms.servisi.GodinaStudijaService;

@RestController
@RequestMapping("/api/godine-studija")
public class GodinaStudijaController extends AbstractCrudController<GodinaStudijaDTO, Long> {

    private final GodinaStudijaService service;

    public GodinaStudijaController(GodinaStudijaService service) {
        this.service = service;
    }

    @Override
    protected CrudService<GodinaStudijaDTO, Long> getService() {
        return service;
    }
}

