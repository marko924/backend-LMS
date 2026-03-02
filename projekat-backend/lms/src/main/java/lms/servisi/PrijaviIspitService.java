package lms.servisi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityNotFoundException;
import lms.dtos.PrijaviIspitDTO;
import lms.modeli.PrijaviIspit;
import lms.modeli.EvaluacijaZnanja;
import lms.modeli.StudentNaGodini;
import lms.repozitorijumi.PrijaviIspitRepository;
import lms.repozitorijumi.EvaluacijaZnanjaRepository;
import lms.repozitorijumi.StudentNaGodiniRepository;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class PrijaviIspitService extends AbstractCrusService<PrijaviIspitDTO, PrijaviIspit, Long> {

    @Autowired
    private PrijaviIspitRepository prijaviIspitRepository;

    @Autowired
    private StudentNaGodiniRepository studentNaGodiniRepository;

    @Autowired
    private EvaluacijaZnanjaRepository evaluacijaZnanjaRepository;

    @Override
    protected PrijaviIspitRepository getRepository() {
        return prijaviIspitRepository;
    }

    public List<PrijaviIspitDTO> getDostupniZaStudenta(Long studentNaGodiniId) {
       
        List<EvaluacijaZnanja> sveEvaluacije = evaluacijaZnanjaRepository.findAll();

        
        Set<Long> vecPrijavljeneIds = prijaviIspitRepository.findAll().stream()
                .filter(p -> p.getStudentNaGodini() != null && p.getStudentNaGodini().getId().equals(studentNaGodiniId))
                .map(p -> p.getEvaluacijaZnanja().getId())
                .collect(Collectors.toSet());

        
        return sveEvaluacije.stream()
                .filter(e -> !vecPrijavljeneIds.contains(e.getId()))
                .map(e -> {
                    PrijaviIspitDTO dto = new PrijaviIspitDTO();
                    dto.setEvaluacijaZnanjaId(e.getId());
                    dto.setStudentNaGodiniId(studentNaGodiniId);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    protected PrijaviIspitDTO toDTO(PrijaviIspit entity) {
        PrijaviIspitDTO dto = new PrijaviIspitDTO();
        dto.setId(entity.getId());
        if (entity.getStudentNaGodini() != null) {
            dto.setStudentNaGodiniId(entity.getStudentNaGodini().getId());
        }
        if (entity.getEvaluacijaZnanja() != null) {
            dto.setEvaluacijaZnanjaId(entity.getEvaluacijaZnanja().getId());
        }
        return dto;
    }

    @Override
    protected PrijaviIspit toEntity(PrijaviIspitDTO dto) {
        PrijaviIspit entity = new PrijaviIspit();
        updateEntity(entity, dto);
        return entity;
    }

    @Override
    protected void updateEntity(PrijaviIspit entity, PrijaviIspitDTO dto) {
        if (dto.getStudentNaGodiniId() != null) {
            StudentNaGodini sng = studentNaGodiniRepository.findById(dto.getStudentNaGodiniId())
                    .orElseThrow(() -> new EntityNotFoundException("Student na godini nije pronađen"));
            entity.setStudentNaGodini(sng);
        }
        if (dto.getEvaluacijaZnanjaId() != null) {
            EvaluacijaZnanja ev = evaluacijaZnanjaRepository.findById(dto.getEvaluacijaZnanjaId())
                    .orElseThrow(() -> new EntityNotFoundException("Evaluacija znanja nije pronađena"));
            entity.setEvaluacijaZnanja(ev);
        }
    }
}