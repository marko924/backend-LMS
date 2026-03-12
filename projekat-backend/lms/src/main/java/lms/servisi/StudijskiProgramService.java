package lms.servisi;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.dtos.GodinaStudijaDetaljiDTO;
import lms.dtos.PredmetDetaljiDTO;
import lms.dtos.StudijskiProgramDTO;
import lms.dtos.StudijskiProgramDetaljiDTO;
import lms.modeli.Fakultet;
import lms.modeli.GodinaStudija;
import lms.modeli.Nastavnik;
import lms.modeli.StudijskiProgram;
import lms.repozitorijumi.FakultetRepository;
import lms.repozitorijumi.GodinaStudijaRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.NastavnikRepository;
import lms.repozitorijumi.StudijskiProgramRepository;

@Service
@Transactional(readOnly = true)
public class StudijskiProgramService extends AbstractCrusService<StudijskiProgramDTO, StudijskiProgram, Long> {
	
	@Autowired
	private StudijskiProgramRepository studijskiProgramRepository;
     
	@Autowired
	private FakultetRepository fakultetRepository;
     
	@Autowired
	private NastavnikRepository nastavnikRepository;
     
	@Autowired
	private GodinaStudijaRepository godinaStudijaRepository;

    @Override
    protected LogickoBrisanjeRepozitorijum<StudijskiProgram, Long> getRepository() {
        return studijskiProgramRepository;
    }

   
    @Override
    protected StudijskiProgramDTO toDTO(StudijskiProgram entity) {
        StudijskiProgramDTO dto = new StudijskiProgramDTO();
        dto.setId(entity.getId());
        dto.setNaziv(entity.getNaziv());
        dto.setOpis(entity.getOpis());

        if (entity.getFakultet() != null) {
            dto.setFakultetId(entity.getFakultet().getId());
        }

        if (entity.getRukovodilac() != null) {
            dto.setRukovodilacId(entity.getRukovodilac().getId());
        }

        if (entity.getGodineStudija() != null) {
        	dto.setGodineStudijaId(entity.getGodineStudija().stream()
        			.map(GodinaStudija::getId)
        			.collect(Collectors.toList()));
        }

        return dto;
    }

    
    @Override
    protected StudijskiProgram toEntity(StudijskiProgramDTO dto) {
        StudijskiProgram entity = new StudijskiProgram();
        updateEntity(entity, dto);
        return entity;
    }

 
    @Override
    protected void updateEntity(StudijskiProgram entity, StudijskiProgramDTO dto) {
        entity.setId(dto.getId());
        entity.setNaziv(dto.getNaziv());
        entity.setOpis(dto.getOpis());

       
        if (dto.getFakultetId() != null) {
            Fakultet fakultet = fakultetRepository.findById(dto.getFakultetId())
                    .orElseThrow(() -> new EntityNotFoundException("Fakultet nije pronađen"));
            entity.setFakultet(fakultet);
        }

        
        if (dto.getRukovodilacId() != null) {
            Nastavnik rukovodilac = nastavnikRepository.findById(dto.getRukovodilacId())
                    .orElseThrow(() -> new EntityNotFoundException("Rukovodilac nije pronađen"));
            entity.setRukovodilac(rukovodilac);
        }

       
        if (dto.getGodineStudijaId() != null) {
        	Set<GodinaStudija> godineStudija = dto.getGodineStudijaId().stream()
        			.map(id -> godinaStudijaRepository.findById(id)
        					.orElseThrow(() -> new EntityNotFoundException("Godina studija ID: " + id + " nije pronađen")))
					.collect(Collectors.toSet());
        	entity.setGodineStudija(godineStudija);
        }
    }
    
    public StudijskiProgramDetaljiDTO getDetaljiPrograma(Long id) {
        StudijskiProgram program = studijskiProgramRepository.findByIdWithDetails(id)
                .orElseThrow(() -> new EntityNotFoundException("Studijski program nije pronađen"));

        StudijskiProgramDetaljiDTO dto = new StudijskiProgramDetaljiDTO();
        dto.setId(program.getId());
        dto.setNaziv(program.getNaziv());
        dto.setOpis(program.getOpis());

        if (program.getFakultet() != null) {
            dto.setFakultetNaziv(program.getFakultet().getNaziv());
        }

        if (program.getRukovodilac() != null) {
            dto.setRukovodilacIme(program.getRukovodilac().getIme());
            dto.setRukovodilacPrezime(program.getRukovodilac().getPrezime());
            dto.setRukovodilacEmail(program.getRukovodilac().getEmail());
        }

        if (program.getGodineStudija() != null) {
            List<GodinaStudijaDetaljiDTO> godineDTO = program.getGodineStudija().stream()
                .filter(gs -> !gs.isObrisan()) 
                .sorted(Comparator.comparing(GodinaStudija::getGodina))
                .map(gs -> {
                    GodinaStudijaDetaljiDTO gsDto = new GodinaStudijaDetaljiDTO();
                    gsDto.setId(gs.getId());
                    gsDto.setGodina(gs.getGodina());

                    if (gs.getPredmeti() != null) {
                        List<PredmetDetaljiDTO> predmetiDTO = gs.getPredmeti().stream()
                            .filter(p -> !p.isObrisan())
                            .map(p -> {
                                PredmetDetaljiDTO pDto = new PredmetDetaljiDTO();
                                pDto.setId(p.getId());
                                pDto.setNaziv(p.getNaziv());
                                pDto.setOpis(p.getOpis());
                                pDto.setEspb(p.getEspb());
                                return pDto;
                            })
                            .collect(Collectors.toList());
                        
                        gsDto.setPredmeti(predmetiDTO);
                    }
                    return gsDto;
                })
                .collect(Collectors.toList());

            dto.setGodineStudija(godineDTO);
        }

        return dto;
    }
}
