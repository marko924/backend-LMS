package lms.servisi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.ObavestenjeDTO;
import lms.modeli.Fajl;
import lms.modeli.NastavnikNaRealizaciji;
import lms.modeli.Obavestenje;
import lms.modeli.RealizacijaPredmeta;
import lms.repozitorijumi.FajlRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.NastavnikNaRealizacijiRepository;
import lms.repozitorijumi.ObavestenjeRepository;
import lms.repozitorijumi.RealizacijaPredmetaRepository;

@Service
@Transactional(readOnly = true)
public class ObavestenjeService extends AbstractCrusService<ObavestenjeDTO, Obavestenje, Long>{
	
	@Autowired
	private ObavestenjeRepository obavestenjeRepository;
	
	@Autowired
	private FajlRepository fajlRepository;
	
	@Autowired
	private RealizacijaPredmetaRepository realizacijaPredmetaRepository;
	
	@Autowired
	private NastavnikNaRealizacijiRepository nastavnikNaRealizacijiRepository;

	@Override
	protected LogickoBrisanjeRepozitorijum<Obavestenje, Long> getRepository() {
		return obavestenjeRepository;
	}

	@Override
	protected ObavestenjeDTO toDTO(Obavestenje entity) {
		ObavestenjeDTO dto = new ObavestenjeDTO();
		dto.setId(entity.getId());
		dto.setNaslov(entity.getNaslov());
		dto.setDatumObjave(entity.getDatumObjave());
		dto.setSadrzaj(entity.getSadrzaj());
		if(entity.getFajlovi() != null) {
			dto.setFajloviId(entity.getFajlovi().stream()
					.map(Fajl::getId)
					.collect(Collectors.toList()));
		}
		if(entity.getRealizacijaPredmeta() != null) {
			dto.setRealizacijaPredmetaId(entity.getRealizacijaPredmeta().getId());
		}
		if(entity.getNastavnikNaRealizaciji() != null) {
			dto.setNastavnikNaRealizacijiId(entity.getNastavnikNaRealizaciji().getId());
		}
		return dto;
	}

	@Override
	protected Obavestenje toEntity(ObavestenjeDTO dto) {
		Obavestenje obavestenje = new Obavestenje();
		updateEntity(obavestenje, dto);
		return obavestenje;
	}

	@Override
	protected void updateEntity(Obavestenje entity, ObavestenjeDTO dto) {
		entity.setId(dto.getId());
		entity.setNaslov(dto.getNaslov());
		entity.setDatumObjave(dto.getDatumObjave());
		entity.setSadrzaj(dto.getSadrzaj());
		
		if(dto.getFajloviId() != null) {
			List<Fajl> fajlovi = dto.getFajloviId().stream()
					.map(id -> fajlRepository.findById(id)
							.orElseThrow(() -> new EntityNotFoundException("Fajl ID: " + id + " nije pronađen")))
					.collect(Collectors.toList());
			entity.setFajlovi(fajlovi);
		}
		
		if(dto.getRealizacijaPredmetaId() != null) {
			RealizacijaPredmeta realizacijaPredmeta = realizacijaPredmetaRepository.findById(dto.getRealizacijaPredmetaId())
					.orElseThrow(() -> new EntityNotFoundException("Realizacija predmeta nije pronađena"));
			entity.setRealizacijaPredmeta(realizacijaPredmeta);
		}
		
		if(dto.getNastavnikNaRealizacijiId() != null) {
			NastavnikNaRealizaciji nastavnikNaRealizaciji = nastavnikNaRealizacijiRepository.findById(dto.getNastavnikNaRealizacijiId())
					.orElseThrow(() -> new EntityNotFoundException("Nastavnik na realizaciji nije pronađen"));
			entity.setNastavnikNaRealizaciji(nastavnikNaRealizaciji);
		}
		
	}

}
