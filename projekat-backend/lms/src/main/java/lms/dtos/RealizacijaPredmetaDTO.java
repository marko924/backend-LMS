package lms.dtos;

import java.util.List;
import java.util.Set;

public class RealizacijaPredmetaDTO {

    private Long id;
    private Long predmetId;
    private Set<Long> nastavniMaterijaliId;
    private List<Long> terminiId;
    private List<Long> nastavniciId;
    private List<Long> pohadjanjaId;
    private List<Long> evaluacijeId;
    private List<Long> obavestenjaId;

    public RealizacijaPredmetaDTO() {}

    public RealizacijaPredmetaDTO(Long id, Long predmetId, Set<Long> nastavniMaterijaliId, List<Long> terminiId,
			List<Long> nastavniciId, List<Long> pohadjanjaId, List<Long> evaluacijeId, List<Long> obavestenjaId) {
		super();
		this.id = id;
		this.predmetId = predmetId;
		this.nastavniMaterijaliId = nastavniMaterijaliId;
		this.terminiId = terminiId;
		this.nastavniciId = nastavniciId;
		this.pohadjanjaId = pohadjanjaId;
		this.evaluacijeId = evaluacijeId;
		this.obavestenjaId = obavestenjaId;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPredmetId() {
        return predmetId;
    }

    public void setPredmetId(Long predmetId) {
        this.predmetId = predmetId;
    }

    public Set<Long> getNastavniMaterijaliId() {
		return nastavniMaterijaliId;
	}

	public void setNastavniMaterijaliId(Set<Long> nastavniMaterijaliId) {
		this.nastavniMaterijaliId = nastavniMaterijaliId;
	}

	public List<Long> getTerminiId() {
        return terminiId;
    }

    public void setTerminiId(List<Long> terminiId) {
        this.terminiId = terminiId;
    }

    public List<Long> getNastavniciId() {
        return nastavniciId;
    }

    public void setNastavniciId(List<Long> nastavniciId) {
        this.nastavniciId = nastavniciId;
    }

    public List<Long> getPohadjanjaId() {
        return pohadjanjaId;
    }

    public void setPohadjanjaId(List<Long> pohadjanjaId) {
        this.pohadjanjaId = pohadjanjaId;
    }

	public List<Long> getEvaluacijeId() {
		return evaluacijeId;
	}

	public void setEvaluacijeId(List<Long> evaluacijeId) {
		this.evaluacijeId = evaluacijeId;
	}

	public List<Long> getObavestenjaId() {
		return obavestenjaId;
	}

	public void setObavestenjaId(List<Long> obavestenjaId) {
		this.obavestenjaId = obavestenjaId;
	}
    
}
