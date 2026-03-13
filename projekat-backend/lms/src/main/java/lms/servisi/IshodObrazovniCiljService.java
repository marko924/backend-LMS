package lms.servisi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.IshodObrazovniCiljDTO;
import lms.modeli.Ishod;
import lms.modeli.IshodObrazovniCilj;
import lms.modeli.ObrazovniCilj;
import lms.repozitorijumi.IshodObrazovniCiljRepository;
import lms.repozitorijumi.IshodRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.ObrazovniCiljRepository;

@Service
@Transactional(readOnly = true)
public class IshodObrazovniCiljService extends AbstractCrusService<IshodObrazovniCiljDTO, IshodObrazovniCilj, Long>{
	
	@Autowired
	private IshodObrazovniCiljRepository ishodObrazovniCiljRepository;
	
	@Autowired
	private IshodRepository ishodRepository;
	
	@Autowired
    private ObrazovniCiljRepository obrazovniCiljRepository;

	@Override
	protected LogickoBrisanjeRepozitorijum<IshodObrazovniCilj, Long> getRepository() {
		return ishodObrazovniCiljRepository;
	}

	@Override
	protected IshodObrazovniCiljDTO toDTO(IshodObrazovniCilj entity) {
		IshodObrazovniCiljDTO dto = new IshodObrazovniCiljDTO();
		dto.setId(entity.getId());
		if(entity.getIshod() != null) {
			dto.setIshodId(entity.getIshod().getId());
		}
		if(entity.getObrazovniCilj() != null) {
			dto.setObrazovniCiljId(entity.getObrazovniCilj().getId());
		}
		return dto;
	}

	@Override
	protected IshodObrazovniCilj toEntity(IshodObrazovniCiljDTO dto) {
		IshodObrazovniCilj ishodObrazovniCilj = new IshodObrazovniCilj();
		updateEntity(ishodObrazovniCilj, dto);
		return null;
	}

	@Override
	protected void updateEntity(IshodObrazovniCilj entity, IshodObrazovniCiljDTO dto) {
		entity.setId(dto.getId());
		if (dto.getIshodId() != null) {
			Ishod ishod = ishodRepository.findById(dto.getIshodId())
					.orElseThrow(() -> new EntityNotFoundException("Ishod nije pronađen"));
			entity.setIshod(ishod);
		}
		if (dto.getObrazovniCiljId() != null) {
			ObrazovniCilj obrazovniCilj = obrazovniCiljRepository.findById(dto.getObrazovniCiljId())
					.orElseThrow(() -> new EntityNotFoundException("Obrazovni cilj nije pronađen"));
			entity.setObrazovniCilj(obrazovniCilj);
		}
	}

}
