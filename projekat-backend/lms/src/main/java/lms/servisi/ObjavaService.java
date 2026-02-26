package lms.servisi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.ObjavaDTO;
import lms.modeli.Fajl;
import lms.modeli.KorisnikNaForumu;
import lms.modeli.Objava;
import lms.modeli.Tema;
import lms.repozitorijumi.FajlRepository;
import lms.repozitorijumi.KorisnikNaForumuRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.ObjavaRepository;
import lms.repozitorijumi.TemaRepository;

@Service
@Transactional(readOnly = true)
public class ObjavaService extends AbstractCrusService<ObjavaDTO, Objava, Long>{
	
	@Autowired
	private ObjavaRepository objavaRepository;
	
	@Autowired
	private TemaRepository temaRepository;
	
	@Autowired
	private KorisnikNaForumuRepository korisnikNaForumuRepository;
	
	@Autowired
	private FajlRepository fajlRepository;

	@Override
	protected LogickoBrisanjeRepozitorijum<Objava, Long> getRepository() {
		return objavaRepository;
	}

	@Override
	protected ObjavaDTO toDTO(Objava entity) {
		ObjavaDTO dto = new ObjavaDTO();
		dto.setId(entity.getId());
		dto.setSadrzaj(entity.getSadrzaj());
		dto.setVremeObjave(entity.getVremeObjave());
		if(entity.getTema() != null) {
			dto.setTemaId(entity.getTema().getId());
		}
		if(entity.getAutor() != null) {
			dto.setAutorId(entity.getAutor().getId());
		}
		if(entity.getFajlovi() != null) {
			dto.setFajloviId(entity.getFajlovi().stream()
					.map(Fajl::getId)
					.collect(Collectors.toList()));
		}
		return dto;
	}

	@Override
	protected Objava toEntity(ObjavaDTO dto) {
		Objava objava = new Objava();
		updateEntity(objava, dto);
		return objava;
	}

	@Override
	protected void updateEntity(Objava entity, ObjavaDTO dto) {
		entity.setId(dto.getId());
		entity.setSadrzaj(dto.getSadrzaj());
		entity.setVremeObjave(dto.getVremeObjave());
		if(dto.getTemaId() != null) {
			Tema tema = temaRepository.findById(dto.getTemaId())
					.orElseThrow(() -> new EntityNotFoundException("Tema nije pronađena"));
			entity.setTema(tema);
		}
		if(dto.getAutorId() != null) {
			KorisnikNaForumu korisnikNaForumu = korisnikNaForumuRepository.findById(dto.getAutorId())
					.orElseThrow(() -> new EntityNotFoundException("Korisnik na forumu nije pronađen"));
			entity.setAutor(korisnikNaForumu);
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
