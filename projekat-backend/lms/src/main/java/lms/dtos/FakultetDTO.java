package lms.dtos;

import java.util.List;

public class FakultetDTO {

    private Long id;
    private String naziv;
    private Long univerzitetId;
    private Long dekanId;
    private List<Long> studentskiProgramId;
    private Long adresaId;

    public FakultetDTO() {}

    public FakultetDTO(Long id, String naziv, Long univerzitetId, Long dekanId, List<Long> studentskiProgramId, Long adresaId) {
        this.id = id;
        this.naziv = naziv;
        this.univerzitetId = univerzitetId;
        this.dekanId = dekanId;
        this.studentskiProgramId = studentskiProgramId;
        this.adresaId = adresaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Long getUniverzitetId() {
        return univerzitetId;
    }

    public void setUniverzitetId(Long univerzitetId) {
        this.univerzitetId = univerzitetId;
    }

    public Long getDekanId() {
        return dekanId;
    }

    public void setDekanId(Long dekanId) {
        this.dekanId = dekanId;
    }

    public List<Long> getProgramId() {
        return studentskiProgramId;
    }

    public void setProgramId(List<Long> studentskiProgramId) {
        this.studentskiProgramId = studentskiProgramId;
    }

    public Long getAdresaId() {
        return adresaId;
    }

    public void setAdresaId(Long adresaId) {
        this.adresaId = adresaId;
    }
}
