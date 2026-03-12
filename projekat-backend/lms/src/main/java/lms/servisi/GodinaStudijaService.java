package lms.servisi;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.GodinaStudijaDTO;
import lms.modeli.GodinaStudija;
import lms.modeli.Predmet;
import lms.modeli.StudijskiProgram;
import lms.repozitorijumi.GodinaStudijaRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.PredmetRepository;
import lms.repozitorijumi.StudijskiProgramRepository;

@Service
@Transactional(readOnly = true)
public class GodinaStudijaService extends AbstractCrusService<GodinaStudijaDTO, GodinaStudija, Long> {

	@Autowired
	private GodinaStudijaRepository godinaStudijaRepository;
	
    @Autowired
    private StudijskiProgramRepository studijskiProgramRepository;
    
    @Autowired
    private PredmetRepository predmetRepository;

    @Override
    protected LogickoBrisanjeRepozitorijum<GodinaStudija, Long> getRepository() {
        return godinaStudijaRepository;
    }

   
    @Override
    protected GodinaStudijaDTO toDTO(GodinaStudija entity) {
        GodinaStudijaDTO dto = new GodinaStudijaDTO();
        dto.setId(entity.getId());
        dto.setGodina(entity.getGodina());
        dto.setPocetak(entity.getPocetak());
        dto.setKraj(entity.getKraj());
        if(entity.getStudijskiProgram() != null) {
        	dto.setStudijskiProgramId(entity.getStudijskiProgram().getId());
        }
        if(entity.getPredmeti() != null) {
        	dto.setPredmetiId(entity.getPredmeti().stream()
        			.map(Predmet::getId)
        			.collect(Collectors.toList()));
        }
        return dto;
    }

   
    @Override
    protected GodinaStudija toEntity(GodinaStudijaDTO dto) {
        GodinaStudija entity = new GodinaStudija();
        updateEntity(entity, dto);
        return entity;
    }

  
    @Override
    protected void updateEntity(GodinaStudija entity, GodinaStudijaDTO dto) {
        entity.setId(dto.getId());
        entity.setGodina(dto.getGodina());
        entity.setPocetak(dto.getPocetak());
        entity.setKraj(dto.getKraj());
        if(dto.getStudijskiProgramId() != null) {
        	StudijskiProgram studijskiProgram = studijskiProgramRepository.findById(dto.getStudijskiProgramId())
        			.orElseThrow(() -> new EntityNotFoundException("Studijski program nije pronađen"));
        	entity.setStudijskiProgram(studijskiProgram);
        }
        if(dto.getPredmetiId() != null) {
        	Set<Predmet> predmeti = dto.getPredmetiId().stream()
        			.map(id -> predmetRepository.findById(id)
        					.orElseThrow(() -> new EntityNotFoundException("Predmet ID: " + id + " nije pronađen")))
					.collect(Collectors.toSet());
        	entity.setPredmeti(predmeti);
        }
    }
}
