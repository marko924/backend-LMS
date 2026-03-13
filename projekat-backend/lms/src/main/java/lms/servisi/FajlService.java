package lms.servisi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.FajlDTO;
import lms.modeli.Fajl;
import lms.modeli.InstrumentEvaluacije;
import lms.modeli.NastavniMaterijal;
import lms.modeli.Obavestenje;
import lms.modeli.Objava;
import lms.modeli.Poruka;
import lms.repozitorijumi.FajlRepository;
import lms.repozitorijumi.InstrumentEvaluacijeRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.NastavniMaterijalRepository;
import lms.repozitorijumi.ObavestenjeRepository;
import lms.repozitorijumi.ObjavaRepository;
import lms.repozitorijumi.PorukaRepository;

@Service
@Transactional(readOnly = true)
public class FajlService extends AbstractCrusService<FajlDTO, Fajl, Long>{
	
	@Autowired
	private FajlRepository fajlRepository;
	
	@Autowired
	private NastavniMaterijalRepository nastavniMaterijalRepository;
	
	@Autowired
	private InstrumentEvaluacijeRepository instrumentEvaluacijeRepository;
	
	@Autowired
	private ObavestenjeRepository obavestenjeRepository;
	
	@Autowired
	private ObjavaRepository objavaRepository;
	
	@Autowired
	private PorukaRepository porukaRepository;

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
		if(entity.getNastavniMaterijal() != null) {
			dto.setNastavniMaterijalId(entity.getNastavniMaterijal().getId());
		}
		if(entity.getInstrumentEvaluacije() != null) {
			dto.setInstrumentEvaluacijeId(entity.getInstrumentEvaluacije().getId());
		}
		if(entity.getObavestenje() != null) {
			dto.setObavestenjeId(entity.getObavestenje().getId());
		}
		if(entity.getObjava() != null) {
			dto.setObjavaId(entity.getObjava().getId());
		}
		if(entity.getPoruka() != null) {
			dto.setPorukaId(entity.getPoruka().getId());
		}
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
		if(dto.getNastavniMaterijalId() != null) {
			NastavniMaterijal nastavniMaterijal = nastavniMaterijalRepository.findById(dto.getNastavniMaterijalId())
					.orElseThrow(() -> new EntityNotFoundException("Nastavni materijal nije pronađen"));
			entity.setNastavniMaterijal(nastavniMaterijal);
		}
		if(dto.getInstrumentEvaluacijeId() != null) {
			InstrumentEvaluacije instrumentEvaluacije = instrumentEvaluacijeRepository.findById(dto.getInstrumentEvaluacijeId())
					.orElseThrow(() -> new EntityNotFoundException("Instrument evaluacije nije pronađen"));
			entity.setInstrumentEvaluacije(instrumentEvaluacije);
		}
		if(dto.getObavestenjeId() != null) {
			Obavestenje obavestenje = obavestenjeRepository.findById(dto.getObavestenjeId())
					.orElseThrow(() -> new EntityNotFoundException("Obavestenje nije pronađeno"));
			entity.setObavestenje(obavestenje);
		}
		if(dto.getObjavaId() != null) {
			Objava objava = objavaRepository.findById(dto.getObjavaId())
					.orElseThrow(() -> new EntityNotFoundException("Objava nije pronađena"));
			entity.setObjava(objava);
		}
		if(dto.getPorukaId() != null) {
			Poruka poruka = porukaRepository.findById(dto.getPorukaId())
					.orElseThrow(() -> new EntityNotFoundException("Poruka nije pronađena"));
			entity.setPoruka(poruka);
		}
	}

}
