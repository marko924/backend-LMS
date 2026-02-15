package lms.servisi;

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
	
	private final MestoRepository mestoRepository;
	private final DrzavaRepository drzavaRepository;

	public MestoService(MestoRepository mestoRepository, DrzavaRepository drzavaRepository) {
		super();
		this.mestoRepository = mestoRepository;
		this.drzavaRepository = drzavaRepository;
	}

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
