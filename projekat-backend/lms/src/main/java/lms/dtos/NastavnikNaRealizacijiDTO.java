package lms.dtos;

import java.util.List;

public class NastavnikNaRealizacijiDTO {

    private Long id;
    private Integer brojCasova;
    private Long nastavnikId;       
    private Long realizacijaId;    
    private Long tipNastaveId;     
    private List<Long> obavestenjaId;

    public NastavnikNaRealizacijiDTO() {}

    public NastavnikNaRealizacijiDTO(Long id, Integer brojCasova, Long nastavnikId, Long realizacijaId,
			Long tipNastaveId, List<Long> obavestenjaId) {
		super();
		this.id = id;
		this.brojCasova = brojCasova;
		this.nastavnikId = nastavnikId;
		this.realizacijaId = realizacijaId;
		this.tipNastaveId = tipNastaveId;
		this.obavestenjaId = obavestenjaId;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBrojCasova() {
        return brojCasova;
    }

    public void setBrojCasova(Integer brojCasova) {
        this.brojCasova = brojCasova;
    }

    public Long getNastavnikId() {
        return nastavnikId;
    }

    public void setNastavnikId(Long nastavnikId) {
        this.nastavnikId = nastavnikId;
    }

    public Long getRealizacijaId() {
        return realizacijaId;
    }

    public void setRealizacijaId(Long realizacijaId) {
        this.realizacijaId = realizacijaId;
    }

    public Long getTipNastaveId() {
        return tipNastaveId;
    }

    public void setTipNastaveId(Long tipNastaveId) {
        this.tipNastaveId = tipNastaveId;
    }

	public List<Long> getObavestenjaId() {
		return obavestenjaId;
	}

	public void setObavestenjaId(List<Long> obavestenjaId) {
		this.obavestenjaId = obavestenjaId;
	}
    
}
