package lms.servisi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.TerminNastaveDTO;
import lms.modeli.TerminNastave;
import lms.modeli.Ishod;
import lms.modeli.RealizacijaPredmeta;
import lms.modeli.TipNastave;
import lms.repozitorijumi.IshodRepository;
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

    @Autowired
    private IshodRepository ishodRepository;

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
        
        if (entity.getIshodi() != null) {
        	dto.setIshodiId(entity.getIshodi().stream()
        			.map(Ishod::getId)
        			.collect(Collectors.toList()));
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
                            "Realizacija predmeta nije pronađena"));
            entity.setRealizacija(realizacija);
        }

       
        if (dto.getTipNastaveId() != null) {
            TipNastave tip = tipNastaveRepository.findById(dto.getTipNastaveId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Tip nastave nije pronađen"));
            entity.setTipNastave(tip);
        }
        
        if (dto.getIshodiId() != null) {
        	List<Ishod> ishodi = dto.getIshodiId().stream()
        			.map(id -> ishodRepository.findById(id)
        					.orElseThrow(() -> new EntityNotFoundException("Ishod ID: " + id + " nije pronađen")))
					.collect(Collectors.toList());
        	entity.setIshodi(ishodi);
        }
    }
}
