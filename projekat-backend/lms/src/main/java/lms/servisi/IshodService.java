package lms.servisi;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.IshodDTO;
import lms.modeli.Ishod;
import lms.modeli.ObrazovniCilj;
import lms.modeli.Predmet;
import lms.repozitorijumi.IshodRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.ObrazovniCiljRepository;
import lms.repozitorijumi.PredmetRepository;

@Service
@Transactional(readOnly = true)
public class IshodService extends AbstractCrusService<IshodDTO, Ishod, Long>{
	
	@Autowired
	private IshodRepository ishodRepository;
	
	@Autowired
    private PredmetRepository predmetRepository;

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
    		dto.setPredmetId(entity.getId());
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

        // 1. Mapiranje ManyToOne (Predmet)
        if (dto.getPredmetId() != null) {
            Predmet predmet = predmetRepository.findById(dto.getPredmetId())
                    .orElseThrow(() -> new EntityNotFoundException("Predmet nije pronađen"));
            entity.setPredmet(predmet);
        }

        // 2. Mapiranje ManyToMany (Obrazovni Ciljevi)
        if (dto.getObrazovniCiljeviId() != null) {
            // Pronalazimo sve ciljeve iz baze na osnovu set-a ID-eva
            Set<ObrazovniCilj> ciljevi = dto.getObrazovniCiljeviId().stream()
                    .map(id -> obrazovniCiljRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Obrazovni cilj ID: " + id + " nije pronađen")))
                    .collect(Collectors.toSet());
            
            // Osvežavamo kolekciju u entitetu
            entity.setObrazovniCiljevi(ciljevi);
        }
	}

}
