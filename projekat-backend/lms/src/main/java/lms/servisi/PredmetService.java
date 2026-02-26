package lms.servisi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.PredmetDTO;
import lms.modeli.Predmet;
import lms.modeli.StudijskiProgram;
import lms.modeli.RealizacijaPredmeta;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.PredmetRepository;
import lms.repozitorijumi.StudijskiProgramRepository;
import lms.repozitorijumi.RealizacijaPredmetaRepository;

@Service
@Transactional(readOnly = true)
public class PredmetService extends AbstractCrusService<PredmetDTO, Predmet, Long> {

	@Autowired
	private PredmetRepository predmetRepository;
    
	@Autowired
	private StudijskiProgramRepository studijskiProgramRepository;
    
	@Autowired
	private RealizacijaPredmetaRepository realizacijaPredmetaRepository;

   
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

        if (entity.getStudijskiProgram() != null) {
            dto.setStudijskiProgramId(entity.getStudijskiProgram().getId());
        }

        if (entity.getRealizacije() != null) {
            dto.setRealizacijeId(entity.getRealizacije().stream()
                    .map(RealizacijaPredmeta::getId)
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

       
        if (dto.getStudijskiProgramId() != null) {
            StudijskiProgram studijskiProgram = studijskiProgramRepository.findById(dto.getStudijskiProgramId())
                    .orElseThrow(() -> new EntityNotFoundException("Studijski program nije pronađen"));
            entity.setStudijskiProgram(studijskiProgram);
        }

       
        if (dto.getRealizacijeId() != null) {
            List<RealizacijaPredmeta> realizacije = dto.getRealizacijeId().stream()
                    .map(id -> realizacijaPredmetaRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Realizacija predmeta ID: " + id + " nije pronađena")))
                    .collect(Collectors.toList());
            entity.setRealizacije(realizacije);
        }
    }
}
