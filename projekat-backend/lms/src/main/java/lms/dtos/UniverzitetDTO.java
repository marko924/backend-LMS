package lms.dtos;

import java.time.LocalDate;
import java.util.List;

public class UniverzitetDTO {

    private Long id;
    private String naziv;
    private LocalDate datumOsnivanja;
    private String opis;
    private String kontakt;
    private Long rektorId;
    private List<Long> fakultetId;
    private Long adresaId;
    

    public UniverzitetDTO() {}

    public UniverzitetDTO(Long id, String naziv, LocalDate datumOsnivanja, String opis, String kontakt, Long rektorId,
			List<Long> fakultetId, Long adresaId) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
		this.opis = opis;
		this.kontakt = kontakt;
		this.rektorId = rektorId;
		this.fakultetId = fakultetId;
		this.adresaId = adresaId;
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

    public LocalDate getDatumOsnivanja() {
        return datumOsnivanja;
    }

    public void setDatumOsnivanja(LocalDate datumOsnivanja) {
        this.datumOsnivanja = datumOsnivanja;
    }
    
    public String getOpis() {
		return opis;
	}
	
	public void setOpis(String opis) {
		this.opis= opis;
	}


    public Long getRektorId() {
        return rektorId;
    }

    public void setRektorId(Long rektorId) {
        this.rektorId = rektorId;
    }

    public List<Long> getFakultetId() {
        return fakultetId;
    }

    public void setFakultetId(List<Long> fakultetId) {
        this.fakultetId = fakultetId;
    }

    public Long getAdresaId() {
        return adresaId;
    }

    public void setAdresaId(Long adresaId) {
        this.adresaId = adresaId;
    }

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}
    
}