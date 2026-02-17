package lms.kontroleri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.ZvanjeDTO;
import lms.servisi.CrudService;
import lms.servisi.ZvanjeService;

@RestController
@RequestMapping("/api/zvanja")
public class ZvanjeController extends AbstractCrudController<ZvanjeDTO, Long> {

    private final ZvanjeService service;

    public ZvanjeController(ZvanjeService service) {
        this.service = service;
    }

    @Override
    protected CrudService<ZvanjeDTO, Long> getService() {
        return service;
    }
}

