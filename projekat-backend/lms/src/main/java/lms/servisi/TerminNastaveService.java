package lms.servisi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.TerminNastaveDTO;
import lms.modeli.TerminNastave;
import lms.modeli.RealizacijaPredmeta;
import lms.modeli.TipNastave;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.RealizacijaPredmetaRepository;
import lms.repozitorijumi.TerminNastaveRepository;
import lms.repozitorijumi.TipNastaveRepository;

@Service
@Transactional(readOnly = true)
public class TerminNastaveService extends AbstractCrusService<TerminNastaveDTO, TerminNastave, Long> {
	
	@Autowired
	private TerminNastaveRepository terminNastaveRepository;
    
	@Autowired
	private RealizacijaPredmetaRepository realizacijaPredmetaRepository;
    
	@Autowired
	private TipNastaveRepository tipNastaveRepository;

    

    @Override
    protected LogickoBrisanjeRepozitorijum<TerminNastave, Long> getRepository() {
        return terminNastaveRepository;
    }

    @Override
    protected TerminNastaveDTO toDTO(TerminNastave entity) {
        TerminNastaveDTO dto = new TerminNastaveDTO();
        dto.setId(entity.getId());
        dto.setVremePocetka(entity.getVremePocetka());
        dto.setVremeZavrsetka(entity.getVremeZavrsetka());

        if (entity.getRealizacija() != null) {
            dto.setRealizacijaId(entity.getRealizacija().getId());
        }

        if (entity.getTipNastave() != null) {
            dto.setTipNastaveId(entity.getTipNastave().getId());
        }

        return dto;
    }

    @Override
    protected TerminNastave toEntity(TerminNastaveDTO dto) {
        TerminNastave entity = new TerminNastave();
        updateEntity(entity, dto);
        return entity;
    }

    @Override
    protected void updateEntity(TerminNastave entity, TerminNastaveDTO dto) {
        entity.setId(dto.getId());
        entity.setVremePocetka(dto.getVremePocetka());
        entity.setVremeZavrsetka(dto.getVremeZavrsetka());

       
        if (dto.getRealizacijaId() != null) {
            RealizacijaPredmeta realizacija = realizacijaPredmetaRepository.findById(dto.getRealizacijaId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "RealizacijaPredmeta ID: " + dto.getRealizacijaId() + " nije pronađena"));
            entity.setRealizacija(realizacija);
        }

       
        if (dto.getTipNastaveId() != null) {
            TipNastave tip = tipNastaveRepository.findById(dto.getTipNastaveId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "TipNastave ID: " + dto.getTipNastaveId() + " nije pronađen"));
            entity.setTipNastave(tip);
        }
    }
}
