package lms.kontroleri;

import java.util.List;

import jakarta.validation.Valid;

import lms.servisi.CrudService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class AbstractCrudController<DTO, ID> {

    protected abstract CrudService<DTO, ID> getService();

    
    @GetMapping("/{id}")
    public ResponseEntity<DTO> getOne(@PathVariable ID id) {
        return ResponseEntity.ok(getService().findById(id));
    }

    
    @GetMapping
    public ResponseEntity<Page<DTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(getService().findAll(pageable));
    }

    
    @GetMapping("/all")
    public ResponseEntity<List<DTO>> getAllWithoutPagination() {
        return ResponseEntity.ok(getService().findAll());
    }

    
    @PostMapping
    public ResponseEntity<DTO> create(@Valid @RequestBody DTO dto) {
        DTO saved = getService().save(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<DTO> update(@PathVariable ID id,
                                      @Valid @RequestBody DTO dto) {
        DTO updated = getService().update(id, dto);
        return ResponseEntity.ok(updated);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }
}
