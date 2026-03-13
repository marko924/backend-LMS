package lms.dtos;

public class FajlDTO {
	
	private Long id;
	private String opis;
	private String url;
	private Long nastavniMaterijalId;
	private Long instrumentEvaluacijeId;
	private Long obavestenjeId;
	private Long objavaId;
	private Long porukaId;
	
	public FajlDTO() {
		super();
	}
	
	public FajlDTO(Long id, String opis, String url, Long nastavniMaterijalId, Long instrumentEvaluacijeId,
			Long obavestenjeId, Long objavaId, Long porukaId) {
		super();
		this.id = id;
		this.opis = opis;
		this.url = url;
		this.nastavniMaterijalId = nastavniMaterijalId;
		this.instrumentEvaluacijeId = instrumentEvaluacijeId;
		this.obavestenjeId = obavestenjeId;
		this.objavaId = objavaId;
		this.porukaId = porukaId;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public Long getNastavniMaterijalId() {
		return nastavniMaterijalId;
	}

	public void setNastavniMaterijalId(Long nastavniMaterijalId) {
		this.nastavniMaterijalId = nastavniMaterijalId;
	}

	public Long getInstrumentEvaluacijeId() {
		return instrumentEvaluacijeId;
	}

	public void setInstrumentEvaluacijeId(Long instrumentEvaluacijeId) {
		this.instrumentEvaluacijeId = instrumentEvaluacijeId;
	}

	public Long getObavestenjeId() {
		return obavestenjeId;
	}

	public void setObavestenjeId(Long obavestenjeId) {
		this.obavestenjeId = obavestenjeId;
	}

	public Long getObjavaId() {
		return objavaId;
	}

	public void setObjavaId(Long objavaId) {
		this.objavaId = objavaId;
	}

	public Long getPorukaId() {
		return porukaId;
	}

	public void setPorukaId(Long porukaId) {
		this.porukaId = porukaId;
	}
	
}
