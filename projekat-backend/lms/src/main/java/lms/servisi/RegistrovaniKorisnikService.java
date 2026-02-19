package lms.servisi;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.RegistrovaniKorisnikDTO;
import lms.modeli.KorisnikNaForumu;
import lms.modeli.RegistrovaniKorisnik;
import lms.modeli.Uloga;
import lms.repozitorijumi.KorisnikNaForumuRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.RegistrovaniKorisnikRepository;
import lms.repozitorijumi.UlogaRepository;

@Service
@Transactional(readOnly = true)
public class RegistrovaniKorisnikService extends AbstractCrusService<RegistrovaniKorisnikDTO, RegistrovaniKorisnik, Long>{
	
	private final RegistrovaniKorisnikRepository registrovaniKorisnikRepository;
	private final KorisnikNaForumuRepository korisnikNaForumuRepository;
	private final UlogaRepository ulogaRepository;

	public RegistrovaniKorisnikService(RegistrovaniKorisnikRepository registrovaniKorisnikRepository, KorisnikNaForumuRepository korisnikNaForumuRepository, UlogaRepository ulogaRepository) {
		this.registrovaniKorisnikRepository = registrovaniKorisnikRepository;
		this.korisnikNaForumuRepository = korisnikNaForumuRepository;
		this.ulogaRepository = ulogaRepository;
	}

	@Override
	protected LogickoBrisanjeRepozitorijum<RegistrovaniKorisnik, Long> getRepository() {
		return registrovaniKorisnikRepository;
	}

	@Override
	protected RegistrovaniKorisnikDTO toDTO(RegistrovaniKorisnik entity) {
		RegistrovaniKorisnikDTO dto = new RegistrovaniKorisnikDTO();
		dto.setId(entity.getId());
		dto.setKorisnickoIme(entity.getKorisnickoIme());
		dto.setEmail(entity.getEmail());
		dto.setLozinka(entity.getLozinka());
		
		if (entity.getClanstvaNaForumima() != null) {
			dto.setClanstvaNaForumimaId(entity.getClanstvaNaForumima().stream()
					.map(KorisnikNaForumu::getId)
					.collect(Collectors.toList()));
		}
		
		if (entity.getUloge() != null) {
			dto.setUlogeId(entity.getUloge().stream()
					.map(Uloga::getId)
					.collect(Collectors.toSet()));
		}
		
		return dto;
	}

	@Override
	protected RegistrovaniKorisnik toEntity(RegistrovaniKorisnikDTO dto) {
		RegistrovaniKorisnik registrovaniKorisnik = new RegistrovaniKorisnik();
		updateEntity(registrovaniKorisnik, dto);
		return registrovaniKorisnik;
	}

	@Override
	protected void updateEntity(RegistrovaniKorisnik entity, RegistrovaniKorisnikDTO dto) {
		entity.setId(dto.getId());
		entity.setKorisnickoIme(dto.getKorisnickoIme());
		entity.setEmail(dto.getEmail());
		entity.setLozinka(dto.getLozinka());
		
		if (dto.getClanstvaNaForumimaId() != null) {
			List<KorisnikNaForumu> korisnikNaForumima = dto.getClanstvaNaForumimaId().stream()
					.map(id -> korisnikNaForumuRepository.findById(id)
							.orElseThrow(() -> new EntityNotFoundException("Korisnik na forumu ID: " + id + " nije pronađen")))
					.collect(Collectors.toList());
			entity.setClanstvaNaForumima(korisnikNaForumima);
		}
		
		if (dto.getUlogeId() != null) {
			Set<Uloga> uloge = dto.getUlogeId().stream()
					.map(id -> ulogaRepository.findById(id)
							.orElseThrow(() -> new EntityNotFoundException("Uloga ID: " + id + " nije pronađen")))
					.collect(Collectors.toSet());
			entity.setUloge(uloge);
		}
		
	}
	
	public RegistrovaniKorisnik findByKorisnickoIme(String korisnickoIme) {
	    return registrovaniKorisnikRepository.findByKorisnickoImeAndObrisanFalse(korisnickoIme)
	            .orElseThrow(() -> new EntityNotFoundException("Korisnik sa imenom '" + korisnickoIme + "' nije pronađen ili je obrisan."));
	}
	
	public RegistrovaniKorisnikDTO findDTOByKorisnickoIme(String korisnickoIme) {
	    RegistrovaniKorisnik korisnik = findByKorisnickoIme(korisnickoIme);
	    return toDTO(korisnik);
	}

}
