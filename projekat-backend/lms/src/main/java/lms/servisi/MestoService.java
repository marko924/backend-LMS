package lms.servisi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.MestoDTO;
import lms.modeli.Drzava;
import lms.modeli.Mesto;
import lms.repozitorijumi.DrzavaRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.MestoRepository;

@Service
@Transactional(readOnly = true)
public class MestoService extends AbstractCrusService<MestoDTO, Mesto, Long>{
	
	@Autowired
	private MestoRepository mestoRepository;
	
	@Autowired
	private DrzavaRepository drzavaRepository;

	@Override
	protected LogickoBrisanjeRepozitorijum<Mesto, Long> getRepository() {
		return mestoRepository;
	}

	@Override
	protected MestoDTO toDTO(Mesto entity) {
		MestoDTO dto = new MestoDTO();
		dto.setId(entity.getId());
		dto.setNaziv(entity.getNaziv());
		
		if(entity.getDrzava() != null) {
			dto.setDrzavaId(entity.getDrzava().getId());
		}
		return dto;
	}

	@Override
	protected Mesto toEntity(MestoDTO dto) {
		Mesto mesto = new Mesto();
		updateEntity(mesto, dto);
		return mesto;
	}

	@Override
	protected void updateEntity(Mesto entity, MestoDTO dto) {
		entity.setId(dto.getId());
		entity.setNaziv(dto.getNaziv());
		if(dto.getDrzavaId() != null) {
			Drzava drzava = drzavaRepository.findById(dto.getDrzavaId())
					.orElseThrow(() -> new EntityNotFoundException("Mesto nije pronađeno"));
			entity.setDrzava(drzava);
		}
		
	}

}
