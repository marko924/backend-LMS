package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.IshodObrazovniCiljDTO;
import lms.servisi.CrudService;
import lms.servisi.IshodObrazovniCiljService;

@RestController
@RequestMapping("/api/ishodiObrazovniCiljevi")
public class IshodObrazovniCiljController extends AbstractCrudController<IshodObrazovniCiljDTO, Long>{

	@Autowired
	private IshodObrazovniCiljService ishodObrazovniCiljService;
	
	@Override
	protected CrudService<IshodObrazovniCiljDTO, Long> getService() {
		return ishodObrazovniCiljService;
	}

}
