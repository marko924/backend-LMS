package lms.servisi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.TemaDTO;
import lms.modeli.Forum;
import lms.modeli.KorisnikNaForumu;
import lms.modeli.Objava;
import lms.modeli.Tema;
import lms.repozitorijumi.ForumRepository;
import lms.repozitorijumi.KorisnikNaForumuRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.ObjavaRepository;
import lms.repozitorijumi.TemaRepository;

@Service
@Transactional(readOnly = true)
public class TemaService extends AbstractCrusService<TemaDTO, Tema, Long>{
	
	private final TemaRepository temaRepository;
	private final ForumRepository forumRepository;
	private final KorisnikNaForumuRepository korisnikNaForumuRepository;
	private final ObjavaRepository objavaRepository;

	public TemaService(TemaRepository temaRepository, ForumRepository forumRepository,
			KorisnikNaForumuRepository korisnikNaForumuRepository, ObjavaRepository objavaRepository) {
		this.temaRepository = temaRepository;
		this.forumRepository = forumRepository;
		this.korisnikNaForumuRepository = korisnikNaForumuRepository;
		this.objavaRepository = objavaRepository;
	}

	@Override
	protected LogickoBrisanjeRepozitorijum<Tema, Long> getRepository() {
		return temaRepository;
	}

	@Override
	protected TemaDTO toDTO(Tema entity) {
		TemaDTO dto = new TemaDTO();
		dto.setId(entity.getId());
		dto.setNaslov(entity.getNaslov());
		dto.setVremeKreiranja(entity.getVremeKreiranja());
		if(entity.getAutor() != null) {
			dto.setAutorId(entity.getAutor().getId());
		}
		if(entity.getForum() != null) {
			dto.setForumId(entity.getForum().getId());
		}
		if(entity.getObjave() != null) {
			dto.setObjaveId(entity.getObjave().stream()
					.map(Objava::getId)
					.collect(Collectors.toList()));
		}
		return dto;
	}

	@Override
	protected Tema toEntity(TemaDTO dto) {
		Tema tema = new Tema();
		updateEntity(tema, dto);
		return tema;
	}

	@Override
	protected void updateEntity(Tema entity, TemaDTO dto) {
		entity.setId(dto.getId());
		entity.setNaslov(dto.getNaslov());
		entity.setVremeKreiranja(dto.getVremeKreiranja());
		if(dto.getAutorId() != null) {
			KorisnikNaForumu korisnikNaForumu = korisnikNaForumuRepository.findById(dto.getAutorId())
					.orElseThrow(() -> new EntityNotFoundException("Korisnik na forumu nije pronađen"));
			entity.setAutor(korisnikNaForumu);
		}
		if(dto.getForumId() != null) {
			Forum forum = forumRepository.findById(dto.getForumId())
					.orElseThrow(() -> new EntityNotFoundException("Forum nije pronađen"));
			entity.setForum(forum);
		}
		if(dto.getObjaveId() != null) {
			List<Objava> objave = dto.getObjaveId().stream()
					.map(id -> objavaRepository.findById(id)
							.orElseThrow(() -> new EntityNotFoundException("Objava ID: " + id + " nije pronađena")))
					.collect(Collectors.toList());
			entity.setObjave(objave);
		}
		
	}

}
