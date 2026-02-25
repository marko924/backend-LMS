package lms.servisi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.UniverzitetDTO;
import lms.modeli.Adresa;
import lms.modeli.Fakultet;
import lms.modeli.Nastavnik;
import lms.modeli.Univerzitet;
import lms.repozitorijumi.AdresaRepository;
import lms.repozitorijumi.FakultetRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.NastavnikRepository;
import lms.repozitorijumi.UniverzitetRepository;

@Service
@Transactional(readOnly = true)
public class UniverzitetService extends AbstractCrusService<UniverzitetDTO, Univerzitet, Long> {

    private final UniverzitetRepository univerzitetRepository;
    private final NastavnikRepository nastavnikRepository;
    private final FakultetRepository fakultetRepository;
    private final AdresaRepository adresaRepository;

    public UniverzitetService(UniverzitetRepository univerzitetRepository,
                              NastavnikRepository nastavnikRepository,
                              FakultetRepository fakultetRepository,
                              AdresaRepository adresaRepository) {
        this.univerzitetRepository = univerzitetRepository;
        this.nastavnikRepository = nastavnikRepository;
        this.fakultetRepository = fakultetRepository;
        this.adresaRepository = adresaRepository;
    }

    @Override
    protected LogickoBrisanjeRepozitorijum<Univerzitet, Long> getRepository() {
        return univerzitetRepository;
    }

   
    @Override
    protected UniverzitetDTO toDTO(Univerzitet entity) {
        UniverzitetDTO dto = new UniverzitetDTO();
        dto.setId(entity.getId());
        dto.setNaziv(entity.getNaziv());
        dto.setDatumOsnivanja(entity.getDatumOsnivanja());
        dto.setOpis(entity.getOpis());
        dto.setRektorId(entity.getRektor() != null ? entity.getRektor().getId() : null);
        dto.setFakultetId(entity.getFakulteti() != null
                ? entity.getFakulteti().stream()
                        .map(Fakultet::getId)
                        .collect(Collectors.toList())
                : null);
        dto.setAdresaId(entity.getAdresa() != null ? entity.getAdresa().getId() : null);
        return dto;
    }

   
    @Override
    protected Univerzitet toEntity(UniverzitetDTO dto) {
        Univerzitet entity = new Univerzitet();
        updateEntity(entity, dto);
        return entity;
    }

    @Override
    protected void updateEntity(Univerzitet entity, UniverzitetDTO dto) {
        entity.setId(dto.getId());
        entity.setNaziv(dto.getNaziv());
        entity.setDatumOsnivanja(dto.getDatumOsnivanja());
        entity.setOpis(dto.getOpis());

       
        if (dto.getRektorId() != null) {
            Nastavnik rektor = nastavnikRepository.findById(dto.getRektorId())
                    .orElseThrow(() -> new EntityNotFoundException("Rektor nije pronađen"));
            entity.setRektor(rektor);
        }

      
        if (dto.getFakultetId() != null) {
            List<Fakultet> fakulteti = dto.getFakultetId().stream()
                    .map(id -> fakultetRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Fakultet ID: " + id + " nije pronađen")))
                    .collect(Collectors.toList());
            entity.setFakulteti(fakulteti);
        }

        if (dto.getAdresaId() != null) {
            Adresa adresa = adresaRepository.findById(dto.getAdresaId())
                    .orElseThrow(() -> new EntityNotFoundException("Adresa nije pronađena"));
            entity.setAdresa(adresa);
        }
    }
}
