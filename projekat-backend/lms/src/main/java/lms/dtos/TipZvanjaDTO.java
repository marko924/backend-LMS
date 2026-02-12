package lms.dtos;

public class TipZvanjaDTO {

    private Long id;
    private String naziv;

    public TipZvanjaDTO() {}

    public TipZvanjaDTO(Long id, String naziv) {
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