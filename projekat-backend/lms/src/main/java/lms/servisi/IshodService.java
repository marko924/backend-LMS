package lms.servisi;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.IshodDTO;
import lms.modeli.EvaluacijaZnanja;
import lms.modeli.Ishod;
import lms.modeli.NastavniMaterijal;
import lms.modeli.ObrazovniCilj;
import lms.modeli.Predmet;
import lms.modeli.TerminNastave;
import lms.repozitorijumi.EvaluacijaZnanjaRepository;
import lms.repozitorijumi.IshodRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.NastavniMaterijalRepository;
import lms.repozitorijumi.ObrazovniCiljRepository;
import lms.repozitorijumi.PredmetRepository;
import lms.repozitorijumi.TerminNastaveRepository;

@Service
@Transactional(readOnly = true)
public class IshodService extends AbstractCrusService<IshodDTO, Ishod, Long>{
	
	@Autowired
	private IshodRepository ishodRepository;
	
	@Autowired
    private PredmetRepository predmetRepository;
	
	@Autowired
	private EvaluacijaZnanjaRepository evaluacijaZnanjaRepository;
	
	@Autowired
	private TerminNastaveRepository terminNastaveRepository;
	
	@Autowired
	private NastavniMaterijalRepository nastavniMaterijalRepository;

	@Autowired
    private ObrazovniCiljRepository obrazovniCiljRepository;

	@Override
	protected LogickoBrisanjeRepozitorijum<Ishod, Long> getRepository() {
		return ishodRepository;
	}

    @Override
    protected IshodDTO toDTO(Ishod entity) {
    	IshodDTO dto = new IshodDTO();
    	dto.setId(entity.getId());
    	dto.setOpis(entity.getOpis());
    	
    	if(entity.getPredmet() != null) {
    		dto.setPredmetId(entity.getPredmet().getId());
    	}
    	
    	if(entity.getEvaluacija() != null) {
    		dto.setEvaluacijaId(entity.getEvaluacija().getId());
    	}
    	
    	if(entity.getTerminNastave() != null) {
    		dto.setTerminNastaveId(entity.getTerminNastave().getId());
    	}
    	
    	if(entity.getNastavniMaterijali() != null) {
    		dto.setNastavniMaterijaliId(entity.getNastavniMaterijali().stream()
    				.map(NastavniMaterijal::getId)
    				.collect(Collectors.toList()));
    	}
    	
        if(entity.getObrazovniCiljevi() != null) {
        	dto.setObrazovniCiljeviId(entity.getObrazovniCiljevi().stream()
                    .map(ObrazovniCilj::getId)
                    .collect(Collectors.toSet()));
        }

        return dto;
    }

    @Override
    protected Ishod toEntity(IshodDTO dto) {
        Ishod entity = new Ishod();
        updateEntity(entity, dto);
        return entity;
    }

	@Override
	protected void updateEntity(Ishod entity, IshodDTO dto) {
		entity.setId(dto.getId());
		entity.setOpis(dto.getOpis());

        if (dto.getPredmetId() != null) {
            Predmet predmet = predmetRepository.findById(dto.getPredmetId())
                    .orElseThrow(() -> new EntityNotFoundException("Predmet nije pronađen"));
            entity.setPredmet(predmet);
        }
        
        if (dto.getEvaluacijaId() != null) {
        	EvaluacijaZnanja evaluacijaZnanja = evaluacijaZnanjaRepository.findById(dto.getEvaluacijaId())
        			.orElseThrow(() -> new EntityNotFoundException("Evaluacija znanja nije pronađena"));
        	entity.setEvaluacija(evaluacijaZnanja);
        }
        
        if (dto.getTerminNastaveId() != null) {
        	TerminNastave terminNastave = terminNastaveRepository.findById(dto.getTerminNastaveId())
        			.orElseThrow(() -> new EntityNotFoundException("Termin nastave nije pronađen"));
        	entity.setTerminNastave(terminNastave);
        }
        
        if (dto.getNastavniMaterijaliId() != null) {
        	List<NastavniMaterijal> nastavniMaterijali = dto.getNastavniMaterijaliId().stream()
        			.map(id -> nastavniMaterijalRepository.findById(id)
        					.orElseThrow(() -> new EntityNotFoundException("Nastavni materijal ID: " + id + " nije pronađen")))
                    .collect(Collectors.toList());
        	entity.setNastavniMaterijali(nastavniMaterijali);
        }

        if (dto.getObrazovniCiljeviId() != null) {
            Set<ObrazovniCilj> ciljevi = dto.getObrazovniCiljeviId().stream()
                    .map(id -> obrazovniCiljRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Obrazovni cilj ID: " + id + " nije pronađen")))
                    .collect(Collectors.toSet());
            entity.setObrazovniCiljevi(ciljevi);
        }
	}

}
