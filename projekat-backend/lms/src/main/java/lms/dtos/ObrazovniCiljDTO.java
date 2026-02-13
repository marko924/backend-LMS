package lms.dtos;

public class ObrazovniCiljDTO {
	
	private Long id;
	private String opis;
	
	public ObrazovniCiljDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ObrazovniCiljDTO(Long id, String opis) {
		super();
		this.id = id;
		this.opis = opis;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
}
