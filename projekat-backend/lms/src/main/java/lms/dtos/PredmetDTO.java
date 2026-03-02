package lms.dtos;


import java.util.List;
import java.util.Set;

public class PredmetDTO {

    private Long id;
    private String naziv;
    private String opis;
    private Integer espb;
    private Set<Long> studijskiProgramiId; 
    private List<Long> realizacijeId; 

    public PredmetDTO() {}

    public PredmetDTO(Long id, String naziv,String opis, Integer espb, Set<Long> studijskiProgramiId, List<Long> realizacijeId) {
        this.id = id;
        this.naziv = naziv;
        this.opis= opis;
        this.espb = espb;
        this.studijskiProgramiId = studijskiProgramiId;
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
		this.opis= opis;
	}


    public Integer getEspb() {
        return espb;
    }

    public void setEspb(Integer espb) {
        this.espb = espb;
    }

    public Set<Long> getStudijskiProgramiId() {
		return studijskiProgramiId;
	}

	public void setStudijskiProgramiId(Set<Long> studijskiProgramiId) {
		this.studijskiProgramiId = studijskiProgramiId;
	}

	public List<Long> getRealizacijeId() {
        return realizacijeId;
    }

    public void setRealizacijeId(List<Long> realizacijeId) {
        this.realizacijeId = realizacijeId;
    }
}
