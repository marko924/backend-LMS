package lms.dtos;

import java.time.LocalDate;
import java.util.List;

public class GodinaStudijaDTO {

    private Long id;
    private Integer godina;
    private LocalDate pocetak;
    private LocalDate kraj;
    private List<Long> predmetiId;
    private Long studijskiProgramId;

    public GodinaStudijaDTO() {}

    public GodinaStudijaDTO(Long id, Integer godina, LocalDate pocetak, LocalDate kraj, List<Long> predmetiId,
    		Long studijskiProgramId) {
		super();
		this.id = id;
		this.godina = godina;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.predmetiId = predmetiId;
		this.studijskiProgramId = studijskiProgramId;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGodina() {
        return godina;
    }

    public void setGodina(Integer godina) {
        this.godina = godina;
    }

	public LocalDate getPocetak() {
		return pocetak;
	}

	public void setPocetak(LocalDate pocetak) {
		this.pocetak = pocetak;
	}

	public LocalDate getKraj() {
		return kraj;
	}

	public void setKraj(LocalDate kraj) {
		this.kraj = kraj;
	}

	public List<Long> getPredmetiId() {
		return predmetiId;
	}

	public void setPredmetiId(List<Long> predmetiId) {
		this.predmetiId = predmetiId;
	}

	public Long getStudijskiProgramId() {
		return studijskiProgramId;
	}

	public void setStudijskiProgramId(Long studijskiProgramId) {
		this.studijskiProgramId = studijskiProgramId;
	}
    
}

