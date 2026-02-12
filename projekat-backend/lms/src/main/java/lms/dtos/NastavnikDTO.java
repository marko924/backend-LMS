package lms.dtos;


import java.util.List;

public class NastavnikDTO {

    private Long id; 
    private String ime;
    private String prezime;
    private String biografija;
    private Long adresaId;          
    private List<Long> zvanjaId;  
    private List<Long> angazovanjaId; 

    public NastavnikDTO() {}

    public NastavnikDTO(Long id, String ime, String prezime, String biografija,
                        Long adresaId, List<Long> zvanjaId, List<Long> angazovanjaId) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.biografija = biografija;
        this.adresaId = adresaId;
        this.zvanjaId = zvanjaId;
        this.angazovanjaId = angazovanjaId;
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

    public String getBiografija() {
        return biografija;
    }

    public void setBiografija(String biografija) {
        this.biografija = biografija;
    }

    public Long getAdresaId() {
        return adresaId;
    }

    public void setAdresaId(Long adresaId) {
        this.adresaId = adresaId;
    }

    public List<Long> getZvanjaId() {
        return zvanjaId;
    }

    public void setZvanjaId(List<Long> zvanjaId) {
        this.zvanjaId = zvanjaId;
    }

    public List<Long> getAngazovanjaId() {
        return angazovanjaId;
    }

    public void setAngazovanjaIds(List<Long> angazovanjaId) {
        this.angazovanjaId = angazovanjaId;
    }
}

