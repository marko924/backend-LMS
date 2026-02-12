package lms.dtos;

import java.util.List;

public class RealizacijaPredmetaDTO {

    private Long id;
    private Long predmetId;
    private Long nastavniMaterijalId;
    private List<Long> terminiId;
    private List<Long> nastavniciId;
    private List<Long> pohadjanjaId;

    public RealizacijaPredmetaDTO() {}

    public RealizacijaPredmetaDTO(Long id, Long predmetId, Long nastavniMaterijalId,
                                  List<Long> terminiId, List<Long> nastavniciId, List<Long> pohadjanjaId) {
        this.id = id;
        this.predmetId = predmetId;
        this.nastavniMaterijalId = nastavniMaterijalId;
        this.terminiId = terminiId;
        this.nastavniciId = nastavniciId;
        this.pohadjanjaId = pohadjanjaId;
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

    public Long getNastavniMaterijalId() {
        return nastavniMaterijalId;
    }

    public void setNastavniMaterijalId(Long nastavniMaterijalId) {
        this.nastavniMaterijalId = nastavniMaterijalId;
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
}
