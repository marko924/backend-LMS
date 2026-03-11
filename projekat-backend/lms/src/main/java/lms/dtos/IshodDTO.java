package lms.dtos;

import java.util.List;
import java.util.Set;

public class IshodDTO {
	
	private Long id;
	private String opis;
	private Long predmetId;
	private Long evaluacijaId;
	private Long terminNastaveId;
	private List<Long> nastavniMaterijaliId;
	private Set<Long> obrazovniCiljeviId;
	
	public IshodDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public IshodDTO(Long id, String opis, Long predmetId, Long evaluacijaId, Long terminNastaveId,
			List<Long> nastavniMaterijaliId, Set<Long> obrazovniCiljeviId) {
		super();
		this.id = id;
		this.opis = opis;
		this.predmetId = predmetId;
		this.evaluacijaId = evaluacijaId;
		this.terminNastaveId = terminNastaveId;
		this.nastavniMaterijaliId = nastavniMaterijaliId;
		this.obrazovniCiljeviId = obrazovniCiljeviId;
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
	public Long getPredmetId() {
		return predmetId;
	}
	public void setPredmetId(Long predmetId) {
		this.predmetId = predmetId;
	}
	public Set<Long> getObrazovniCiljeviId() {
		return obrazovniCiljeviId;
	}
	public void setObrazovniCiljeviId(Set<Long> obrazovniCiljeviId) {
		this.obrazovniCiljeviId = obrazovniCiljeviId;
	}

	public Long getEvaluacijaId() {
		return evaluacijaId;
	}

	public void setEvaluacijaId(Long evaluacijaId) {
		this.evaluacijaId = evaluacijaId;
	}

	public Long getTerminNastaveId() {
		return terminNastaveId;
	}

	public void setTerminNastaveId(Long terminNastaveId) {
		this.terminNastaveId = terminNastaveId;
	}

	public List<Long> getNastavniMaterijaliId() {
		return nastavniMaterijaliId;
	}

	public void setNastavniMaterijaliId(List<Long> nastavniMaterijaliId) {
		this.nastavniMaterijaliId = nastavniMaterijaliId;
	}
	
	
}
