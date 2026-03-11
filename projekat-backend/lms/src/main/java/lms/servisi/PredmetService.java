package lms.servisi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.PredmetDTO;
import lms.modeli.Ishod;
import lms.modeli.Predmet;
import lms.modeli.RealizacijaPredmeta;
import lms.repozitorijumi.IshodRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.PredmetRepository;
import lms.repozitorijumi.RealizacijaPredmetaRepository;

@Service
@Transactional(readOnly = true)
public class PredmetService extends AbstractCrusService<PredmetDTO, Predmet, Long> {

	@Autowired
	private PredmetRepository predmetRepository;
    
	@Autowired
	private RealizacijaPredmetaRepository realizacijaPredmetaRepository;

	@Autowired
	private IshodRepository ishodRepository;
   
    @Override
    protected LogickoBrisanjeRepozitorijum<Predmet, Long> getRepository() {
        return predmetRepository;
    }

   
    @Override
    protected PredmetDTO toDTO(Predmet entity) {
        PredmetDTO dto = new PredmetDTO();
        dto.setId(entity.getId());
        dto.setNaziv(entity.getNaziv());
        dto.setOpis(entity.getOpis());
        dto.setEspb(entity.getEspb());
        dto.setObavezan(entity.isObavezan());
        dto.setBrojPredavanja(entity.getBrojPredavanja());
        dto.setBrojVezbi(entity.getBrojVezbi());
        dto.setDrugiObliciNastave(entity.getDrugiObliciNastave());
        dto.setIstrazivackiRad(entity.getIstrazivackiRad());
        dto.setOstaliCasovi(entity.getOstaliCasovi());
        if (entity.getPreduslov() != null) {
        	dto.setPreduslovId(entity.getPreduslov().getId());
        }
        if (entity.getRealizacije() != null) {
            dto.setRealizacijeId(entity.getRealizacije().stream()
                    .map(RealizacijaPredmeta::getId)
                    .collect(Collectors.toList()));
        }
        if (entity.getIshodi() != null) {
        	dto.setIshodiId(entity.getIshodi().stream()
        			.map(Ishod::getId)
        			.collect(Collectors.toList()));
        }
        return dto;
    }

  
    @Override
    protected Predmet toEntity(PredmetDTO dto) {
        Predmet entity = new Predmet();
        updateEntity(entity, dto);
        return entity;
    }

    
    @Override
    protected void updateEntity(Predmet entity, PredmetDTO dto) {
        entity.setId(dto.getId());
        entity.setNaziv(dto.getNaziv());
        entity.setOpis(dto.getOpis());
        entity.setEspb(dto.getEspb());
        entity.setObavezan(dto.isObavezan());
        entity.setBrojPredavanja(dto.getBrojPredavanja());
        entity.setBrojVezbi(dto.getBrojVezbi());
        entity.setDrugiObliciNastave(dto.getDrugiObliciNastave());
        entity.setIstrazivackiRad(dto.getIstrazivackiRad());
        entity.setOstaliCasovi(dto.getOstaliCasovi());
        if (dto.getPreduslovId() != null) {
        	Predmet preduslov = predmetRepository.findById(dto.getPreduslovId())
        			.orElseThrow(() -> new EntityNotFoundException("Preduslov za predmet nije pronađen"));
        	entity.setPreduslov(preduslov);
        }
        if (dto.getRealizacijeId() != null) {
            List<RealizacijaPredmeta> realizacije = dto.getRealizacijeId().stream()
                    .map(id -> realizacijaPredmetaRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Realizacija predmeta ID: " + id + " nije pronađena")))
                    .collect(Collectors.toList());
            entity.setRealizacije(realizacije);
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
