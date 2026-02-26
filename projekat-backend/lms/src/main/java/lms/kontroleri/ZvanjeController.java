package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.ZvanjeDTO;
import lms.servisi.CrudService;
import lms.servisi.ZvanjeService;

@RestController
@RequestMapping("/api/zvanja")
public class ZvanjeController extends AbstractCrudController<ZvanjeDTO, Long> {

    @Autowired
    private ZvanjeService service;

    

    @Override
    protected CrudService<ZvanjeDTO, Long> getService() {
        return service;
    }
}

