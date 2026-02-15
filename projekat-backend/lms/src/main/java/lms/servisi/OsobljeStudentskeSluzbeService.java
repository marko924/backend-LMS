package lms.servisi;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lms.dtos.OsobljeStudentskeSluzbeDTO;
import lms.modeli.OsobljeStudentskeSluzbe;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.OsobljeStudentskeSluzbeRepository;

@Service
@Transactional(readOnly = true)
public class OsobljeStudentskeSluzbeService extends AbstractCrusService<OsobljeStudentskeSluzbeDTO, OsobljeStudentskeSluzbe, Long>{
	
	private final OsobljeStudentskeSluzbeRepository osobljeStudentskeSluzbeRepository;

	public OsobljeStudentskeSluzbeService(OsobljeStudentskeSluzbeRepository osobljeStudentskeSluzbeRepository) {
		this.osobljeStudentskeSluzbeRepository = osobljeStudentskeSluzbeRepository;
	}

	@Override
	protected LogickoBrisanjeRepozitorijum<OsobljeStudentskeSluzbe, Long> getRepository() {
		return osobljeStudentskeSluzbeRepository;
	}

	@Override
	protected OsobljeStudentskeSluzbeDTO toDTO(OsobljeStudentskeSluzbe entity) {
		OsobljeStudentskeSluzbeDTO dto = new OsobljeStudentskeSluzbeDTO();
		dto.setId(entity.getId());
		dto.setKorisnickoIme(entity.getKorisnickoIme());
		dto.setEmail(entity.getEmail());
		dto.setLozinka(entity.getLozinka());
		dto.setIme(entity.getIme());
		dto.setPrezime(entity.getPrezime());
		return dto;
	}

	@Override
	protected OsobljeStudentskeSluzbe toEntity(OsobljeStudentskeSluzbeDTO dto) {
		OsobljeStudentskeSluzbe osobljeStudentskeSluzbe = new OsobljeStudentskeSluzbe();
		updateEntity(osobljeStudentskeSluzbe, dto);
		return osobljeStudentskeSluzbe;
	}

	@Override
	protected void updateEntity(OsobljeStudentskeSluzbe entity, OsobljeStudentskeSluzbeDTO dto) {
		entity.setId(dto.getId());
		entity.setKorisnickoIme(dto.getKorisnickoIme());
		entity.setEmail(dto.getEmail());
		entity.setLozinka(dto.getLozinka());
		entity.setIme(dto.getIme());
		entity.setPrezime(dto.getPrezime());
		
	}

}
