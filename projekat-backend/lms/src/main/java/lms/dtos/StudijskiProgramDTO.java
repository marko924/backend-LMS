package lms.dtos;



import java.util.List;

public class StudijskiProgramDTO {

    private Long id;
    private String naziv;
    private Long fakultetId;       
    private Long rukovodilacId;    
    private List<Long> predmetiId; 

    public StudijskiProgramDTO() {}

    public StudijskiProgramDTO(Long id, String naziv, Long fakultetId, Long rukovodilacId, List<Long> predmetiId) {
        this.id = id;
        this.naziv = naziv;
        this.fakultetId = fakultetId;
        this.rukovodilacId = rukovodilacId;
        this.predmetiId = predmetiId;
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

    public Long getFakultetId() {
        return fakultetId;
    }

    public void setFakultetId(Long fakultetId) {
        this.fakultetId = fakultetId;
    }

    public Long getRukovodilacId() {
        return rukovodilacId;
    }

    public void setRukovodilacId(Long rukovodilacId) {
        this.rukovodilacId = rukovodilacId;
    }

    public List<Long> getPredmetiId() {
        return predmetiId;
    }

    public void setPredmetiId(List<Long> predmetiId) {
        this.predmetiId = predmetiId;
    }
}
