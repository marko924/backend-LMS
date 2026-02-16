package lms.servisi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.StudijskiProgramDTO;
import lms.modeli.Fakultet;
import lms.modeli.Nastavnik;
import lms.modeli.Predmet;
import lms.modeli.StudijskiProgram;
import lms.repozitorijumi.FakultetRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.NastavnikRepository;
import lms.repozitorijumi.PredmetRepository;
import lms.repozitorijumi.StudijskiProgramRepository;

@Service
@Transactional(readOnly = true)
public class StudijskiProgramService extends AbstractCrusService<StudijskiProgramDTO, StudijskiProgram, Long> {

    private final StudijskiProgramRepository studijskiProgramRepository;
    private final FakultetRepository fakultetRepository;
    private final NastavnikRepository nastavnikRepository;
    private final PredmetRepository predmetRepository;

    public StudijskiProgramService(
            StudijskiProgramRepository studijskiProgramRepository,
            FakultetRepository fakultetRepository,
            NastavnikRepository nastavnikRepository,
            PredmetRepository predmetRepository) {

        this.studijskiProgramRepository = studijskiProgramRepository;
        this.fakultetRepository = fakultetRepository;
        this.nastavnikRepository = nastavnikRepository;
        this.predmetRepository = predmetRepository;
    }

    @Override
    protected LogickoBrisanjeRepozitorijum<StudijskiProgram, Long> getRepository() {
        return studijskiProgramRepository;
    }

   
    @Override
    protected StudijskiProgramDTO toDTO(StudijskiProgram entity) {
        StudijskiProgramDTO dto = new StudijskiProgramDTO();
        dto.setId(entity.getId());
        dto.setNaziv(entity.getNaziv());

        if (entity.getFakultet() != null) {
            dto.setFakultetId(entity.getFakultet().getId());
        }

        if (entity.getRukovodilac() != null) {
            dto.setRukovodilacId(entity.getRukovodilac().getId());
        }

        if (entity.getPredmeti() != null) {
            dto.setPredmetiId(entity.getPredmeti().stream()
                    .map(Predmet::getId)
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

       
        if (dto.getFakultetId() != null) {
            Fakultet fakultet = fakultetRepository.findById(dto.getFakultetId())
                    .orElseThrow(() -> new EntityNotFoundException("Fakultet nije pronađen"));
            entity.setFakultet(fakultet);
        }

        
        if (dto.getRukovodilacId() != null) {
            Nastavnik rukovodilac = nastavnikRepository.findById(dto.getRukovodilacId())
                    .orElseThrow(() -> new EntityNotFoundException("Rukovodilac (nastavnik) nije pronađen"));
            entity.setRukovodilac(rukovodilac);
        }

       
        if (dto.getPredmetiId() != null) {
            List<Predmet> predmeti = dto.getPredmetiId().stream()
                    .map(id -> predmetRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Predmet ID: " + id + " nije pronađen")))
                    .collect(Collectors.toList());
            entity.setPredmeti(predmeti);
        }
    }
}
