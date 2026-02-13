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

@Transactional(readOnly = true)
public abstract class AbstractCrusService <DTO, Entity extends LogickoBrisanje, ID> implements CrudService<DTO, ID>{
	
	protected abstract LogickoBrisanjeRepozitorijum<Entity, ID> getRepository();

	protected abstract DTO toDTO(Entity entity);

	protected abstract Entity toEntity(DTO dto);

	protected abstract void updateEntity(Entity entity, DTO dto);
	
	@Override
	public DTO findById(ID id) {
		Entity entity = getRepository().findById(id).filter(e -> !e.isDeleted()) 
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

	@Transactional // Ovo nadjačava readOnly i dozvoljava pisanje u bazu
    @Override
    public DTO save(DTO dto) {
        Entity entity = toEntity(dto);
        entity = getRepository().save(entity);
        return toDTO(entity);
    }

    @Transactional
    @Override
    public DTO update(ID id, DTO dto) {
        Entity entity = getRepository().findById(id).filter(e -> !e.isDeleted())
                .orElseThrow(() -> new EntityNotFoundException("Not found with id: " + id));
        updateEntity(entity, dto);
        return toDTO(getRepository().save(entity));
    }

    @Transactional
    @Override
    public void delete(ID id) {
        Entity entity = getRepository().findById(id).filter(e -> !e.isDeleted())
                .orElseThrow(() -> new EntityNotFoundException("Not found with id: " + id));
        entity.setDeleted(true);
        // Sa @Transactional, getRepository().save(entity) tehnički nije ni potreban 
        // jer Hibernate automatski radi "flush" promena pre kraja transakcije
        getRepository().save(entity);
    }
    
    // findById i findAll će naslediti (readOnly = true) sa nivoa klase
}
