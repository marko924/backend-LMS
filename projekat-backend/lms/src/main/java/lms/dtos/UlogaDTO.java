package lms.dtos;

public class UlogaDTO {
	
	private Long id;
	private String naziv;
	
	public UlogaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UlogaDTO(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
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
	
}
