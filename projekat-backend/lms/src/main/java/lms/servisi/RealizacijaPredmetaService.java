package lms.servisi;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.RealizacijaPredmetaDTO;
import lms.modeli.Nastavnik;
import lms.modeli.NastavnikNaRealizaciji;
import lms.modeli.Predmet;
import lms.modeli.RealizacijaPredmeta;
import lms.modeli.NastavniMaterijal;
import lms.modeli.TerminNastave;
import lms.modeli.PohadjanjePredmeta;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.NastavnikRepository;
import lms.repozitorijumi.PredmetRepository;
import lms.repozitorijumi.RealizacijaPredmetaRepository;
import lms.repozitorijumi.NastavniMaterijalRepository;
import lms.repozitorijumi.TerminNastaveRepository;
import lms.repozitorijumi.PohadjanjePredmetaRepository;

@Service
@Transactional(readOnly = true)
public class RealizacijaPredmetaService extends AbstractCrusService<RealizacijaPredmetaDTO, RealizacijaPredmeta, Long> {

    @Autowired
    private RealizacijaPredmetaRepository realizacijaPredmetaRepository;
    
    @Autowired
    private PredmetRepository predmetRepository;
    
    @Autowired
    private NastavniMaterijalRepository nastavniMaterijalRepository;
    
    @Autowired
    private TerminNastaveRepository terminNastaveRepository;
    
    @Autowired
    private NastavnikRepository nastavnikRepository;
    

    @Autowired
    private PohadjanjePredmetaRepository pohadjanjePredmetaRepository;

    

    @Override
    protected LogickoBrisanjeRepozitorijum<RealizacijaPredmeta, Long> getRepository() {
        return realizacijaPredmetaRepository;
    }

    @Override
    protected RealizacijaPredmetaDTO toDTO(RealizacijaPredmeta entity) {
        RealizacijaPredmetaDTO dto = new RealizacijaPredmetaDTO();
        dto.setId(entity.getId());

        if (entity.getPredmet() != null) {
            dto.setPredmetId(entity.getPredmet().getId());
        }

        if (entity.getNastavniMaterijali() != null) {
            dto.setNastavniMaterijaliId(entity.getNastavniMaterijali().stream()
            		.map(NastavniMaterijal::getId)
            		.collect(Collectors.toSet()));
        }

        if (entity.getTermini() != null) {
            dto.setTerminiId(entity.getTermini().stream()
                    .map(TerminNastave::getId)
                    .collect(Collectors.toList()));
        }

        if (entity.getNastavnici() != null) {
            dto.setNastavniciId(entity.getNastavnici().stream()
                    .map(nn -> nn.getNastavnik().getId())
                    .collect(Collectors.toList()));
        }

        if (entity.getPohadjanja() != null) {
            dto.setPohadjanjaId(entity.getPohadjanja().stream()
                    .map(PohadjanjePredmeta::getId)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    @Override
    protected RealizacijaPredmeta toEntity(RealizacijaPredmetaDTO dto) {
        RealizacijaPredmeta entity = new RealizacijaPredmeta();
        updateEntity(entity, dto);
        return entity;
    }

    @Override
    protected void updateEntity(RealizacijaPredmeta entity, RealizacijaPredmetaDTO dto) {
        entity.setId(dto.getId());

       
        if (dto.getPredmetId() != null) {
            Predmet predmet = predmetRepository.findById(dto.getPredmetId())
                    .orElseThrow(() -> new EntityNotFoundException("Predmet nije pronađen"));
            entity.setPredmet(predmet);
        }

       
        if (dto.getNastavniMaterijaliId() != null) {
            Set<NastavniMaterijal> materijali = dto.getNastavniMaterijaliId().stream()
            		.map(id -> nastavniMaterijalRepository.findById(id)
            			.orElseThrow(() -> new EntityNotFoundException("Nastavni materijal ID: " + id + " nije pronađen")))
					.collect(Collectors.toSet());
            entity.setNastavniMaterijali(materijali);
        }

      
        if (dto.getTerminiId() != null) {
            List<TerminNastave> termini = dto.getTerminiId().stream()
                    .map(id -> terminNastaveRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Termin ID: " + id + " nije pronađen")))
                    .collect(Collectors.toList());
            entity.setTermini(termini);
        }

        
        if (dto.getNastavniciId() != null) {
            List<NastavnikNaRealizaciji> nastavniciNaRealizaciji = dto.getNastavniciId().stream()
                    .map(id -> {
                        Nastavnik nastavnik = nastavnikRepository.findById(id)
                                .orElseThrow(() -> new EntityNotFoundException("Nastavnik ID: " + id + " nije pronađen"));
                        NastavnikNaRealizaciji nnr = new NastavnikNaRealizaciji();
                        nnr.setNastavnik(nastavnik);
                        nnr.setRealizacija(entity);
                        return nnr;
                    })
                    .collect(Collectors.toList());
            entity.setNastavnici(nastavniciNaRealizaciji);
        }

        
        if (dto.getPohadjanjaId() != null) {
            List<PohadjanjePredmeta> pohadjanja = dto.getPohadjanjaId().stream()
                    .map(id -> pohadjanjePredmetaRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("PohadjanjePredmeta ID: " + id + " nije pronađen")))
                    .collect(Collectors.toList());
            entity.setPohadjanja(pohadjanja);
        }
    }
}
