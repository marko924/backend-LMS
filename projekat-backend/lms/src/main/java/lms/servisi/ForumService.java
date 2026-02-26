package lms.servisi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.ForumDTO;
import lms.modeli.Forum;
import lms.modeli.Tema;
import lms.repozitorijumi.ForumRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.TemaRepository;

@Service
@Transactional(readOnly = true)
public class ForumService extends AbstractCrusService<ForumDTO, Forum, Long>{
	
	@Autowired
	private ForumRepository forumRepository;
	
	@Autowired
	private TemaRepository temaRepository;

	public ForumService(ForumRepository forumRepository, TemaRepository temaRepository) {
		this.forumRepository = forumRepository;
		this.temaRepository = temaRepository;
	}

	@Override
	protected LogickoBrisanjeRepozitorijum<Forum, Long> getRepository() {
		return forumRepository;
	}

	@Override
	protected ForumDTO toDTO(Forum entity) {
		ForumDTO dto = new ForumDTO();
		dto.setId(entity.getId());
		dto.setJavni(entity.isJavni());
		if(entity.getTeme() != null) {
			dto.setTemeId(entity.getTeme().stream()
					.map(Tema::getId)
					.collect(Collectors.toList()));
		}
		return dto;
	}

	@Override
	protected Forum toEntity(ForumDTO dto) {
		Forum forum = new Forum();
		updateEntity(forum, dto);
		return forum;
	}

	@Override
	protected void updateEntity(Forum entity, ForumDTO dto) {
		entity.setId(dto.getId());
		entity.setJavni(dto.isJavni());
		if(dto.getTemeId() != null) {
			List<Tema> teme = dto.getTemeId().stream()
					.map(id -> temaRepository.findById(id)
							.orElseThrow(() -> new EntityNotFoundException("Tema ID: " + id + " nije pronađen")))
					.collect(Collectors.toList());
			entity.setTeme(teme);
		}
		
	}

}
