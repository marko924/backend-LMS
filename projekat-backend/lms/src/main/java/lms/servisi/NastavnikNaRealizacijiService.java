package lms.servisi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.NastavnikNaRealizacijiDTO;
import lms.modeli.Nastavnik;
import lms.modeli.NastavnikNaRealizaciji;
import lms.modeli.Obavestenje;
import lms.modeli.RealizacijaPredmeta;
import lms.modeli.TipNastave;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.NastavnikNaRealizacijiRepository;
import lms.repozitorijumi.NastavnikRepository;
import lms.repozitorijumi.ObavestenjeRepository;
import lms.repozitorijumi.RealizacijaPredmetaRepository;
import lms.repozitorijumi.TipNastaveRepository;

@Service
@Transactional(readOnly = true)
public class NastavnikNaRealizacijiService
        extends AbstractCrusService<NastavnikNaRealizacijiDTO, NastavnikNaRealizaciji, Long> {
	 
	 @Autowired
	 private NastavnikNaRealizacijiRepository angazovanjeRepository;
     
	 @Autowired
	 private NastavnikRepository nastavnikRepository;
     
	 @Autowired
	 private RealizacijaPredmetaRepository realizacijaRepository;
     
	 @Autowired
	 private TipNastaveRepository tipNastaveRepository;
	 
	 @Autowired
	 private ObavestenjeRepository obavestenjeRepository;

    

    @Override
    protected LogickoBrisanjeRepozitorijum<NastavnikNaRealizaciji, Long> getRepository() {
        return angazovanjeRepository;
    }

   
    @Override
    protected NastavnikNaRealizacijiDTO toDTO(NastavnikNaRealizaciji entity) {
        NastavnikNaRealizacijiDTO dto = new NastavnikNaRealizacijiDTO();

        dto.setId(entity.getId());
        dto.setBrojCasova(entity.getBrojCasova());

        if (entity.getNastavnik() != null)
            dto.setNastavnikId(entity.getNastavnik().getId());

        if (entity.getRealizacija() != null)
            dto.setRealizacijaId(entity.getRealizacija().getId());

        if (entity.getTipNastave() != null)
            dto.setTipNastaveId(entity.getTipNastave().getId());
        
        if (entity.getObavestenja() != null) {
        	dto.setObavestenjaId(entity.getObavestenja().stream()
        			.map(Obavestenje::getId)
        			.collect(Collectors.toList()));
        }

        return dto;
    }

    @Override
    protected NastavnikNaRealizaciji toEntity(NastavnikNaRealizacijiDTO dto) {
        NastavnikNaRealizaciji entity = new NastavnikNaRealizaciji();
        updateEntity(entity, dto);
        return entity;
    }

    
    @Override
    protected void updateEntity(NastavnikNaRealizaciji entity, NastavnikNaRealizacijiDTO dto) {

        entity.setId(dto.getId());
        entity.setBrojCasova(dto.getBrojCasova());

        if (dto.getNastavnikId() != null) {
            Nastavnik nastavnik = nastavnikRepository.findById(dto.getNastavnikId())
                .orElseThrow(() -> new EntityNotFoundException("Nastavnik nije pronađen"));
            entity.setNastavnik(nastavnik);
        }
       
        if (dto.getRealizacijaId() != null) {
            RealizacijaPredmeta realizacija = realizacijaRepository.findById(dto.getRealizacijaId())
                .orElseThrow(() -> new EntityNotFoundException("Realizacija predmeta nije pronađena"));
            entity.setRealizacija(realizacija);
        }
        
        if (dto.getTipNastaveId() != null) {
            TipNastave tip = tipNastaveRepository.findById(dto.getTipNastaveId())
                .orElseThrow(() -> new EntityNotFoundException("Tip nastave nije pronađen"));
            entity.setTipNastave(tip);
        }
        
        if (dto.getObavestenjaId() != null) {
        	List<Obavestenje> obavestenje = dto.getObavestenjaId().stream()
        			.map(id -> obavestenjeRepository.findById(id)
        					.orElseThrow(() -> new EntityNotFoundException("Obavestenje ID: " + id + " nije pronađeno")))
                    .collect(Collectors.toList());
        	entity.setObavestenja(obavestenje);
        }
    }
}
