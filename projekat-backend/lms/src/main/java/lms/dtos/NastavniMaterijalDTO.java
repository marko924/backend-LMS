package lms.dtos;

import java.util.List;
import java.util.Set;

public class NastavniMaterijalDTO {

    private Long id;
    private String naziv;
    private String opis;
    private List<Long> fajlId;
    private Set<Long> realizacijeId;

    public NastavniMaterijalDTO() {}

    public NastavniMaterijalDTO(Long id, String naziv, String opis, List<Long> fajlId, Set<Long> realizacijeId) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.fajlId = fajlId;
		this.realizacijeId = realizacijeId;
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

	public Set<Long> getRealizacijeId() {
		return realizacijeId;
	}

	public void setRealizacijeId(Set<Long> realizacijeId) {
		this.realizacijeId = realizacijeId;
	}
    
    
}
