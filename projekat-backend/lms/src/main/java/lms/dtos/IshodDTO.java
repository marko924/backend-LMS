package lms.dtos;

import java.util.Set;

public class IshodDTO {
	
	private Long id;
	private String opis;
	private Long predmetId;
	private Set<Long> obrazovniCiljeviId;
	
	public IshodDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public IshodDTO(Long id, String opis, Long predmetId, Set<Long> obrazovniCiljeviId) {
		super();
		this.id = id;
		this.opis = opis;
		this.predmetId = predmetId;
		this.obrazovniCiljeviId = obrazovniCiljeviId;
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
	public Long getPredmetId() {
		return predmetId;
	}
	public void setPredmetId(Long predmetId) {
		this.predmetId = predmetId;
	}
	public Set<Long> getObrazovniCiljeviId() {
		return obrazovniCiljeviId;
	}
	public void setObrazovniCiljeviId(Set<Long> obrazovniCiljeviId) {
		this.obrazovniCiljeviId = obrazovniCiljeviId;
	}
	
	
}
