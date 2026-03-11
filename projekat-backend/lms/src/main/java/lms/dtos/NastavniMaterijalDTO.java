package lms.dtos;

import java.util.List;

public class NastavniMaterijalDTO {

    private Long id;
    private String naziv;
    private String opis;
    private List<Long> fajlId;

    public NastavniMaterijalDTO() {}

    public NastavniMaterijalDTO(Long id, String naziv, String opis, List<Long> fajlId) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.fajlId = fajlId;
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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public List<Long> getFajlId() {
        return fajlId;
    }

    public void setFajlId(List<Long> fajlId) {
        this.fajlId = fajlId;
    }
    
}
