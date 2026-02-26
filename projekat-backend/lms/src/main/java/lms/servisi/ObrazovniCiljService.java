package lms.servisi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lms.dtos.ObrazovniCiljDTO;
import lms.modeli.ObrazovniCilj;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.ObrazovniCiljRepository;

@Service
@Transactional(readOnly = true)
public class ObrazovniCiljService extends AbstractCrusService<ObrazovniCiljDTO, ObrazovniCilj, Long>{
	
	@Autowired
	private ObrazovniCiljRepository obrazovniCiljRepository;

	@Override
	protected LogickoBrisanjeRepozitorijum<ObrazovniCilj, Long> getRepository() {
		return obrazovniCiljRepository;
	}

	@Override
	protected ObrazovniCiljDTO toDTO(ObrazovniCilj entity) {
		ObrazovniCiljDTO dto = new ObrazovniCiljDTO();
		dto.setId(entity.getId());
		dto.setOpis(entity.getOpis());
		return dto;
	}

	@Override
	protected ObrazovniCilj toEntity(ObrazovniCiljDTO dto) {
		ObrazovniCilj obrazovniCilj = new ObrazovniCilj();
		updateEntity(obrazovniCilj, dto);
		return obrazovniCilj;
	}

	@Override
	protected void updateEntity(ObrazovniCilj entity, ObrazovniCiljDTO dto) {
		entity.setId(dto.getId());
		entity.setOpis(dto.getOpis());
		
	}

}
