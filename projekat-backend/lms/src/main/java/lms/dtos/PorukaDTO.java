package lms.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class PorukaDTO {
	
	private Long id;
	private String naslov;
	private String sadrzaj;
	private LocalDateTime vremeSlanja = LocalDateTime.now();
	private Long posiljalacId;
	private Long primalacId;
	private List<Long> fajloviId;
	
	public PorukaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PorukaDTO(Long id, String naslov, String sadrzaj, LocalDateTime vremeSlanja, Long posiljalacId,
			Long primalacId, List<Long> fajloviId) {
		super();
		this.id = id;
		this.naslov = naslov;
		this.sadrzaj = sadrzaj;
		this.vremeSlanja = vremeSlanja;
		this.posiljalacId = posiljalacId;
		this.primalacId = primalacId;
		this.fajloviId = fajloviId;
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
	public String getSadrzaj() {
		return sadrzaj;
	}
	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}
	public LocalDateTime getVremeSlanja() {
		return vremeSlanja;
	}
	public void setVremeSlanja(LocalDateTime vremeSlanja) {
		this.vremeSlanja = vremeSlanja;
	}
	public Long getPosiljalacId() {
		return posiljalacId;
	}
	public void setPosiljalacId(Long posiljalacId) {
		this.posiljalacId = posiljalacId;
	}
	public Long getPrimalacId() {
		return primalacId;
	}
	public void setPrimalacId(Long primalacId) {
		this.primalacId = primalacId;
	}
	public List<Long> getFajloviId() {
		return fajloviId;
	}
	public void setFajloviId(List<Long> fajloviId) {
		this.fajloviId = fajloviId;
	}
	
}
