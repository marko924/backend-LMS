package lms.servisi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.KorisnikUlogaDTO;
import lms.modeli.KorisnikUloga;
import lms.modeli.RegistrovaniKorisnik;
import lms.modeli.Uloga;
import lms.repozitorijumi.KorisnikUlogaRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.RegistrovaniKorisnikRepository;
import lms.repozitorijumi.UlogaRepository;

@Service
public class KorisnikUlogaService extends AbstractCrusService<KorisnikUlogaDTO, KorisnikUloga, Long>{
	
	@Autowired
	private KorisnikUlogaRepository korisnikUlogaRepository;
	
	@Autowired
	private RegistrovaniKorisnikRepository registrovaniKorisnikRepository;
	
	@Autowired
	private UlogaRepository ulogaRepository;

	@Override
	protected LogickoBrisanjeRepozitorijum<KorisnikUloga, Long> getRepository() {
		// TODO Auto-generated method stub
		return korisnikUlogaRepository;
	}

	@Override
	protected KorisnikUlogaDTO toDTO(KorisnikUloga entity) {
		KorisnikUlogaDTO dto = new KorisnikUlogaDTO();
		dto.setId(entity.getId());
		if(entity.getKorisnik() != null) {
			dto.setKorisnikId(entity.getKorisnik().getId());
		}
		if(entity.getUloga() != null) {
			dto.setUlogaId(entity.getUloga().getId());
		}
		return dto;
	}

	@Override
	protected KorisnikUloga toEntity(KorisnikUlogaDTO dto) {
		KorisnikUloga korisnikUloga = new KorisnikUloga();
		updateEntity(korisnikUloga, dto);
		return korisnikUloga;
	}

	@Override
	protected void updateEntity(KorisnikUloga entity, KorisnikUlogaDTO dto) {
		entity.setId(dto.getId());
		if(dto.getKorisnikId() != null) {
			RegistrovaniKorisnik registrovaniKorisnik = registrovaniKorisnikRepository.findById(dto.getKorisnikId())
					.orElseThrow(() -> new EntityNotFoundException("Registrovani korisnik nije pronađen"));
			entity.setKorisnik(registrovaniKorisnik);
		}
		if(dto.getUlogaId() != null) {
			Uloga uloga = ulogaRepository.findById(dto.getUlogaId())
					.orElseThrow(() -> new EntityNotFoundException("Uloga nije pronađena"));
			entity.setUloga(uloga);
		}
	}

}
