package lms.servisi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.KorisnikNaForumuDTO;
import lms.modeli.Forum;
import lms.modeli.KorisnikNaForumu;
import lms.modeli.RegistrovaniKorisnik;
import lms.modeli.Uloga;
import lms.repozitorijumi.ForumRepository;
import lms.repozitorijumi.KorisnikNaForumuRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.RegistrovaniKorisnikRepository;
import lms.repozitorijumi.UlogaRepository;

@Service
@Transactional(readOnly = true)
public class KorisnikNaForumuService extends AbstractCrusService<KorisnikNaForumuDTO, KorisnikNaForumu, Long>{
	
	@Autowired
	private KorisnikNaForumuRepository korisnikNaForumuRepository;
	
	@Autowired
	private RegistrovaniKorisnikRepository registrovaniKorisnikRepository;
	
	@Autowired
	private ForumRepository forumRepository;
	
	@Autowired
	private UlogaRepository ulogaRepository;

	@Override
	protected LogickoBrisanjeRepozitorijum<KorisnikNaForumu, Long> getRepository() {
		return korisnikNaForumuRepository;
	}

	@Override
	protected KorisnikNaForumuDTO toDTO(KorisnikNaForumu entity) {
		KorisnikNaForumuDTO dto = new KorisnikNaForumuDTO();
		dto.setId(entity.getId());
		if(entity.getKorisnik() != null) {
			dto.setKorisnikId(entity.getKorisnik().getId());
		}
		if(entity.getUloga() != null) {
			dto.setUlogaId(entity.getUloga().getId());
		}
		if(entity.getForum() != null) {
			dto.setForumId(entity.getForum().getId());
		}
		return dto;
	}

	@Override
	protected KorisnikNaForumu toEntity(KorisnikNaForumuDTO dto) {
		KorisnikNaForumu korisnikNaForumu = new KorisnikNaForumu();
		updateEntity(korisnikNaForumu, dto);
		return korisnikNaForumu;
	}

	@Override
	protected void updateEntity(KorisnikNaForumu entity, KorisnikNaForumuDTO dto) {
		entity.setId(dto.getId());
		if(dto.getKorisnikId() != null) {
			RegistrovaniKorisnik registrovaniKorisnik = registrovaniKorisnikRepository.findById(dto.getForumId())
					.orElseThrow(() -> new EntityNotFoundException("Registrovani korisnik nije pronađen"));
			entity.setKorisnik(registrovaniKorisnik);
		}
		if(dto.getForumId() != null) {
			Forum forum = forumRepository.findById(dto.getForumId())
					.orElseThrow(() -> new EntityNotFoundException("Forum nije pronađen"));
			entity.setForum(forum);
		}
		if(dto.getUlogaId() != null) {
			Uloga uloga = ulogaRepository.findById(dto.getUlogaId())
					.orElseThrow(() -> new EntityNotFoundException("Uloga nije pronađena"));
			entity.setUloga(uloga);
		}
		
	}

}
