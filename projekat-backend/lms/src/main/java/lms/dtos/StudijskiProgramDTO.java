package lms.dtos;

import java.util.List;

public class StudijskiProgramDTO {

    private Long id;
    private String naziv;
    private String opis;
    private Long fakultetId;       
    private Long rukovodilacId;    
    private List<Long> godineStudijaId;

    public StudijskiProgramDTO() {}

    public StudijskiProgramDTO(Long id, String naziv, String opis, Long fakultetId, Long rukovodilacId,
			List<Long> godineStudijaId) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.fakultetId = fakultetId;
		this.rukovodilacId = rukovodilacId;
		this.godineStudijaId = godineStudijaId;
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

	public List<Long> getGodineStudijaId() {
		return godineStudijaId;
	}

	public void setGodineStudijaId(List<Long> godineStudijaId) {
		this.godineStudijaId = godineStudijaId;
	}

}
