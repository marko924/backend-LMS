package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.PredmetDTO;
import lms.servisi.CrudService;
import lms.servisi.PredmetService;

@RestController
@RequestMapping("/api/predmeti")
public class PredmetController extends AbstractCrudController<PredmetDTO, Long> {

    private final PredmetService service;

    public PredmetController(PredmetService service) {
        this.service = service;
    }

    @Override
    protected CrudService<PredmetDTO, Long> getService() {
        return service;
    }
}
