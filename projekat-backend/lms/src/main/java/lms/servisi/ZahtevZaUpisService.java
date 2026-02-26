package lms.servisi;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.ZahtevZaUpisDTO;
import lms.modeli.Fakultet;
import lms.modeli.GodinaStudija;
import lms.modeli.StatusZahteva;
import lms.modeli.Student;
import lms.modeli.StudentNaGodini;
import lms.modeli.ZahtevZaUpis;
import lms.repozitorijumi.FakultetRepository;
import lms.repozitorijumi.GodinaStudijaRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.StudentNaGodiniRepository;
import lms.repozitorijumi.StudentRepository;
import lms.repozitorijumi.ZahtevZaUpisRepository;

@Service
@Transactional(readOnly = true)
public class ZahtevZaUpisService extends AbstractCrusService<ZahtevZaUpisDTO, ZahtevZaUpis, Long> {

    @Autowired
    private ZahtevZaUpisRepository zahtevRepository;
    
    @Autowired
    private FakultetRepository fakultetRepository;

    @Autowired
    private StudentNaGodiniRepository studentNaGodiniRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GodinaStudijaRepository godinaStudijaRepository;

    @Override
    protected LogickoBrisanjeRepozitorijum<ZahtevZaUpis, Long> getRepository() {
        return zahtevRepository;
    }

    @Override
    protected ZahtevZaUpisDTO toDTO(ZahtevZaUpis entity) {
        ZahtevZaUpisDTO dto = new ZahtevZaUpisDTO();
        dto.setId(entity.getId());
        if (entity.getFakultet() != null) {
        	dto.setFakultetId(entity.getId());
        }
        if (entity.getStudent() != null) {
        	dto.setStudentId(entity.getStudent().getId());
        }
        if (entity.getGodinaStudija() != null) {
        	dto.setGodinaStudijaId(entity.getGodinaStudija().getId());
        }
        dto.setStatus(entity.getStatus());
        dto.setVremePodnosenja(entity.getVremePodnosenja());
        dto.setNapomena(entity.getNapomena());
        return dto;
    }

    @Override
    protected ZahtevZaUpis toEntity(ZahtevZaUpisDTO dto) {
        ZahtevZaUpis zahtev = new ZahtevZaUpis();
        updateEntity(zahtev, dto);
        return zahtev;
    }

    @Override
    protected void updateEntity(ZahtevZaUpis entity, ZahtevZaUpisDTO dto) {
    	entity.setId(dto.getId());
    	if (dto.getFakultetId() != null) {
    		Fakultet fakultet = fakultetRepository.findById(dto.getFakultetId())
    				.orElseThrow(() -> new EntityNotFoundException("Fakultet nije pronađen"));
    		entity.setFakultet(fakultet);
    	}
    	if (dto.getStudentId() != null) {
    		Student student = studentRepository.findById(dto.getStudentId())
    				.orElseThrow(() -> new EntityNotFoundException("Student nije pronađen"));
    		entity.setStudent(student);
    	}
        if (dto.getGodinaStudijaId() != null) {
        	GodinaStudija godina = godinaStudijaRepository.findById(dto.getGodinaStudijaId())
        			.orElseThrow(() -> new EntityNotFoundException("Godina studija nije pronadjena"));
        	entity.setGodinaStudija(godina);
        }
        entity.setVremePodnosenja(dto.getVremePodnosenja() != null ? dto.getVremePodnosenja() : LocalDateTime.now());
        if (dto.getStatus() != null) {
            entity.setStatus(dto.getStatus() != null ? dto.getStatus() : StatusZahteva.NA_CEKANJU);
        }
        entity.setNapomena(dto.getNapomena());
    }

    
    @Transactional
    public void odobriZahtev(Long zahtevId, String brojIndeksa) {
        //1.Nalazimo zahtev
        ZahtevZaUpis zahtev = zahtevRepository.findById(zahtevId)
                .filter(e -> !e.isObrisan())
                .orElseThrow(() -> new EntityNotFoundException("Zahtev sa ID: " + zahtevId + " nije pronadjen"));

        //2.Validacija - da li je zahtev na čekanju
        if (zahtev.getStatus() != StatusZahteva.NA_CEKANJU) {
            throw new IllegalStateException("Zahtev je već obradjen (status: " + zahtev.getStatus() + ")");
        }

        //3.Menjanje statusa zahteva
        zahtev.setStatus(StatusZahteva.ODOBREN);
        zahtevRepository.save(zahtev);

        //4.Kreiramo instancu StudentNaGodini na osnovu podataka iz zahteva
        StudentNaGodini studentNaGodini = new StudentNaGodini();
        studentNaGodini.setStudent(zahtev.getStudent());
        studentNaGodini.setGodinaStudija(zahtev.getGodinaStudija());
        studentNaGodini.setDatumUpisa(LocalDate.now());
        studentNaGodini.setBrojIndeksa(brojIndeksa);
        studentNaGodini.setObrisan(false);

        studentNaGodiniRepository.save(studentNaGodini);
    }
    
    @Transactional
    public void odbijZahtev(Long zahtevId, String napomena) {
        ZahtevZaUpis zahtev = zahtevRepository.findById(zahtevId)
                .filter(e -> !e.isObrisan())
                .orElseThrow(() -> new EntityNotFoundException("Zahtev sa ID: " + zahtevId + " nije pronadjen"));

        if (zahtev.getStatus() != StatusZahteva.NA_CEKANJU) {
            throw new IllegalStateException("Zahtev je već obradjen.");
        }

        zahtev.setStatus(StatusZahteva.ODBIJEN);
        zahtev.setNapomena(napomena);
        zahtevRepository.save(zahtev);
    }
}
