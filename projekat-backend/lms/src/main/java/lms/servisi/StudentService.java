package lms.servisi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.StudentDTO;
import lms.modeli.Adresa;
import lms.modeli.Student;
import lms.modeli.StudentNaGodini;
import lms.repozitorijumi.AdresaRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.StudentNaGodiniRepository;
import lms.repozitorijumi.StudentRepository;

@Service
@Transactional(readOnly = true)
public class StudentService extends AbstractCrusService<StudentDTO, Student, Long> {

    private final StudentRepository studentRepository;
    private final AdresaRepository adresaRepository;
    private final StudentNaGodiniRepository studentNaGodiniRepository;

    public StudentService(StudentRepository studentRepository,
                          AdresaRepository adresaRepository,
                          StudentNaGodiniRepository studentNaGodiniRepository) {
        this.studentRepository = studentRepository;
        this.adresaRepository = adresaRepository;
        this.studentNaGodiniRepository = studentNaGodiniRepository;
    }

    @Override
    protected LogickoBrisanjeRepozitorijum<Student, Long> getRepository() {
        return studentRepository;
    }

   
    @Override
    protected StudentDTO toDTO(Student entity) {
        StudentDTO dto = new StudentDTO();

        dto.setId(entity.getId());
        dto.setIme(entity.getIme());
        dto.setPrezime(entity.getPrezime());
        dto.setJmbg(entity.getJmbg());
        dto.setKorisnickoIme(entity.getKorisnickoIme());
        dto.setLozinka(entity.getLozinka());
        dto.setEmail(entity.getEmail());

        if (entity.getAdresa() != null) {
            dto.setAdresaId(entity.getAdresa().getId());
        }

        if (entity.getUpisi() != null) {
            dto.setUpisiId(
                entity.getUpisi().stream()
                    .map(StudentNaGodini::getId)
                    .collect(Collectors.toList())
            );
        }

        return dto;
    }

   
    @Override
    protected Student toEntity(StudentDTO dto) {
        Student entity = new Student();
        updateEntity(entity, dto);
        return entity;
    }

    
    @Override
    protected void updateEntity(Student entity, StudentDTO dto) {

        entity.setId(dto.getId());
        entity.setIme(dto.getIme());
        entity.setPrezime(dto.getPrezime());
        entity.setJmbg(dto.getJmbg());
        entity.setKorisnickoIme(dto.getKorisnickoIme());
        entity.setLozinka(dto.getLozinka());
        entity.setEmail(dto.getEmail());

       
        if (dto.getAdresaId() != null) {
            Adresa adresa = adresaRepository.findById(dto.getAdresaId())
                .orElseThrow(() -> new EntityNotFoundException("Adresa nije pronađena"));
            entity.setAdresa(adresa);
        }

        
        if (dto.getUpisiId() != null) {
            List<StudentNaGodini> upisi = dto.getUpisiId().stream()
                .map(id -> studentNaGodiniRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Upis ID: " + id + " nije pronađen")))
                .collect(Collectors.toList());

            entity.setUpisi(upisi);
        }
    }
}
