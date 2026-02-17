package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.RealizacijaPredmetaDTO;
import lms.servisi.CrudService;
import lms.servisi.RealizacijaPredmetaService;

@RestController
@RequestMapping("/api/realizacije-predmeta")
public class RealizacijaPredmetaController extends AbstractCrudController<RealizacijaPredmetaDTO, Long> {

    private final RealizacijaPredmetaService service;

    public RealizacijaPredmetaController(RealizacijaPredmetaService service) {
        this.service = service;
    }

    @Override
    protected CrudService<RealizacijaPredmetaDTO, Long> getService() {
        return service;
    }
}
