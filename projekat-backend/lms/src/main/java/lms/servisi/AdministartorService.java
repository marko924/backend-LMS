package lms.servisi;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lms.dtos.AdministratorDTO;
import lms.modeli.Administartor;
import lms.repozitorijumi.AdministratorRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;

@Service
@Transactional(readOnly = true)
public class AdministartorService extends AbstractCrusService<AdministratorDTO, Administartor, Long>{
	
	private final AdministratorRepository administratorRepository;

	public AdministartorService(AdministratorRepository administratorRepository) {
		this.administratorRepository = administratorRepository;
	}

	@Override
	protected LogickoBrisanjeRepozitorijum<Administartor, Long> getRepository() {
		return administratorRepository;
	}

	@Override
	protected AdministratorDTO toDTO(Administartor entity) {
		AdministratorDTO dto = new AdministratorDTO();
		dto.setId(entity.getId());
		dto.setKorisnickoIme(entity.getKorisnickoIme());
		dto.setEmail(entity.getEmail());
		dto.setLozinka(entity.getLozinka());
		return dto;
	}

	@Override
	protected Administartor toEntity(AdministratorDTO dto) {
		Administartor administartor = new Administartor();
		updateEntity(administartor, dto);
		return administartor;
	}

	@Override
	protected void updateEntity(Administartor entity, AdministratorDTO dto) {
		entity.setId(dto.getId());
		entity.setKorisnickoIme(dto.getKorisnickoIme());
		entity.setEmail(dto.getEmail());
		entity.setLozinka(dto.getLozinka());
		
	}

}
