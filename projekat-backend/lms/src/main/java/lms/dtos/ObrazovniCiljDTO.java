package lms.dtos;

import java.util.Set;

public class ObrazovniCiljDTO {
	
	private Long id;
	private String opis;
	private Set<Long> ishodiId;
	
	public ObrazovniCiljDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ObrazovniCiljDTO(Long id, String opis, Set<Long> ishodiId) {
		super();
		this.id = id;
		this.opis = opis;
		this.ishodiId = ishodiId;
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

	public Set<Long> getIshodiId() {
		return ishodiId;
	}

	public void setIshodiId(Set<Long> ishodiId) {
		this.ishodiId = ishodiId;
	}
	
}
