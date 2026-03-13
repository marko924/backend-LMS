package lms.dtos;

public class IshodObrazovniCiljDTO {

	private Long id;
	private Long ishodId;
	private Long obrazovniCiljId;
	
	public IshodObrazovniCiljDTO() {
		super();
	}

	public IshodObrazovniCiljDTO(Long id, Long ishodId, Long obrazovniCiljId) {
		super();
		this.id = id;
		this.ishodId = ishodId;
		this.obrazovniCiljId = obrazovniCiljId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIshodId() {
		return ishodId;
	}

	public void setIshodId(Long ishodId) {
		this.ishodId = ishodId;
	}

	public Long getObrazovniCiljId() {
		return obrazovniCiljId;
	}

	public void setObrazovniCiljId(Long obrazovniCiljId) {
		this.obrazovniCiljId = obrazovniCiljId;
	}
	
	
}
