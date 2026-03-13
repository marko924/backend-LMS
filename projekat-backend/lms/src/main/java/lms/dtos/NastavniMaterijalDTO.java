package lms.dtos;

import java.util.List;

public class NastavniMaterijalDTO {

    private Long id;
    private String naziv;
    private String opis;
    private Long ishodId;
    private List<Long> fajlId;

    public NastavniMaterijalDTO() {}

	public NastavniMaterijalDTO(Long id, String naziv, String opis, Long ishodId, List<Long> fajlId) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.ishodId = ishodId;
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

    public Long getIshodId() {
		return ishodId;
	}

	public void setIshodId(Long ishodId) {
		this.ishodId = ishodId;
	}

	public List<Long> getFajlId() {
        return fajlId;
    }

    public void setFajlId(List<Long> fajlId) {
        this.fajlId = fajlId;
    }
    
}
