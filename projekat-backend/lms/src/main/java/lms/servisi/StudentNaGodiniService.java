package lms.servisi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.StudentNaGodiniDTO;
import lms.modeli.GodinaStudija;
import lms.modeli.PohadjanjePredmeta;
import lms.modeli.Student;
import lms.modeli.StudentNaGodini;
import lms.repozitorijumi.GodinaStudijaRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.PohadjanjePredmetaRepository;
import lms.repozitorijumi.StudentNaGodiniRepository;
import lms.repozitorijumi.StudentRepository;

@Service
@Transactional(readOnly = true)
public class StudentNaGodiniService
        extends AbstractCrusService<StudentNaGodiniDTO, StudentNaGodini, Long> {
	
	@Autowired
	private StudentNaGodiniRepository repository;
    
	@Autowired
	private StudentRepository studentRepository;
    
	@Autowired
	private GodinaStudijaRepository godinaRepository;
    
	@Autowired
	private PohadjanjePredmetaRepository pohadjanjeRepository;

    

    @Override
    protected LogickoBrisanjeRepozitorijum<StudentNaGodini, Long> getRepository() {
        return repository;
    }

    
    @Override
    protected StudentNaGodiniDTO toDTO(StudentNaGodini entity) {
        StudentNaGodiniDTO dto = new StudentNaGodiniDTO();

        dto.setId(entity.getId());
        dto.setBrojIndeksa(entity.getBrojIndeksa());
        dto.setDatumUpisa(entity.getDatumUpisa());

        if (entity.getStudent() != null)
            dto.setStudentId(entity.getStudent().getId());

        if (entity.getGodinaStudija() != null)
            dto.setGodinaStudijaId(entity.getGodinaStudija().getId());

        if (entity.getPohadjanja() != null) {
            dto.setPohadjanjaId(
                entity.getPohadjanja().stream()
                    .map(PohadjanjePredmeta::getId)
                    .collect(Collectors.toList())
            );
        }

        return dto;
    }

    
    @Override
    protected StudentNaGodini toEntity(StudentNaGodiniDTO dto) {
        StudentNaGodini entity = new StudentNaGodini();
        updateEntity(entity, dto);
        return entity;
    }

   
    @Override
    protected void updateEntity(StudentNaGodini entity, StudentNaGodiniDTO dto) {

        entity.setId(dto.getId());
        entity.setBrojIndeksa(dto.getBrojIndeksa());
        entity.setDatumUpisa(dto.getDatumUpisa());

     
        if (dto.getStudentId() != null) {
            Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new EntityNotFoundException("Student nije pronađen"));
            entity.setStudent(student);
        }

        
        if (dto.getGodinaStudijaId() != null) {
            GodinaStudija godina = godinaRepository.findById(dto.getGodinaStudijaId())
                .orElseThrow(() -> new EntityNotFoundException("Godina studija nije pronađena"));
            entity.setGodinaStudija(godina);
        }

       
        if (dto.getPohadjanjaId() != null) {
            List<PohadjanjePredmeta> pohadjanja = dto.getPohadjanjaId().stream()
                .map(id -> pohadjanjeRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Pohadjanje ID: " + id + " nije pronađeno")))
                .collect(Collectors.toList());

            entity.setPohadjanja(pohadjanja);
        }
    }
}
