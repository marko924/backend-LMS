package lms.servisi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lms.dtos.IspitniRokDTO;
import lms.modeli.IspitniRok;
import lms.repozitorijumi.IspitniRokRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;

@Service
@Transactional(readOnly = true)
public class IspitniRokService extends AbstractCrusService<IspitniRokDTO, IspitniRok, Long>{
	
	@Autowired
	private IspitniRokRepository ispitniRokRepository;

	@Override
	protected LogickoBrisanjeRepozitorijum<IspitniRok, Long> getRepository() {
		return ispitniRokRepository;
	}

	@Override
	protected IspitniRokDTO toDTO(IspitniRok entity) {
		IspitniRokDTO dto = new IspitniRokDTO();
		dto.setId(entity.getId());
		dto.setNaziv(entity.getNaziv());
		dto.setDatumPocetka(entity.getDatumPocetka());
		dto.setDatumZavrsetka(entity.getDatumZavrsetka());
		return dto;
	}

	@Override
	protected IspitniRok toEntity(IspitniRokDTO dto) {
		IspitniRok entity = new IspitniRok();
		updateEntity(entity, dto);
		return entity;
	}

	@Override
	protected void updateEntity(IspitniRok entity, IspitniRokDTO dto) {
		entity.setId(dto.getId());
		entity.setNaziv(dto.getNaziv());
		entity.setDatumPocetka(dto.getDatumPocetka());
		entity.setDatumZavrsetka(dto.getDatumZavrsetka());
	}

}
