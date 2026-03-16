package lms.servisi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.RegistrovaniKorisnikDTO;
import lms.modeli.KorisnikNaForumu;
import lms.modeli.KorisnikUloga;
import lms.modeli.RegistrovaniKorisnik;
import lms.modeli.Uloga;
import lms.repozitorijumi.KorisnikNaForumuRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.RegistrovaniKorisnikRepository;
import lms.repozitorijumi.UlogaRepository;

@Service
@Transactional(readOnly = true)
public class RegistrovaniKorisnikService extends AbstractCrusService<RegistrovaniKorisnikDTO, RegistrovaniKorisnik, Long>{
	
	@Autowired
	private RegistrovaniKorisnikRepository registrovaniKorisnikRepository;
	
	@Autowired
	private KorisnikNaForumuRepository korisnikNaForumuRepository;
	
	@Autowired
	private UlogaRepository ulogaRepository;

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
	                .filter(veza -> !veza.isObrisan())
	                .map(veza -> veza.getUloga().getId())
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
		
		entity.getUloge().clear();
	    
	    if (dto.getUlogeId() != null) {
	        for (Long ulogaId : dto.getUlogeId()) {
	            Uloga uloga = ulogaRepository.findById(ulogaId)
	                    .filter(u -> !u.isObrisan())
	                    .orElseThrow(() -> new EntityNotFoundException("Uloga ID: " + ulogaId + " nije pronađena"));
	            
	            KorisnikUloga novaVeza = new KorisnikUloga();
	            novaVeza.setKorisnik(entity);
	            novaVeza.setUloga(uloga);
	            novaVeza.setObrisan(false);
	            
	            entity.getUloge().add(novaVeza);
	        }
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
	
	public boolean proveriPostojanjePoImenu(String korisnickoIme) {
	    return registrovaniKorisnikRepository.existsByKorisnickoImeAndObrisanFalse(korisnickoIme);
	}
	
	public boolean proveriPostojanjePoEmailu(String email) {
	    return registrovaniKorisnikRepository.existsByEmailAndObrisanFalse(email);
	}

}
