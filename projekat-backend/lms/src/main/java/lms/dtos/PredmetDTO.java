package lms.dtos;

import java.util.List;

public class PredmetDTO {

    private Long id;
    private String naziv;
    private String opis;
    private Integer espb;
    private boolean obavezan;
    private Integer brojPredavanja;
    private Integer brojVezbi;
    private Integer drugiObliciNastave;
    private Integer istrazivackiRad;
    private Integer ostaliCasovi;
    private Long preduslovId;
    private List<Long> realizacijeId;
    private List<Long> ishodiId;
    
    public PredmetDTO() {}

	public PredmetDTO(Long id, String naziv, String opis, Integer espb, boolean obavezan, Integer brojPredavanja,
			Integer brojVezbi, Integer drugiObliciNastave, Integer istrazivackiRad, Integer ostaliCasovi,
			Long preduslovId, List<Long> realizacijeId, List<Long> ishodiId) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.espb = espb;
		this.obavezan = obavezan;
		this.brojPredavanja = brojPredavanja;
		this.brojVezbi = brojVezbi;
		this.drugiObliciNastave = drugiObliciNastave;
		this.istrazivackiRad = istrazivackiRad;
		this.ostaliCasovi = ostaliCasovi;
		this.preduslovId = preduslovId;
		this.realizacijeId = realizacijeId;
		this.ishodiId = ishodiId;
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

	public List<Long> getRealizacijeId() {
        return realizacijeId;
    }

    public void setRealizacijeId(List<Long> realizacijeId) {
        this.realizacijeId = realizacijeId;
    }

	public boolean isObavezan() {
		return obavezan;
	}

	public void setObavezan(boolean obavezan) {
		this.obavezan = obavezan;
	}

	public Integer getBrojPredavanja() {
		return brojPredavanja;
	}

	public void setBrojPredavanja(Integer brojPredavanja) {
		this.brojPredavanja = brojPredavanja;
	}

	public Integer getBrojVezbi() {
		return brojVezbi;
	}

	public void setBrojVezbi(Integer brojVezbi) {
		this.brojVezbi = brojVezbi;
	}

	public Integer getDrugiObliciNastave() {
		return drugiObliciNastave;
	}

	public void setDrugiObliciNastave(Integer drugiObliciNastave) {
		this.drugiObliciNastave = drugiObliciNastave;
	}

	public Integer getIstrazivackiRad() {
		return istrazivackiRad;
	}

	public void setIstrazivackiRad(Integer istrazivackiRad) {
		this.istrazivackiRad = istrazivackiRad;
	}

	public Integer getOstaliCasovi() {
		return ostaliCasovi;
	}

	public void setOstaliCasovi(Integer ostaliCasovi) {
		this.ostaliCasovi = ostaliCasovi;
	}

	public Long getPreduslovId() {
		return preduslovId;
	}

	public void setPreduslovId(Long preduslovId) {
		this.preduslovId = preduslovId;
	}

	public List<Long> getIshodiId() {
		return ishodiId;
	}

	public void setIshodiId(List<Long> ishodiId) {
		this.ishodiId = ishodiId;
	}
    
}
