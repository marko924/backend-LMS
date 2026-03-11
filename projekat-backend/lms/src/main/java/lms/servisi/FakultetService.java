package lms.servisi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.FakultetDTO;
import lms.dtos.FakultetDetaljiDTO;
import lms.modeli.Adresa;
import lms.modeli.Fakultet;
import lms.modeli.Nastavnik;
import lms.modeli.StudijskiProgram;
import lms.modeli.Univerzitet;
import lms.repozitorijumi.AdresaRepository;
import lms.repozitorijumi.FakultetRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.NastavnikRepository;
import lms.repozitorijumi.StudijskiProgramRepository;
import lms.repozitorijumi.UniverzitetRepository;

@Service
@Transactional(readOnly = true)
public class FakultetService extends AbstractCrusService<FakultetDTO, Fakultet, Long> {

	@Autowired
	private FakultetRepository fakultetRepository;
    
	@Autowired
	private UniverzitetRepository univerzitetRepository;
    
	@Autowired
	private NastavnikRepository nastavnikRepository;
    
	@Autowired
	private StudijskiProgramRepository studijskiProgramRepository;
    
	@Autowired
	private AdresaRepository adresaRepository;

    

    @Override
    protected LogickoBrisanjeRepozitorijum<Fakultet, Long> getRepository() {
        return fakultetRepository;
    }

  
    @Override
    protected FakultetDTO toDTO(Fakultet entity) {
        FakultetDTO dto = new FakultetDTO();
        dto.setId(entity.getId());
        dto.setNaziv(entity.getNaziv());
        dto.setOpis(entity.getOpis());
        dto.setUniverzitetId(entity.getUniverzitet() != null ? entity.getUniverzitet().getId() : null);
        dto.setDekanId(entity.getDekan() != null ? entity.getDekan().getId() : null);
        dto.setProgramId(entity.getProgrami() != null
                ? entity.getProgrami().stream()
                        .map(StudijskiProgram::getId)
                        .collect(Collectors.toList())
                : null);
        dto.setAdresaId(entity.getAdresa() != null ? entity.getAdresa().getId() : null);
        return dto;
    }

 
    @Override
    protected Fakultet toEntity(FakultetDTO dto) {
        Fakultet entity = new Fakultet();
        updateEntity(entity, dto);
        return entity;
    }

    @Override
    protected void updateEntity(Fakultet entity, FakultetDTO dto) {
        entity.setId(dto.getId());
        entity.setNaziv(dto.getNaziv());
        entity.setOpis(dto.getOpis());

       
        if (dto.getUniverzitetId() != null) {
            Univerzitet univerzitet = univerzitetRepository.findById(dto.getUniverzitetId())
                    .orElseThrow(() -> new EntityNotFoundException("Univerzitet nije pronađen"));
            entity.setUniverzitet(univerzitet);
        }

       
        if (dto.getDekanId() != null) {
            Nastavnik dekan = nastavnikRepository.findById(dto.getDekanId())
                    .orElseThrow(() -> new EntityNotFoundException("Dekan nije pronađen"));
            entity.setDekan(dekan);
        }

      
        if (dto.getProgramId() != null) {
            List<StudijskiProgram> programi = dto.getProgramId().stream()
                    .map(id -> studijskiProgramRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Studijski program ID: " + id + " nije pronađen")))
                    .collect(Collectors.toList());
            entity.setProgrami(programi);
        }

       
        if (dto.getAdresaId() != null) {
            Adresa adresa = adresaRepository.findById(dto.getAdresaId())
                    .orElseThrow(() -> new EntityNotFoundException("Adresa nije pronađena"));
            entity.setAdresa(adresa);
        }
    }
    
    public FakultetDetaljiDTO getDetaljiFakulteta(Long id) {
        Fakultet fakultet = fakultetRepository.findByIdWithDetails(id)
                .orElseThrow(() -> new EntityNotFoundException("Fakultet sa ID: " + id + " nije pronađen"));

        FakultetDetaljiDTO dto = new FakultetDetaljiDTO();
        dto.setId(fakultet.getId());
        dto.setNaziv(fakultet.getNaziv());
        dto.setOpis(fakultet.getOpis());

        if (fakultet.getUniverzitet() != null) {
            dto.setUniverzitetId(fakultet.getUniverzitet().getId());
            dto.setUniverzitetNaziv(fakultet.getUniverzitet().getNaziv());
        }

        if (fakultet.getDekan() != null) {
            dto.setDekanIme(fakultet.getDekan().getIme());
            dto.setDekanPrezime(fakultet.getDekan().getPrezime());
            dto.setDekanEmail(fakultet.getDekan().getEmail());
        }

        if (fakultet.getAdresa() != null) {
            dto.setUlica(fakultet.getAdresa().getUlica());
            dto.setBroj(fakultet.getAdresa().getBroj());
            
            if (fakultet.getAdresa().getMesto() != null) {
                dto.setMestoNaziv(fakultet.getAdresa().getMesto().getNaziv());
            }
        }

        return dto;
    }
}
