package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.TipNastaveDTO;
import lms.servisi.CrudService;
import lms.servisi.TipNastaveService;

@RestController
@RequestMapping("/api/tipovi-nastave")
public class TipNastaveController extends AbstractCrudController<TipNastaveDTO, Long> {

    private final TipNastaveService service;

    public TipNastaveController(TipNastaveService service) {
        this.service = service;
    }

    @Override
    protected CrudService<TipNastaveDTO, Long> getService() {
        return service;
    }
}
