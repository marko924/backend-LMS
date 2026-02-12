package lms.dtos;

import java.util.List;

public class StudentDTO {

    private Long id; 
    private String ime;
    private String prezime;
    private String jmbg;
    private Long adresaId; 
    private List<Long> upisiId; 

    public StudentDTO() {}

    public StudentDTO(Long id, String ime, String prezime, String jmbg, Long adresaId, List<Long> upisiId) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.adresaId = adresaId;
        this.upisiId = upisiId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public Long getAdresaId() {
        return adresaId;
    }

    public void setAdresaId(Long adresaId) {
        this.adresaId = adresaId;
    }

    public List<Long> getUpisiId() {
        return upisiId;
    }

    public void setUpisiId(List<Long> upisiId) {
        this.upisiId = upisiId;
    }
}