package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.TipZvanjaDTO;
import lms.servisi.CrudService;
import lms.servisi.TipZvanjaService;

@RestController
@RequestMapping("/api/tipovi-zvanja")
public class TipZvanjaController extends AbstractCrudController<TipZvanjaDTO, Long> {

    private final TipZvanjaService service;

    public TipZvanjaController(TipZvanjaService service) {
        this.service = service;
    }

    @Override
    protected CrudService<TipZvanjaDTO, Long> getService() {
        return service;
    }
}

