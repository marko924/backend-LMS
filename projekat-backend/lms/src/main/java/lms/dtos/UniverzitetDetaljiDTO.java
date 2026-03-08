package lms.dtos;

import java.time.LocalDate;

public class UniverzitetDetaljiDTO {
	
	private Long id;
    private String naziv;
    private LocalDate datumOsnivanja;
    private String opis;
    private String kontakt;

    private String ulica;
    private String broj;
    private String mestoNaziv;

    private String rektorIme;
    private String rektorPrezime;
    private String rektorEmail;
    private String rektorBiografija;

    public UniverzitetDetaljiDTO() {
    	
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
		this.opis = opis;
	}

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
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

	public String getRektorIme() {
		return rektorIme;
	}

	public void setRektorIme(String rektorIme) {
		this.rektorIme = rektorIme;
	}

	public String getRektorPrezime() {
		return rektorPrezime;
	}

	public void setRektorPrezime(String rektorPrezime) {
		this.rektorPrezime = rektorPrezime;
	}

	public String getRektorEmail() {
		return rektorEmail;
	}

	public void setRektorEmail(String rektorEmail) {
		this.rektorEmail = rektorEmail;
	}

	public String getRektorBiografija() {
		return rektorBiografija;
	}

	public void setRektorBiografija(String rektorBiografija) {
		this.rektorBiografija = rektorBiografija;
	}

}
