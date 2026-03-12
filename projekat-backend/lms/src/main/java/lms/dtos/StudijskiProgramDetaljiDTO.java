package lms.dtos;

import java.util.List;

public class StudijskiProgramDetaljiDTO {
	
	private Long id;
    private String naziv;
    private String opis;
    private String fakultetNaziv;
    private String rukovodilacIme;
    private String rukovodilacPrezime;
    private String rukovodilacEmail;
    private List<GodinaStudijaDetaljiDTO> godineStudija;
	
    public StudijskiProgramDetaljiDTO() {}

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

	public String getFakultetNaziv() {
		return fakultetNaziv;
	}

	public void setFakultetNaziv(String fakultetNaziv) {
		this.fakultetNaziv = fakultetNaziv;
	}

	public String getRukovodilacIme() {
		return rukovodilacIme;
	}

	public void setRukovodilacIme(String rukovodilacIme) {
		this.rukovodilacIme = rukovodilacIme;
	}

	public String getRukovodilacPrezime() {
		return rukovodilacPrezime;
	}

	public void setRukovodilacPrezime(String rukovodilacPrezime) {
		this.rukovodilacPrezime = rukovodilacPrezime;
	}

	public String getRukovodilacEmail() {
		return rukovodilacEmail;
	}

	public void setRukovodilacEmail(String rukovodilacEmail) {
		this.rukovodilacEmail = rukovodilacEmail;
	}

	public List<GodinaStudijaDetaljiDTO> getGodineStudija() {
		return godineStudija;
	}

	public void setGodineStudija(List<GodinaStudijaDetaljiDTO> godineStudija) {
		this.godineStudija = godineStudija;
	}
    
}
