package lms.servisi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import lms.dtos.GodinaStudijaDTO;
import lms.modeli.GodinaStudija;
import lms.repozitorijumi.GodinaStudijaRepository;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;

@Service
@Transactional(readOnly = true)
public class GodinaStudijaService extends AbstractCrusService<GodinaStudijaDTO, GodinaStudija, Long> {

	@Autowired
	private GodinaStudijaRepository godinaStudijaRepository;

    

    @Override
    protected LogickoBrisanjeRepozitorijum<GodinaStudija, Long> getRepository() {
        return godinaStudijaRepository;
    }

   
    @Override
    protected GodinaStudijaDTO toDTO(GodinaStudija entity) {
        GodinaStudijaDTO dto = new GodinaStudijaDTO();
        dto.setId(entity.getId());
        dto.setGodina(entity.getGodina());
        return dto;
    }

   
    @Override
    protected GodinaStudija toEntity(GodinaStudijaDTO dto) {
        GodinaStudija entity = new GodinaStudija();
        updateEntity(entity, dto);
        return entity;
    }

  
    @Override
    protected void updateEntity(GodinaStudija entity, GodinaStudijaDTO dto) {
        entity.setId(dto.getId());
        entity.setGodina(dto.getGodina());
    }
}
