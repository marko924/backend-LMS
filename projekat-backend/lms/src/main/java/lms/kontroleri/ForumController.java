package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dtos.ForumDTO;
import lms.servisi.CrudService;
import lms.servisi.ForumService;

@RestController
@RequestMapping("/api/forumi")
public class ForumController extends AbstractCrudController<ForumDTO, Long>{
	
	@Autowired
	private ForumService service;

	@Override
	protected CrudService<ForumDTO, Long> getService() {
		return service;
	}

}
