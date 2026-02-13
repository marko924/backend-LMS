package lms.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class ObjavaDTO {
	
	private Long id;
	private String sadrzaj;
	private LocalDateTime vremeObjave = LocalDateTime.now();
	private Long temaId;
	private Long autorId;
	private List<Long> fajloviId;
	
	public ObjavaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ObjavaDTO(Long id, String sadrzaj, LocalDateTime vremeObjave, Long temaId, Long autorId,
			List<Long> fajloviId) {
		super();
		this.id = id;
		this.sadrzaj = sadrzaj;
		this.vremeObjave = vremeObjave;
		this.temaId = temaId;
		this.autorId = autorId;
		this.fajloviId = fajloviId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSadrzaj() {
		return sadrzaj;
	}
	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}
	public LocalDateTime getVremeObjave() {
		return vremeObjave;
	}
	public void setVremeObjave(LocalDateTime vremeObjave) {
		this.vremeObjave = vremeObjave;
	}
	public Long getTemaId() {
		return temaId;
	}
	public void setTemaId(Long temaId) {
		this.temaId = temaId;
	}
	public Long getAutorId() {
		return autorId;
	}
	public void setAutorId(Long autorId) {
		this.autorId = autorId;
	}
	public List<Long> getFajloviId() {
		return fajloviId;
	}
	public void setFajloviId(List<Long> fajloviId) {
		this.fajloviId = fajloviId;
	}
	
}
