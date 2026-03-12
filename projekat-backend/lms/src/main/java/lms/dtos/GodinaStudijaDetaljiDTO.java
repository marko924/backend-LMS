package lms.dtos;

import java.util.List;

public class GodinaStudijaDetaljiDTO {
	
	private Long id;
    private Integer godina;
    private List<PredmetDetaljiDTO> predmeti;
    
	public GodinaStudijaDetaljiDTO() {}

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

	public List<PredmetDetaljiDTO> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<PredmetDetaljiDTO> predmeti) {
		this.predmeti = predmeti;
	}
    
}
