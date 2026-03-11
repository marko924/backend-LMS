package lms.dtos;

import java.util.List;

public class ForumDTO {
	
	private Long id;
	private boolean javni;
	private List<Long> temeId;
	private List<Long> clanoviId;
	
	public ForumDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ForumDTO(Long id, boolean javni, List<Long> temeId, List<Long> clanoviId) {
		super();
		this.id = id;
		this.javni = javni;
		this.temeId = temeId;
		this.clanoviId = clanoviId;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isJavni() {
		return javni;
	}
	public void setJavni(boolean javni) {
		this.javni = javni;
	}
	public List<Long> getTemeId() {
		return temeId;
	}
	public void setTemeId(List<Long> temeId) {
		this.temeId = temeId;
	}

	public List<Long> getClanoviId() {
		return clanoviId;
	}

	public void setClanoviId(List<Long> clanoviId) {
		this.clanoviId = clanoviId;
	}
	
}
