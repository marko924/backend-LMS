package lms.servisi;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.AdresaDTO;
import lms.modeli.Adresa;
import lms.modeli.Mesto;
import lms.repozitorijumi.AdresaRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.MestoRepository;

@Service
@Transactional(readOnly = true)
public class AdresaService extends AbstractCrusService<AdresaDTO, Adresa, Long>{
	
	private final AdresaRepository adresaRepository;
	private final MestoRepository mestoRepository;

	public AdresaService(AdresaRepository adresaRepository, MestoRepository mestoRepository) {
		super();
		this.adresaRepository = adresaRepository;
		this.mestoRepository = mestoRepository;
	}

	@Override
	protected LogickoBrisanjeRepozitorijum<Adresa, Long> getRepository() {
		return adresaRepository;
	}

	@Override
	protected AdresaDTO toDTO(Adresa entity) {
		AdresaDTO dto = new AdresaDTO();
		dto.setId(entity.getId());
		dto.setUlica(entity.getUlica());
		dto.setBroj(entity.getBroj());
		if(entity.getMesto() != null) {
			dto.setMestoId(entity.getMesto().getId());
		}
		return dto;
	}

	@Override
	protected Adresa toEntity(AdresaDTO dto) {
		Adresa adresa = new Adresa();
		updateEntity(adresa, dto);
		return adresa;
	}

	@Override
	protected void updateEntity(Adresa entity, AdresaDTO dto) {
		entity.setId(dto.getId());
		entity.setUlica(dto.getUlica());
		entity.setBroj(dto.getBroj());
		if(dto.getMestoId() != null) {
			Mesto mesto = mestoRepository.findById(dto.getMestoId())
					.orElseThrow(() -> new EntityNotFoundException("Mesto nije pronađeno"));
			entity.setMesto(mesto);
		}
		
	}

}
