package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.TipNastaveDTO;
import lms.servisi.CrudService;
import lms.servisi.TipNastaveService;

@RestController
@RequestMapping("/api/tipoviNastave")
public class TipNastaveController extends AbstractCrudController<TipNastaveDTO, Long> {

	@Autowired
	private TipNastaveService service;

    

    @Override
    protected CrudService<TipNastaveDTO, Long> getService() {
        return service;
    }
}
