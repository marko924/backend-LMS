package lms.servisi;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lms.dtos.DrzavaDTO;
import lms.modeli.Drzava;
import lms.repozitorijumi.DrzavaRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;

@Service
@Transactional(readOnly = true)
public class DrzavaService extends AbstractCrusService<DrzavaDTO, Drzava, Long>{
	
	private final DrzavaRepository drzavaRepository;

	public DrzavaService(DrzavaRepository drzavaRepository) {
		super();
		this.drzavaRepository = drzavaRepository;
	}

	@Override
	protected LogickoBrisanjeRepozitorijum<Drzava, Long> getRepository() {
		return drzavaRepository;
	}

	@Override
	protected DrzavaDTO toDTO(Drzava entity) {
		DrzavaDTO dto = new DrzavaDTO();
		dto.setId(entity.getId());
		dto.setNaziv(entity.getNaziv());
		return dto;
	}

	@Override
	protected Drzava toEntity(DrzavaDTO dto) {
		Drzava drzava = new Drzava();
		updateEntity(drzava, dto);
		return drzava;
	}

	@Override
	protected void updateEntity(Drzava entity, DrzavaDTO dto) {
		entity.setId(dto.getId());
		entity.setNaziv(dto.getNaziv());
		
	}

}
