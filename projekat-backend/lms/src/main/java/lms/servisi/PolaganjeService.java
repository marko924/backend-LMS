package lms.servisi;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.PolaganjeDTO;
import lms.modeli.EvaluacijaZnanja;
import lms.modeli.Polaganje;
import lms.repozitorijumi.EvaluacijaZnanjaRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.PolaganjeRepository;

@Service
@Transactional(readOnly = true)
public class PolaganjeService extends AbstractCrusService<PolaganjeDTO, Polaganje, Long>{
	
	private final PolaganjeRepository polaganjeRepository;
	private final EvaluacijaZnanjaRepository evaluacijaZnanjaRepository;

	public PolaganjeService(PolaganjeRepository polaganjeRepository,
			EvaluacijaZnanjaRepository evaluacijaZnanjaRepository) {
		super();
		this.polaganjeRepository = polaganjeRepository;
		this.evaluacijaZnanjaRepository = evaluacijaZnanjaRepository;
	}

	@Override
	protected LogickoBrisanjeRepozitorijum<Polaganje, Long> getRepository() {
		return polaganjeRepository;
	}

	@Override
	protected PolaganjeDTO toDTO(Polaganje entity) {
		PolaganjeDTO dto = new PolaganjeDTO();
		dto.setId(entity.getId());
		dto.setNapomena(entity.getNapomena());
		dto.setOsvojeniBodovi(entity.getOsvojeniBodovi());
		if(entity.getEvaluacijaZnanja() != null) {
			dto.setEvaluacijaZnanjaId(entity.getEvaluacijaZnanja().getId());
		}
		return dto;
	}

	@Override
	protected Polaganje toEntity(PolaganjeDTO dto) {
		Polaganje polaganje = new Polaganje();
		updateEntity(polaganje, dto);
		return polaganje;
	}

	@Override
	protected void updateEntity(Polaganje entity, PolaganjeDTO dto) {
		entity.setId(dto.getId());
		entity.setNapomena(dto.getNapomena());
		entity.setOsvojeniBodovi(dto.getOsvojeniBodovi());
		if(dto.getEvaluacijaZnanjaId() != null) {
			EvaluacijaZnanja evaluacijaZnanja = evaluacijaZnanjaRepository.findById(dto.getEvaluacijaZnanjaId())
					.orElseThrow(() -> new EntityNotFoundException("Evaluacija znanja nije pronađena"));
			entity.setEvaluacijaZnanja(evaluacijaZnanja);
		}
		
	}

}
