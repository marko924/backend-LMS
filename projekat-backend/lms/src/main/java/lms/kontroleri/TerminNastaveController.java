package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.TerminNastaveDTO;
import lms.servisi.CrudService;
import lms.servisi.TerminNastaveService;

@RestController
@RequestMapping("/api/termini-nastave")
public class TerminNastaveController extends AbstractCrudController<TerminNastaveDTO, Long> {

    private final TerminNastaveService service;

    public TerminNastaveController(TerminNastaveService service) {
        this.service = service;
    }

    @Override
    protected CrudService<TerminNastaveDTO, Long> getService() {
        return service;
    }
}

