package lms.servisi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lms.modeli.LogickoBrisanje;
import lms.repozitorijumi.LogickoBrisanjeRepozitorijum;
import lms.repozitorijumi.LogickoBrisanjeSpecifikacija;

//Uvodjenje ove anotacije ja sam rekao da se svaki put proveri transakciju (metodu) pre nego sto je izvrsi
//da se ne bi poslali nedovrseni podaci na backend i da bi smo mogli da ispratimo ako se desila neka greska

@Transactional(readOnly = true) //ovde sam stavio trasakciju tipa readOnly (samo citaj nista se ne menja) zbog svih get metoda u mom generickom servisu
public abstract class AbstractCrusService <DTO, Entity extends LogickoBrisanje, ID> implements CrudService<DTO, ID>{ 
	
	//Ovaj genericki servis ce moci samo da naslede oni entiteti koji nasledjuju klasu LogickoBrisanje
	//On implementira CrudService kako bi mogao de definise svaku metodu iz njega
	
	//Ja sam ovde doda par protected abstract metoda zato sto sam hteo da napravim da samo oni servisi koji mogu da naslede ovaj 
	//genericki servis mogu da implementiraju ove metode zbog toga sto mi konkretno ne znamo koji cemo repozitorijum da uvezemo
	//ili kako ce se mapirati entiteti u dto i obrnuto
	
	protected abstract LogickoBrisanjeRepozitorijum<Entity, ID> getRepository(); //sa ovim dobavljam repozitorijum koji mi je potreban za rad servisa

	protected abstract DTO toDTO(Entity entity);  //mapiranje entiteta u dto

	protected abstract Entity toEntity(DTO dto);  //mapiranje dto u entitet

	protected abstract void updateEntity(Entity entity, DTO dto);  //posebna metoda gde se vrsi logika mapiranja dto-a u entitet
	
	@Override
	public DTO findById(ID id) {
		Entity entity = getRepository().findById(id).filter(e -> !e.isObrisan()) 
				.orElseThrow(() -> new EntityNotFoundException("Not found with id: " + id));
		return toDTO(entity);
	}

	@Override
	public List<DTO> findAll() {
	    return getRepository().findAll(LogickoBrisanjeSpecifikacija.notDeleted()).stream()
	        .map(this::toDTO) 
	        .collect(Collectors.toList());
	}
	
	@Override
	public Page<DTO> findAll(Pageable pageable) {
	    Page<Entity> entitiesPage = getRepository().findAll(
	        LogickoBrisanjeSpecifikacija.notDeleted(), 
	        pageable
	    );
	    
	    // Pretvaramo Page entiteta u Page DTO-ova
	    return entitiesPage.map(this::toDTO); 
	}

	@Transactional //Sa ovim sa pregazio klasni @Transactional da mi se ni bi podaci samo citali vec da bi se mogli izmeniti, obrisati ili dodati
    @Override
    public DTO save(DTO dto) {
        Entity entity = toEntity(dto);
        entity = getRepository().save(entity);
        return toDTO(entity);
    }
	
	@Transactional
    public Entity saveEntity(Entity entity) {
        return getRepository().save(entity);
    }

    @Transactional
    @Override
    public DTO update(ID id, DTO dto) {
        Entity entity = getRepository().findById(id).filter(e -> !e.isObrisan())
                .orElseThrow(() -> new EntityNotFoundException("Not found with id: " + id));
        updateEntity(entity, dto);
        return toDTO(getRepository().save(entity));
    }

    @Transactional
    @Override
    public void delete(ID id) {
        Entity entity = getRepository().findById(id).filter(e -> !e.isObrisan())
                .orElseThrow(() -> new EntityNotFoundException("Not found with id: " + id));
        entity.setObrisan(true);
        getRepository().save(entity);
    }
    
    // findById i findAll će naslediti (readOnly = true) sa nivoa klase
}
