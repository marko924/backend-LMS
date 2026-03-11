package lms.dtos;

import java.util.List;

public class InstrumentEvaluacijeDTO {
	
	private Long id;
	private String naziv;
	private String opis;
	private List<Long> fajloviId;
	
	public InstrumentEvaluacijeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InstrumentEvaluacijeDTO(Long id, String naziv, String opis, List<Long> fajloviId) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.fajloviId = fajloviId;
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
	public List<Long> getFajloviId() {
		return fajloviId;
	}
	public void setFajloviId(List<Long> fajloviId) {
		this.fajloviId = fajloviId;
	}
	
}
