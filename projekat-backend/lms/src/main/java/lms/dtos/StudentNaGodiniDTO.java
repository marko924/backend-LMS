package lms.dtos;

import java.time.LocalDate;
import java.util.List;

public class StudentNaGodiniDTO {

    private Long id;
    private String brojIndeksa;
    private LocalDate datumUpisa;
    private Long studentId;          
    private Long godinaStudijaId;   
    private List<Long> pohadjanjaId; 

    public StudentNaGodiniDTO() {}

    public StudentNaGodiniDTO(Long id, String brojIndeksa, LocalDate datumUpisa,
                              Long studentId, Long godinaStudijaId, List<Long> pohadjanjaId) {
        this.id = id;
        this.brojIndeksa = brojIndeksa;
        this.datumUpisa = datumUpisa;
        this.studentId = studentId;
        this.godinaStudijaId = godinaStudijaId;
        this.pohadjanjaId = pohadjanjaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public LocalDate getDatumUpisa() {
        return datumUpisa;
    }

    public void setDatumUpisa(LocalDate datumUpisa) {
        this.datumUpisa = datumUpisa;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getGodinaStudijaId() {
        return godinaStudijaId;
    }

    public void setGodinaStudijaId(Long godinaStudijaId) {
        this.godinaStudijaId = godinaStudijaId;
    }

    public List<Long> getPohadjanjaId() {
        return pohadjanjaId;
    }

    public void setPohadjanjaId(List<Long> pohadjanjaId) {
        this.pohadjanjaId = pohadjanjaId;
    }
}
