package lms.dtos;

public class AdresaDTO {
	
	private Long id;
	private String ulica;
	private String broj;
	private Long mestoId;
	
	public AdresaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AdresaDTO(Long id, String ulica, String broj, Long mestoId) {
		super();
		this.id = id;
		this.ulica = ulica;
		this.broj = broj;
		this.mestoId = mestoId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getMestoId() {
		return mestoId;
	}
	public void setMestoId(Long mestoId) {
		this.mestoId = mestoId;
	}
	
}
