package lms.servisi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lms.dtos.TipEvaluacijeDTO;
import lms.modeli.TipEvaluacije;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.TipEvaluacijeRepository;

@Service
@Transactional(readOnly = true)
public class TipEvaluacijeService extends AbstractCrusService<TipEvaluacijeDTO, TipEvaluacije, Long>{
	
	@Autowired
	private TipEvaluacijeRepository tipEvaluacijeRepository;

	@Override
	protected LogickoBrisanjeRepozitorijum<TipEvaluacije, Long> getRepository() {
		return tipEvaluacijeRepository;
	}

	@Override
	protected TipEvaluacijeDTO toDTO(TipEvaluacije entity) {
		TipEvaluacijeDTO dto = new TipEvaluacijeDTO();
		dto.setId(entity.getId());
		dto.setNaziv(entity.getNaziv());
		return dto;
	}

	@Override
	protected TipEvaluacije toEntity(TipEvaluacijeDTO dto) {
		TipEvaluacije tipEvaluacije = new TipEvaluacije();
		updateEntity(tipEvaluacije, dto);
		return tipEvaluacije;
	}

	@Override
	protected void updateEntity(TipEvaluacije entity, TipEvaluacijeDTO dto) {
		entity.setId(dto.getId());
		entity.setNaziv(dto.getNaziv());
		
	}

}
