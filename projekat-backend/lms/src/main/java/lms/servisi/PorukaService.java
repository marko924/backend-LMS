package lms.servisi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.PorukaDTO;
import lms.modeli.Fajl;
import lms.modeli.Poruka;
import lms.modeli.RegistrovaniKorisnik;
import lms.repozitorijumi.FajlRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.PorukaRepository;
import lms.repozitorijumi.RegistrovaniKorisnikRepository;

@Service
@Transactional(readOnly = true)
public class PorukaService extends AbstractCrusService<PorukaDTO, Poruka, Long>{
	
	private final PorukaRepository porukaRepository;
	private final RegistrovaniKorisnikRepository registrovaniKorisnikRepository;
	private final FajlRepository fajlRepository;

	public PorukaService(PorukaRepository porukaRepository,
			RegistrovaniKorisnikRepository registrovaniKorisnikRepository, FajlRepository fajlRepository) {
		this.porukaRepository = porukaRepository;
		this.registrovaniKorisnikRepository = registrovaniKorisnikRepository;
		this.fajlRepository = fajlRepository;
	}

	@Override
	protected LogickoBrisanjeRepozitorijum<Poruka, Long> getRepository() {
		return porukaRepository;
	}

	@Override
	protected PorukaDTO toDTO(Poruka entity) {
		PorukaDTO dto = new PorukaDTO();
		dto.setId(entity.getId());
		dto.setNaslov(entity.getNaslov());
		dto.setSadrzaj(entity.getSadrzaj());
		dto.setVremeSlanja(entity.getVremeSlanja());
		
		if(entity.getPosiljalac() != null) {
			dto.setPosiljalacId(entity.getPosiljalac().getId());
		}
		
		if(entity.getPrimalac() != null) {
			dto.setPrimalacId(entity.getPosiljalac().getId());
		}
		
		if(entity.getFajlovi() != null) {
			dto.setFajloviId(entity.getFajlovi().stream()
					.map(Fajl::getId)
					.collect(Collectors.toList()));
		}
		
		return dto;
	}

	@Override
	protected Poruka toEntity(PorukaDTO dto) {
		Poruka poruka = new Poruka();
		updateEntity(poruka, dto);
		return poruka;
	}

	@Override
	protected void updateEntity(Poruka entity, PorukaDTO dto) {
		entity.setId(dto.getId());
		entity.setNaslov(dto.getNaslov());
		entity.setSadrzaj(dto.getSadrzaj());
		entity.setVremeSlanja(dto.getVremeSlanja());
		
		if(dto.getPosiljalacId() != null) {
			RegistrovaniKorisnik registrovaniKorisnik = registrovaniKorisnikRepository.findById(dto.getPosiljalacId())
					.orElseThrow(() -> new EntityNotFoundException("Posiljalac nije pronađen"));
			entity.setPosiljalac(registrovaniKorisnik);
		}
		
		if(dto.getPrimalacId() != null) {
			RegistrovaniKorisnik registrovaniKorisnik = registrovaniKorisnikRepository.findById(dto.getPrimalacId())
					.orElseThrow(() -> new EntityNotFoundException("Primalac nije pronađen"));
			entity.setPrimalac(registrovaniKorisnik);
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
