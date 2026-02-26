package lms.servisi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.NastavnikDTO;

import lms.modeli.Adresa;
import lms.modeli.Nastavnik;
import lms.modeli.NastavnikNaRealizaciji;
import lms.modeli.Zvanje;
import lms.repozitorijumi.AdresaRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.NastavnikNaRealizacijiRepository;
import lms.repozitorijumi.NastavnikRepository;
import lms.repozitorijumi.ZvanjeRepository;

@Service
@Transactional(readOnly = true)
public class NastavnikService extends AbstractCrusService<NastavnikDTO, Nastavnik, Long> {
	
	@Autowired
	NastavnikRepository nastavnikRepository;
    
	@Autowired
	AdresaRepository adresaRepository;
    
	@Autowired
	ZvanjeRepository zvanjeRepository;
    
	@Autowired
	NastavnikNaRealizacijiRepository angazovanjeRepository;

    

    @Override
    protected LogickoBrisanjeRepozitorijum<Nastavnik, Long> getRepository() {
        return nastavnikRepository;
    }

   
    @Override
    protected NastavnikDTO toDTO(Nastavnik entity) {
        NastavnikDTO dto = new NastavnikDTO();

        dto.setId(entity.getId());
        dto.setIme(entity.getIme());
        dto.setPrezime(entity.getPrezime());
        dto.setBiografija(entity.getBiografija());
        dto.setKorisnickoIme(entity.getKorisnickoIme());
        dto.setLozinka(entity.getLozinka());
        dto.setEmail(entity.getEmail());

        if (entity.getAdresa() != null) {
            dto.setAdresaId(entity.getAdresa().getId());
        }

        if (entity.getZvanja() != null) {
            dto.setZvanjaId(
                entity.getZvanja().stream()
                    .map(Zvanje::getId)
                    .collect(Collectors.toList())
            );
        }

        if (entity.getAngazovanja() != null) {
            dto.setAngazovanjaId(
                entity.getAngazovanja().stream()
                    .map(NastavnikNaRealizaciji::getId)
                    .collect(Collectors.toList())
            );
        }

        return dto;
    }

  
    @Override
    protected Nastavnik toEntity(NastavnikDTO dto) {
        Nastavnik entity = new Nastavnik();
        updateEntity(entity, dto);
        return entity;
    }

  
    @Override
    protected void updateEntity(Nastavnik entity, NastavnikDTO dto) {

        entity.setId(dto.getId());
        entity.setIme(dto.getIme());
        entity.setPrezime(dto.getPrezime());
        entity.setBiografija(dto.getBiografija());
        entity.setKorisnickoIme(dto.getKorisnickoIme());
        entity.setLozinka(dto.getLozinka());
        entity.setEmail(dto.getEmail());

       
        if (dto.getAdresaId() != null) {
            Adresa adresa = adresaRepository.findById(dto.getAdresaId())
                .orElseThrow(() -> new EntityNotFoundException("Adresa nije pronađena"));
            entity.setAdresa(adresa);
        }

        
        if (dto.getZvanjaId() != null) {
            List<Zvanje> zvanja = dto.getZvanjaId().stream()
                .map(id -> zvanjeRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Zvanje ID: " + id + " nije pronađeno")))
                .collect(Collectors.toList());

            entity.setZvanja(zvanja);
        }

       
        if (dto.getAngazovanjaId() != null) {
            List<NastavnikNaRealizaciji> angazovanja = dto.getAngazovanjaId().stream()
                .map(id -> angazovanjeRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Angažovanje ID: " + id + " nije pronađeno")))
                .collect(Collectors.toList());

            entity.setAngazovanja(angazovanja);
        }
    }
}
