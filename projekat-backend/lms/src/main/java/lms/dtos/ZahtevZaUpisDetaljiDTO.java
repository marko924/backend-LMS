package lms.dtos;

import java.time.LocalDateTime;

import lms.modeli.StatusZahteva;

public class ZahtevZaUpisDetaljiDTO {
	
	private Long id;
    private String studentImePrezime;
    private String studentEmail;
    private String fakultetNaziv;
    private String studijskiProgramNaziv;
    private Integer godinaStudijaBroj; 
    private StatusZahteva status;
    private LocalDateTime vremePodnosenja;
    private String napomena;
    
	public ZahtevZaUpisDetaljiDTO() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudentImePrezime() {
		return studentImePrezime;
	}

	public void setStudentImePrezime(String studentImePrezime) {
		this.studentImePrezime = studentImePrezime;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getFakultetNaziv() {
		return fakultetNaziv;
	}

	public void setFakultetNaziv(String fakultetNaziv) {
		this.fakultetNaziv = fakultetNaziv;
	}

	public String getStudijskiProgramNaziv() {
		return studijskiProgramNaziv;
	}

	public void setStudijskiProgramNaziv(String studijskiProgramNaziv) {
		this.studijskiProgramNaziv = studijskiProgramNaziv;
	}

	public Integer getGodinaStudijaBroj() {
		return godinaStudijaBroj;
	}

	public void setGodinaStudijaBroj(Integer godinaStudijaBroj) {
		this.godinaStudijaBroj = godinaStudijaBroj;
	}

	public StatusZahteva getStatus() {
		return status;
	}

	public void setStatus(StatusZahteva status) {
		this.status = status;
	}

	public LocalDateTime getVremePodnosenja() {
		return vremePodnosenja;
	}

	public void setVremePodnosenja(LocalDateTime vremePodnosenja) {
		this.vremePodnosenja = vremePodnosenja;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
    
}
