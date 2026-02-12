package lms.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class TemaDTO {
	
	private Long id;
	private String naslov;
	private LocalDateTime vremeKreiranja = LocalDateTime.now();
	private Long forumId;
	private Long autorId;
	private List<Long> objaveId;
	
	public TemaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TemaDTO(Long id, String naslov, LocalDateTime vremeKreiranja, Long forumId, Long autorId,
			List<Long> objaveId) {
		super();
		this.id = id;
		this.naslov = naslov;
		this.vremeKreiranja = vremeKreiranja;
		this.forumId = forumId;
		this.autorId = autorId;
		this.objaveId = objaveId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	public LocalDateTime getVremeKreiranja() {
		return vremeKreiranja;
	}
	public void setVremeKreiranja(LocalDateTime vremeKreiranja) {
		this.vremeKreiranja = vremeKreiranja;
	}
	public Long getForumId() {
		return forumId;
	}
	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}
	public Long getAutorId() {
		return autorId;
	}
	public void setAutorId(Long autorId) {
		this.autorId = autorId;
	}
	public List<Long> getObjaveId() {
		return objaveId;
	}
	public void setObjaveId(List<Long> objaveId) {
		this.objaveId = objaveId;
	}
	
}
