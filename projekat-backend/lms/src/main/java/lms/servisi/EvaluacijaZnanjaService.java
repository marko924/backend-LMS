package lms.servisi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.EvaluacijaZnanjaDTO;
import lms.modeli.EvaluacijaZnanja;
import lms.modeli.InstrumentEvaluacije;
import lms.modeli.IspitniRok;
import lms.modeli.RealizacijaPredmeta;
import lms.modeli.TipEvaluacije;
import lms.repozitorijumi.EvaluacijaZnanjaRepository;
import lms.repozitorijumi.InstrumentEvaluacijeRepository;
import lms.repozitorijumi.IspitniRokRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.RealizacijaPredmetaRepository;
import lms.repozitorijumi.TipEvaluacijeRepository;

@Service
@Transactional(readOnly = true)
public class EvaluacijaZnanjaService extends AbstractCrusService<EvaluacijaZnanjaDTO, EvaluacijaZnanja, Long>{
	
	@Autowired
	private EvaluacijaZnanjaRepository evaluacijaZnanjaRepository;
	
	@Autowired
	private TipEvaluacijeRepository tipEvaluacijeRepository;
	
	@Autowired
	private RealizacijaPredmetaRepository realizacijaPredmetaRepository;
	
	@Autowired
	private InstrumentEvaluacijeRepository instrumentEvaluacijeRepository;
	
	@Autowired
	private IspitniRokRepository ispitniRokRepository;

	@Override
	protected LogickoBrisanjeRepozitorijum<EvaluacijaZnanja, Long> getRepository() {
		return evaluacijaZnanjaRepository;
	}

	@Override
	protected EvaluacijaZnanjaDTO toDTO(EvaluacijaZnanja entity) {
		EvaluacijaZnanjaDTO dto = new EvaluacijaZnanjaDTO();
		dto.setId(entity.getId());
		dto.setVremePocetka(entity.getVremePocetka());
		dto.setVremeZavrsetka(entity.getVremeZavrsetka());
		dto.setMaksimalniBodovi(entity.getMaksimalniBodovi());
		if(entity.getTipEvaluacije() != null) {
			dto.setTipEvaluacijeId(entity.getTipEvaluacije().getId());
		}
		if(entity.getRealizacijaPredmeta() != null) {
			dto.setRealizacijaPredmetaId(entity.getRealizacijaPredmeta().getId());
		}
		if(entity.getInstrumentEvaluacije() != null) {
			dto.setInstrumentEvaluacijeId(entity.getInstrumentEvaluacije().getId());
		}
		return dto;
	}

	@Override
	protected EvaluacijaZnanja toEntity(EvaluacijaZnanjaDTO dto) {
		EvaluacijaZnanja evaluacijaZnanja = new EvaluacijaZnanja();
		updateEntity(evaluacijaZnanja, dto);
		return evaluacijaZnanja;
	}

	@Override
	protected void updateEntity(EvaluacijaZnanja entity, EvaluacijaZnanjaDTO dto) {
		entity.setId(dto.getId());
		entity.setVremePocetka(dto.getVremePocetka());
		entity.setVremeZavrsetka(dto.getVremeZavrsetka());
		entity.setMaksimalniBodovi(dto.getMaksimalniBodovi());
		if(dto.getTipEvaluacijeId() != null) {
			TipEvaluacije tipEvaluacije = tipEvaluacijeRepository.findById(dto.getTipEvaluacijeId())
					.orElseThrow(() -> new EntityNotFoundException("Tip evaluacije nije pronađeno"));
			entity.setTipEvaluacije(tipEvaluacije);
		}
		if(dto.getRealizacijaPredmetaId() != null) {
			RealizacijaPredmeta realizacijaPredmeta = realizacijaPredmetaRepository.findById(dto.getRealizacijaPredmetaId())
					.orElseThrow(() -> new EntityNotFoundException("Realizacija predmeta nije pronađena"));
			entity.setRealizacijaPredmeta(realizacijaPredmeta);
		}
		if(dto.getInstrumentEvaluacijeId() != null) {
			InstrumentEvaluacije instrumentEvaluacije = instrumentEvaluacijeRepository.findById(dto.getInstrumentEvaluacijeId())
					.orElseThrow(() -> new EntityNotFoundException("Instrument realizacije nije pronađen"));
			entity.setInstrumentEvaluacije(instrumentEvaluacije);
		}
		
	}
	
	public EvaluacijaZnanja zakaziIspit(EvaluacijaZnanjaDTO dto) {
		
		TipEvaluacije tipEvaluacije = tipEvaluacijeRepository.findById(dto.getTipEvaluacijeId())
				.orElseThrow(() -> new EntityNotFoundException("Tip evaluacije nije pronađeno"));
		
		if (!tipEvaluacije.getNaziv().toLowerCase().equals("ispit")) {
			throw new IllegalArgumentException("Ova metoda služi isključivo za zakazivanje ISPITA!");
		}
		
        IspitniRok rok = ispitniRokRepository.findById(dto.getIspitniRokId())
            .orElseThrow(() -> new EntityNotFoundException("Ispitni rok ne postoji!"));

        if (dto.getVremePocetka().isBefore(rok.getDatumPocetka()) || 
            dto.getVremeZavrsetka().isAfter(rok.getDatumZavrsetka())) {
            throw new IllegalArgumentException("Vreme ispita mora biti unutar datuma ispitnog roka!");
        }

        EvaluacijaZnanja novaEvaluacija = toEntity(dto);
        return evaluacijaZnanjaRepository.save(novaEvaluacija);
    }

}
