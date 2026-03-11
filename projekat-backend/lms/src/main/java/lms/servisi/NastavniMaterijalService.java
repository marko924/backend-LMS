package lms.servisi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.NastavniMaterijalDTO;
import lms.modeli.NastavniMaterijal;
import lms.modeli.Fajl;
import lms.repozitorijumi.FajlRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.NastavniMaterijalRepository;

@Service
@Transactional(readOnly = true)
public class NastavniMaterijalService extends AbstractCrusService<NastavniMaterijalDTO, NastavniMaterijal, Long> {

    @Autowired
    private NastavniMaterijalRepository nastavniMaterijalRepository;
    
    @Autowired
    private FajlRepository fajlRepository;

    @Override
    protected LogickoBrisanjeRepozitorijum<NastavniMaterijal, Long> getRepository() {
        return nastavniMaterijalRepository;
    }

    
    @Override
    protected NastavniMaterijalDTO toDTO(NastavniMaterijal entity) {
        NastavniMaterijalDTO dto = new NastavniMaterijalDTO();
        dto.setId(entity.getId());
        dto.setNaziv(entity.getNaziv());
        dto.setOpis(entity.getOpis());

        if(entity.getFajlovi() != null) {
            dto.setFajlId(entity.getFajlovi().stream()
                    .map(Fajl::getId)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    
    @Override
    protected NastavniMaterijal toEntity(NastavniMaterijalDTO dto) {
        NastavniMaterijal entity = new NastavniMaterijal();
        updateEntity(entity, dto);
        return entity;
    }

    
    @Override
    protected void updateEntity(NastavniMaterijal entity, NastavniMaterijalDTO dto) {
        entity.setId(dto.getId());
        entity.setNaziv(dto.getNaziv());
        entity.setOpis(dto.getOpis());

        if(dto.getFajlId() != null) {
            List<Fajl> fajlovi = dto.getFajlId().stream()
                    .map(id -> fajlRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Fajl ID: " + id + " nije pronađen")))
                    .collect(Collectors.toList());
            entity.setFajlovi(fajlovi);
        }
    }
}
