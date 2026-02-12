package lms.dtos;

public class NaucnaOblastDTO {

    private Long id;
    private String naziv;

    public NaucnaOblastDTO() {}

    public NaucnaOblastDTO(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
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
}
