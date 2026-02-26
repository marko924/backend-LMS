package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.TipZvanjaDTO;
import lms.servisi.CrudService;
import lms.servisi.TipZvanjaService;

@RestController
@RequestMapping("/api/tipovi-zvanja")
public class TipZvanjaController extends AbstractCrudController<TipZvanjaDTO, Long> {

	@Autowired
	TipZvanjaService service;

   

    @Override
    protected CrudService<TipZvanjaDTO, Long> getService() {
        return service;
    }
}

