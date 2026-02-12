package lms.dtos;

import java.util.List;

public class ForumDTO {
	
	private Long id;
	private boolean javni;
	private List<Long> temeId;
	
	public ForumDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ForumDTO(Long id, boolean javni, List<Long> temeId) {
		super();
		this.id = id;
		this.javni = javni;
		this.temeId = temeId;
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
	
}
