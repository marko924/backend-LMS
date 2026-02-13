package lms.dtos;

public class MestoDTO {
	
	private Long id;
	private String naziv;
	private Long drzavaId;
	
	public MestoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MestoDTO(Long id, String naziv, Long drzavaId) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.drzavaId = drzavaId;
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
	public Long getDrzavaId() {
		return drzavaId;
	}
	public void setDrzavaId(Long drzavaId) {
		this.drzavaId = drzavaId;
	}
	
}
