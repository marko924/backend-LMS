package lms.servisi;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lms.dtos.FajlDTO;
import lms.modeli.Fajl;
import lms.repozitorijumi.FajlRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;

@Service
@Transactional(readOnly = true)
public class FajlService extends AbstractCrusService<FajlDTO, Fajl, Long>{
	
	private final FajlRepository fajlRepository;

	public FajlService(FajlRepository fajlRepository) {
		super();
		this.fajlRepository = fajlRepository;
	}

	@Override
	protected LogickoBrisanjeRepozitorijum<Fajl, Long> getRepository() {
		return fajlRepository;
	}

	@Override
	protected FajlDTO toDTO(Fajl entity) {
		FajlDTO dto = new FajlDTO();
		dto.setId(entity.getId());
		dto.setOpis(entity.getOpis());
		dto.setUrl(entity.getUrl());
		return dto;
	}

	@Override
	protected Fajl toEntity(FajlDTO dto) {
		Fajl fajl = new Fajl();
		updateEntity(fajl, dto);
		return fajl;
	}

	@Override
	protected void updateEntity(Fajl entity, FajlDTO dto) {
		entity.setId(dto.getId());
		entity.setOpis(dto.getOpis());
		entity.setUrl(dto.getUrl());
		
	}

}
