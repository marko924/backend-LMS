package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.NaucnaOblastDTO;
import lms.servisi.CrudService;
import lms.servisi.NaucnaOblastService;

@RestController
@RequestMapping("/api/naucne-oblasti")
public class NaucnaOblastController extends AbstractCrudController<NaucnaOblastDTO, Long> {

    private final NaucnaOblastService service;

    public NaucnaOblastController(NaucnaOblastService service) {
        this.service = service;
    }

    @Override
    protected CrudService<NaucnaOblastDTO, Long> getService() {
        return service;
    }
}
