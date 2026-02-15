package lms.servisi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.InstrumentEvaluacijeDTO;
import lms.modeli.EvaluacijaZnanja;
import lms.modeli.Fajl;
import lms.modeli.InstrumentEvaluacije;
import lms.repozitorijumi.EvaluacijaZnanjaRepository;
import lms.repozitorijumi.FajlRepository;
import lms.repozitorijumi.InstrumentEvaluacijeRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;

@Service
@Transactional(readOnly = true)
public class InstrumentEvaluacijeService extends AbstractCrusService<InstrumentEvaluacijeDTO, InstrumentEvaluacije, Long>{
	
	private final InstrumentEvaluacijeRepository instrumentEvaluacijeRepository;
	private final EvaluacijaZnanjaRepository evaluacijaZnanjaRepository;
	private final FajlRepository fajlRepository;

	public InstrumentEvaluacijeService(InstrumentEvaluacijeRepository instrumentEvaluacijeRepository,
			EvaluacijaZnanjaRepository evaluacijaZnanjaRepository, FajlRepository fajlRepository) {
		this.instrumentEvaluacijeRepository = instrumentEvaluacijeRepository;
		this.evaluacijaZnanjaRepository = evaluacijaZnanjaRepository;
		this.fajlRepository = fajlRepository;
	}

	@Override
	protected LogickoBrisanjeRepozitorijum<InstrumentEvaluacije, Long> getRepository() {
		return instrumentEvaluacijeRepository;
	}

	@Override
	protected InstrumentEvaluacijeDTO toDTO(InstrumentEvaluacije entity) {
		InstrumentEvaluacijeDTO dto = new InstrumentEvaluacijeDTO();
		dto.setId(entity.getId());
		dto.setNaziv(entity.getNaziv());
		dto.setOpis(entity.getOpis());
		if(entity.getEvaluacijaZnanja() != null) {
			dto.setEvaluacijaZnanjaId(entity.getEvaluacijaZnanja().getId());
		}
		if(entity.getFajlovi() != null) {
			dto.setFajloviId(entity.getFajlovi().stream()
					.map(Fajl::getId)
					.collect(Collectors.toList()));
		}
		return dto;
	}

	@Override
	protected InstrumentEvaluacije toEntity(InstrumentEvaluacijeDTO dto) {
		InstrumentEvaluacije instrumentEvaluacije = new InstrumentEvaluacije();
		updateEntity(instrumentEvaluacije, dto);
		return instrumentEvaluacije;
	}

	@Override
	protected void updateEntity(InstrumentEvaluacije entity, InstrumentEvaluacijeDTO dto) {
		entity.setId(dto.getId());
		entity.setNaziv(dto.getNaziv());
		entity.setOpis(dto.getOpis());
		if(dto.getEvaluacijaZnanjaId() != null) {
			EvaluacijaZnanja evaluacijaZnanja = evaluacijaZnanjaRepository.findById(dto.getEvaluacijaZnanjaId())
					.orElseThrow(() -> new EntityNotFoundException("Evaluacija znanja nije pronađena"));
			entity.setEvaluacijaZnanja(evaluacijaZnanja);
		}
		if(dto.getFajloviId() != null) {
			List<Fajl> fajlovi = dto.getFajloviId().stream()
					.map(id -> fajlRepository.findById(id)
							.orElseThrow(() -> new EntityNotFoundException("Fajl ID: " + id + " nije pronađen")))
					.collect(Collectors.toList());
			entity.setFajlovi(fajlovi);
		}
		
	}

}
