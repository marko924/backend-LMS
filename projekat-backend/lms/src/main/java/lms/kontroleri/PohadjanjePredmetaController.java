package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.PohadjanjePredmetaDTO;
import lms.servisi.CrudService;
import lms.servisi.PohadjanjePredmetaService;

@RestController
@RequestMapping("/api/pohadjanja-predmeta")
public class PohadjanjePredmetaController extends AbstractCrudController<PohadjanjePredmetaDTO, Long> {

    private final PohadjanjePredmetaService service;

    public PohadjanjePredmetaController(PohadjanjePredmetaService service) {
        this.service = service;
    }

    @Override
    protected CrudService<PohadjanjePredmetaDTO, Long> getService() {
        return service;
    }
}
