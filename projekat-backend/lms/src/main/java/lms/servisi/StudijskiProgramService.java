package lms.servisi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.StudijskiProgramDTO;
import lms.modeli.Fakultet;
import lms.modeli.GodinaStudija;
import lms.modeli.Nastavnik;
import lms.modeli.StudijskiProgram;
import lms.repozitorijumi.FakultetRepository;
import lms.repozitorijumi.GodinaStudijaRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.NastavnikRepository;
import lms.repozitorijumi.StudijskiProgramRepository;

@Service
@Transactional(readOnly = true)
public class StudijskiProgramService extends AbstractCrusService<StudijskiProgramDTO, StudijskiProgram, Long> {
	
	@Autowired
	private StudijskiProgramRepository studijskiProgramRepository;
     
	@Autowired
	private FakultetRepository fakultetRepository;
     
	@Autowired
	private NastavnikRepository nastavnikRepository;
     
	@Autowired
	private GodinaStudijaRepository godinaStudijaRepository;

    @Override
    protected LogickoBrisanjeRepozitorijum<StudijskiProgram, Long> getRepository() {
        return studijskiProgramRepository;
    }

   
    @Override
    protected StudijskiProgramDTO toDTO(StudijskiProgram entity) {
        StudijskiProgramDTO dto = new StudijskiProgramDTO();
        dto.setId(entity.getId());
        dto.setNaziv(entity.getNaziv());
        dto.setOpis(entity.getOpis());

        if (entity.getFakultet() != null) {
            dto.setFakultetId(entity.getFakultet().getId());
        }

        if (entity.getRukovodilac() != null) {
            dto.setRukovodilacId(entity.getRukovodilac().getId());
        }

        if (entity.getGodineStudija() != null) {
        	dto.setGodineStudijaId(entity.getGodineStudija().stream()
        			.map(GodinaStudija::getId)
        			.collect(Collectors.toList()));
        }

        return dto;
    }

    
    @Override
    protected StudijskiProgram toEntity(StudijskiProgramDTO dto) {
        StudijskiProgram entity = new StudijskiProgram();
        updateEntity(entity, dto);
        return entity;
    }

 
    @Override
    protected void updateEntity(StudijskiProgram entity, StudijskiProgramDTO dto) {
        entity.setId(dto.getId());
        entity.setNaziv(dto.getNaziv());
        entity.setOpis(dto.getOpis());

       
        if (dto.getFakultetId() != null) {
            Fakultet fakultet = fakultetRepository.findById(dto.getFakultetId())
                    .orElseThrow(() -> new EntityNotFoundException("Fakultet nije pronađen"));
            entity.setFakultet(fakultet);
        }

        
        if (dto.getRukovodilacId() != null) {
            Nastavnik rukovodilac = nastavnikRepository.findById(dto.getRukovodilacId())
                    .orElseThrow(() -> new EntityNotFoundException("Rukovodilac nije pronađen"));
            entity.setRukovodilac(rukovodilac);
        }

       
        if (dto.getGodineStudijaId() != null) {
        	List<GodinaStudija> godineStudija = dto.getGodineStudijaId().stream()
        			.map(id -> godinaStudijaRepository.findById(id)
        					.orElseThrow(() -> new EntityNotFoundException("Godina studija ID: " + id + " nije pronađen")))
					.collect(Collectors.toList());
        	entity.setGodineStudija(godineStudija);
        }
    }
}
