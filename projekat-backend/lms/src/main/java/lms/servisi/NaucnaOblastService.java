package lms.servisi;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lms.dtos.NaucnaOblastDTO;
import lms.modeli.NaucnaOblast;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.NaucnaOblastRepository;

@Service
@Transactional(readOnly = true)
public class NaucnaOblastService extends AbstractCrusService<NaucnaOblastDTO, NaucnaOblast, Long> {

    private final NaucnaOblastRepository naucnaOblastRepository;

    public NaucnaOblastService(NaucnaOblastRepository naucnaOblastRepository) {
        this.naucnaOblastRepository = naucnaOblastRepository;
    }

    @Override
    protected LogickoBrisanjeRepozitorijum<NaucnaOblast, Long> getRepository() {
        return naucnaOblastRepository;
    }

    
    @Override
    protected NaucnaOblastDTO toDTO(NaucnaOblast entity) {
        NaucnaOblastDTO dto = new NaucnaOblastDTO();
        dto.setId(entity.getId());
        dto.setNaziv(entity.getNaziv());
        return dto;
    }

    
    @Override
    protected NaucnaOblast toEntity(NaucnaOblastDTO dto) {
        NaucnaOblast entity = new NaucnaOblast();
        updateEntity(entity, dto);
        return entity;
    }

    
    @Override
    protected void updateEntity(NaucnaOblast entity, NaucnaOblastDTO dto) {
        entity.setId(dto.getId());
        entity.setNaziv(dto.getNaziv());
    }
}
