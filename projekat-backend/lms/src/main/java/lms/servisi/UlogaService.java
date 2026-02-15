package lms.servisi;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lms.dtos.UlogaDTO;
import lms.modeli.Uloga;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.UlogaRepository;

@Service
@Transactional(readOnly = true)
public class UlogaService extends AbstractCrusService<UlogaDTO, Uloga, Long>{
	
	private final UlogaRepository ulogaRepository;

	public UlogaService(UlogaRepository ulogaRepository) {
		this.ulogaRepository = ulogaRepository;
	}

	@Override
	protected LogickoBrisanjeRepozitorijum<Uloga, Long> getRepository() {
		return ulogaRepository;
	}

	@Override
	protected UlogaDTO toDTO(Uloga entity) {
		UlogaDTO dto = new UlogaDTO();
		dto.setId(entity.getId());
		dto.setNaziv(entity.getNaziv());
		return dto;
	}

	@Override
	protected Uloga toEntity(UlogaDTO dto) {
		Uloga uloga = new Uloga();
		updateEntity(uloga, dto);
		return uloga;
	}

	@Override
	protected void updateEntity(Uloga entity, UlogaDTO dto) {
		entity.setId(dto.getId());
		entity.setNaziv(dto.getNaziv());
		
	}

}
