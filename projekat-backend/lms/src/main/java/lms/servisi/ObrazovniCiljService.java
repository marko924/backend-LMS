package lms.servisi;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.ObrazovniCiljDTO;
import lms.modeli.Ishod;
import lms.modeli.IshodObrazovniCilj;
import lms.modeli.ObrazovniCilj;
import lms.repozitorijumi.IshodRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.ObrazovniCiljRepository;

@Service
@Transactional(readOnly = true)
public class ObrazovniCiljService extends AbstractCrusService<ObrazovniCiljDTO, ObrazovniCilj, Long>{
	
	@Autowired
	private ObrazovniCiljRepository obrazovniCiljRepository;
	
	@Autowired
	private IshodRepository ishodRepository;

	@Override
	protected LogickoBrisanjeRepozitorijum<ObrazovniCilj, Long> getRepository() {
		return obrazovniCiljRepository;
	}

	@Override
	protected ObrazovniCiljDTO toDTO(ObrazovniCilj entity) {
		ObrazovniCiljDTO dto = new ObrazovniCiljDTO();
		dto.setId(entity.getId());
		dto.setOpis(entity.getOpis());
		if(entity.getIshodiVeze() != null) {
    		dto.setIshodiId(entity.getIshodiVeze().stream()
    				.filter(veza -> !veza.isObrisan())
    				.map(veza -> veza.getIshod().getId())
                    .collect(Collectors.toSet()));
    	}
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
		entity.getIshodiVeze().clear();
        if (dto.getIshodiId() != null) {
            for (Long ishodId : dto.getIshodiId()) {
                Ishod ishod = ishodRepository.findById(ishodId)
                        .filter(i -> !i.isObrisan())
                        .orElseThrow(() -> new EntityNotFoundException("Ishod nije pronađen: " + ishodId));
                
                IshodObrazovniCilj novaVeza = new IshodObrazovniCilj();
                novaVeza.setIshod(ishod);
                novaVeza.setObrazovniCilj(entity);
                novaVeza.setObrisan(false);
                
                entity.getIshodiVeze().add(novaVeza);
            }
        }
	}

}
