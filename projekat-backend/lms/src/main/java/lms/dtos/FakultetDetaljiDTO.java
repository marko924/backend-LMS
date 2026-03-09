package lms.dtos;

public class FakultetDetaljiDTO {
	
	private Long id;
    private String naziv;
    private String opis;
    
    private Long univerzitetId;
    private String univerzitetNaziv;

    private String dekanIme;
    private String dekanPrezime;
    private String dekanEmail;

    private String ulica;
    private String broj;
    private String mestoNaziv;

    public FakultetDetaljiDTO() {}

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

	public Long getUniverzitetId() {
		return univerzitetId;
	}

	public void setUniverzitetId(Long univerzitetId) {
		this.univerzitetId = univerzitetId;
	}

	public String getUniverzitetNaziv() {
		return univerzitetNaziv;
	}

	public void setUniverzitetNaziv(String univerzitetNaziv) {
		this.univerzitetNaziv = univerzitetNaziv;
	}

	public String getDekanIme() {
		return dekanIme;
	}

	public void setDekanIme(String dekanIme) {
		this.dekanIme = dekanIme;
	}

	public String getDekanPrezime() {
		return dekanPrezime;
	}

	public void setDekanPrezime(String dekanPrezime) {
		this.dekanPrezime = dekanPrezime;
	}

	public String getDekanEmail() {
		return dekanEmail;
	}

	public void setDekanEmail(String dekanEmail) {
		this.dekanEmail = dekanEmail;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public String getMestoNaziv() {
		return mestoNaziv;
	}

	public void setMestoNaziv(String mestoNaziv) {
		this.mestoNaziv = mestoNaziv;
	}
    
    
}
