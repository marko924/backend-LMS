package lms.servisi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityNotFoundException;
import lms.dtos.PrijaviIspitDTO;
import lms.modeli.PrijaviIspit;
import lms.modeli.Predmet;
import lms.modeli.Student;
import lms.repozitorijumi.PrijaviIspitRepository;
import lms.repozitorijumi.PredmetRepository;
import lms.repozitorijumi.StudentRepository;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class PrijaviIspitService extends AbstractCrusService<PrijaviIspitDTO, PrijaviIspit, Long> {

    @Autowired
    private PrijaviIspitRepository prijaviIspitRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PredmetRepository predmetRepository;

    @Override
    protected PrijaviIspitRepository getRepository() {
        return prijaviIspitRepository;
    }

    public List<PrijaviIspitDTO> getDostupniZaStudenta(Long studentId) {
        List<Predmet> sviPredmeti = predmetRepository.findAll();

        Set<Long> prijavljeniPredmetiIds = prijaviIspitRepository.findAll().stream()
                .filter(p -> p.getStudent() != null && p.getStudent().getId().equals(studentId))
                .map(p -> p.getPredmet().getId())
                .collect(Collectors.toSet());

        return sviPredmeti.stream()
                .filter(p -> !prijavljeniPredmetiIds.contains(p.getId()))
                .map(p -> {
                    PrijaviIspitDTO dto = new PrijaviIspitDTO();
                    dto.setId(p.getId());
                    dto.setPredmetId(p.getId());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    protected PrijaviIspitDTO toDTO(PrijaviIspit entity) {
        PrijaviIspitDTO dto = new PrijaviIspitDTO();
        dto.setId(entity.getId());
        if (entity.getStudent() != null) dto.setStudentId(entity.getStudent().getId());
        if (entity.getPredmet() != null) dto.setPredmetId(entity.getPredmet().getId());
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
        if (dto.getStudentId() != null) {
            Student student = studentRepository.findById(dto.getStudentId())
                    .orElseThrow(() -> new EntityNotFoundException("Student nije pronađen"));
            entity.setStudent(student);
        }
        if (dto.getPredmetId() != null) {
            Predmet predmet = predmetRepository.findById(dto.getPredmetId())
                    .orElseThrow(() -> new EntityNotFoundException("Predmet nije pronađen"));
            entity.setPredmet(predmet);
        }
    }
    
    @Transactional
    public PrijaviIspit prijaviIspit(PrijaviIspitDTO dto) {
        PrijaviIspit prijava = toEntity(dto);
        return prijaviIspitRepository.save(prijava);
    }
}