package lms.servisi;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lms.dtos.TipZvanjaDTO;
import lms.modeli.TipZvanja;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.TipZvanjaRepository;

@Service
@Transactional(readOnly = true)
public class TipZvanjaService extends AbstractCrusService<TipZvanjaDTO, TipZvanja, Long> {

    private final TipZvanjaRepository tipZvanjaRepository;

    public TipZvanjaService(TipZvanjaRepository tipZvanjaRepository) {
        this.tipZvanjaRepository = tipZvanjaRepository;
    }

    @Override
    protected LogickoBrisanjeRepozitorijum<TipZvanja, Long> getRepository() {
        return tipZvanjaRepository;
    }

   
    @Override
    protected TipZvanjaDTO toDTO(TipZvanja entity) {
        TipZvanjaDTO dto = new TipZvanjaDTO();
        dto.setId(entity.getId());
        dto.setNaziv(entity.getNaziv());
        return dto;
    }

    
    @Override
    protected TipZvanja toEntity(TipZvanjaDTO dto) {
        TipZvanja entity = new TipZvanja();
        updateEntity(entity, dto);
        return entity;
    }

    
    @Override
    protected void updateEntity(TipZvanja entity, TipZvanjaDTO dto) {
        entity.setId(dto.getId());
        entity.setNaziv(dto.getNaziv());
    }
}
