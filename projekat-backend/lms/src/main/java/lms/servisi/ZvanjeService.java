package lms.servisi;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.ZvanjeDTO;
import lms.modeli.Nastavnik;
import lms.modeli.NaucnaOblast;
import lms.modeli.TipZvanja;
import lms.modeli.Zvanje;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.NastavnikRepository;
import lms.repozitorijumi.NaucnaOblastRepository;
import lms.repozitorijumi.TipZvanjaRepository;
import lms.repozitorijumi.ZvanjeRepository;

@Service
@Transactional(readOnly = true)
public class ZvanjeService extends AbstractCrusService<ZvanjeDTO, Zvanje, Long> {

    private final ZvanjeRepository zvanjeRepository;
    private final NastavnikRepository nastavnikRepository;
    private final TipZvanjaRepository tipZvanjaRepository;
    private final NaucnaOblastRepository naucnaOblastRepository;

    public ZvanjeService(ZvanjeRepository zvanjeRepository,
                         NastavnikRepository nastavnikRepository,
                         TipZvanjaRepository tipZvanjaRepository,
                         NaucnaOblastRepository naucnaOblastRepository) {
        this.zvanjeRepository = zvanjeRepository;
        this.nastavnikRepository = nastavnikRepository;
        this.tipZvanjaRepository = tipZvanjaRepository;
        this.naucnaOblastRepository = naucnaOblastRepository;
    }

    @Override
    protected LogickoBrisanjeRepozitorijum<Zvanje, Long> getRepository() {
        return zvanjeRepository;
    }

 
    @Override
    protected ZvanjeDTO toDTO(Zvanje entity) {
        ZvanjeDTO dto = new ZvanjeDTO();

        dto.setId(entity.getId());
        dto.setDatumIzbora(entity.getDatumIzbora());
        dto.setDatumOtkaza(entity.getDatumOtkaza());

        if (entity.getNastavnik() != null)
            dto.setNastavnikId(entity.getNastavnik().getId());

        if (entity.getTipZvanja() != null)
            dto.setTipZvanjaId(entity.getTipZvanja().getId());

        if (entity.getNaucnaOblast() != null)
            dto.setNaucnaOblastId(entity.getNaucnaOblast().getId());

        return dto;
    }

    
    @Override
    protected Zvanje toEntity(ZvanjeDTO dto) {
        Zvanje entity = new Zvanje();
        updateEntity(entity, dto);
        return entity;
    }

   
    @Override
    protected void updateEntity(Zvanje entity, ZvanjeDTO dto) {

        entity.setId(dto.getId());
        entity.setDatumIzbora(dto.getDatumIzbora());
        entity.setDatumOtkaza(dto.getDatumOtkaza());

       
        if (dto.getNastavnikId() != null) {
            Nastavnik nastavnik = nastavnikRepository.findById(dto.getNastavnikId())
                .orElseThrow(() -> new EntityNotFoundException("Nastavnik nije pronađen"));
            entity.setNastavnik(nastavnik);
        }

       
        if (dto.getTipZvanjaId() != null) {
            TipZvanja tip = tipZvanjaRepository.findById(dto.getTipZvanjaId())
                .orElseThrow(() -> new EntityNotFoundException("Tip zvanja nije pronađen"));
            entity.setTipZvanja(tip);
        }

        
        if (dto.getNaucnaOblastId() != null) {
            NaucnaOblast oblast = naucnaOblastRepository.findById(dto.getNaucnaOblastId())
                .orElseThrow(() -> new EntityNotFoundException("Naučna oblast nije pronađena"));
            entity.setNaucnaOblast(oblast);
        }
    }
}
