package lms.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class ObavestenjeDTO {
	
	private Long id;
	private String naslov;
	private String sadrzaj;
	private LocalDateTime datumObjave = LocalDateTime.now();
	private List<Long> fajloviId;
	private Long realizacijaPredmetaId;
	private Long nastavnikNaRealizacijiId;
	
	public ObavestenjeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ObavestenjeDTO(Long id, String naslov, String sadrzaj, LocalDateTime datumObjave, List<Long> fajloviId,
			Long realizacijaPredmetaId, Long nastavnikNaRealizacijiId) {
		super();
		this.id = id;
		this.naslov = naslov;
		this.sadrzaj = sadrzaj;
		this.datumObjave = datumObjave;
		this.fajloviId = fajloviId;
		this.realizacijaPredmetaId = realizacijaPredmetaId;
		this.nastavnikNaRealizacijiId = nastavnikNaRealizacijiId;
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
	public LocalDateTime getDatumObjave() {
		return datumObjave;
	}
	public void setDatumObjave(LocalDateTime datumObjave) {
		this.datumObjave = datumObjave;
	}
	public List<Long> getFajloviId() {
		return fajloviId;
	}
	public void setFajloviId(List<Long> fajloviId) {
		this.fajloviId = fajloviId;
	}
	public Long getRealizacijaPredmetaId() {
		return realizacijaPredmetaId;
	}
	public void setRealizacijaPredmetaId(Long realizacijaPredmetaId) {
		this.realizacijaPredmetaId = realizacijaPredmetaId;
	}

	public Long getNastavnikNaRealizacijiId() {
		return nastavnikNaRealizacijiId;
	}

	public void setNastavnikNaRealizacijiId(Long nastavnikNaRealizacijiId) {
		this.nastavnikNaRealizacijiId = nastavnikNaRealizacijiId;
	}
	
	
}
