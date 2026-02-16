package lms.servisi;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.PohadjanjePredmetaDTO;
import lms.modeli.PohadjanjePredmeta;
import lms.modeli.RealizacijaPredmeta;
import lms.modeli.StudentNaGodini;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.PohadjanjePredmetaRepository;
import lms.repozitorijumi.RealizacijaPredmetaRepository;
import lms.repozitorijumi.StudentNaGodiniRepository;

@Service
@Transactional(readOnly = true)
public class PohadjanjePredmetaService extends AbstractCrusService<PohadjanjePredmetaDTO, PohadjanjePredmeta, Long> {

    private final PohadjanjePredmetaRepository pohadjanjePredmetaRepository;
    private final StudentNaGodiniRepository studentNaGodiniRepository;
    private final RealizacijaPredmetaRepository realizacijaPredmetaRepository;

    public PohadjanjePredmetaService(PohadjanjePredmetaRepository pohadjanjePredmetaRepository,
                                     StudentNaGodiniRepository studentNaGodiniRepository,
                                     RealizacijaPredmetaRepository realizacijaPredmetaRepository) {
        this.pohadjanjePredmetaRepository = pohadjanjePredmetaRepository;
        this.studentNaGodiniRepository = studentNaGodiniRepository;
        this.realizacijaPredmetaRepository = realizacijaPredmetaRepository;
    }

    @Override
    protected LogickoBrisanjeRepozitorijum<PohadjanjePredmeta, Long> getRepository() {
        return pohadjanjePredmetaRepository;
    }

    @Override
    protected PohadjanjePredmetaDTO toDTO(PohadjanjePredmeta entity) {
        PohadjanjePredmetaDTO dto = new PohadjanjePredmetaDTO();
        dto.setId(entity.getId());
        dto.setKonacnaOcena(entity.getKonacnaOcena());

        if (entity.getStudentNaGodini() != null) {
            dto.setStudentNaGodiniId(entity.getStudentNaGodini().getId());
        }

        if (entity.getRealizacija() != null) {
            dto.setRealizacijaId(entity.getRealizacija().getId());
        }

        return dto;
    }

    @Override
    protected PohadjanjePredmeta toEntity(PohadjanjePredmetaDTO dto) {
        PohadjanjePredmeta entity = new PohadjanjePredmeta();
        updateEntity(entity, dto);
        return entity;
    }

    @Override
    protected void updateEntity(PohadjanjePredmeta entity, PohadjanjePredmetaDTO dto) {
        entity.setId(dto.getId());
        entity.setKonacnaOcena(dto.getKonacnaOcena());

        
        if (dto.getStudentNaGodiniId() != null) {
            StudentNaGodini student = studentNaGodiniRepository.findById(dto.getStudentNaGodiniId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "StudentNaGodini ID: " + dto.getStudentNaGodiniId() + " nije pronađen"));
            entity.setStudentNaGodini(student);
        }

        
        if (dto.getRealizacijaId() != null) {
            RealizacijaPredmeta realizacija = realizacijaPredmetaRepository.findById(dto.getRealizacijaId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "RealizacijaPredmeta ID: " + dto.getRealizacijaId() + " nije pronađena"));
            entity.setRealizacija(realizacija);
        }
    }
}
