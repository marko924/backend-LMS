package lms.kontroleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import lms.dtos.PrijaviIspitDTO;
import lms.servisi.CrudService;
import lms.servisi.PrijaviIspitService;
import java.util.List;

@RestController
@RequestMapping("/api/prijave-ispita")
public class PrijaviIspitController extends AbstractCrudController<PrijaviIspitDTO, Long> {

    @Autowired
    private PrijaviIspitService service;

    @Override
    protected CrudService<PrijaviIspitDTO, Long> getService() {
        return service;
    }

   
    @GetMapping("/dostupni/{studentNaGodiniId}")
    public ResponseEntity<List<PrijaviIspitDTO>> getDostupniZaStudenta(@PathVariable Long studentNaGodiniId) {
        try {
            List<PrijaviIspitDTO> dostupni = service.getDostupniZaStudenta(studentNaGodiniId);
            return ResponseEntity.ok(dostupni);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

  
    }
