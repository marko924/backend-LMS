package lms.servisi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lms.dtos.TipNastaveDTO;
import lms.modeli.TipNastave;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.TipNastaveRepository;

@Service
@Transactional(readOnly = true)
public class TipNastaveService extends AbstractCrusService<TipNastaveDTO, TipNastave, Long> {

    @Autowired
	TipNastaveRepository tipNastaveRepository;

    

    @Override
    protected LogickoBrisanjeRepozitorijum<TipNastave, Long> getRepository() {
        return tipNastaveRepository;
    }

    @Override
    protected TipNastaveDTO toDTO(TipNastave entity) {
        TipNastaveDTO dto = new TipNastaveDTO();
        dto.setId(entity.getId());
        dto.setNaziv(entity.getNaziv());
        return dto;
    }

    @Override
    protected TipNastave toEntity(TipNastaveDTO dto) {
        TipNastave entity = new TipNastave();
        updateEntity(entity, dto);
        return entity;
    }

    @Override
    protected void updateEntity(TipNastave entity, TipNastaveDTO dto) {
        entity.setId(dto.getId());
        entity.setNaziv(dto.getNaziv());
    }
}
