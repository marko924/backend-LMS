package lms.dtos;

import java.time.LocalDateTime;

import lms.modeli.StatusZahteva;

public class ZahtevZaUpisDTO {
	
	private Long id;
	private Long fakultetId;
    private Long studentId;
    private Long studijskiProgramId;
    private Long godinaStudijaId;
    private StatusZahteva status;
    private LocalDateTime vremePodnosenja;
    private String napomena;
    
	public ZahtevZaUpisDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ZahtevZaUpisDTO(Long id, Long fakultetId, Long studentId,Long studijskiProgramId, Long godinaStudijaId, StatusZahteva status,
			LocalDateTime vremePodnosenja, String napomena) {
		super();
		this.id = id;
		this.fakultetId = fakultetId;
		this.studentId = studentId;
		this.studijskiProgramId= studijskiProgramId;
		this.godinaStudijaId = godinaStudijaId;
		this.status = status;
		this.vremePodnosenja = vremePodnosenja;
		this.napomena = napomena;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFakultetId() {
		return fakultetId;
	}

	public void setFakultetId(Long fakultetId) {
		this.fakultetId = fakultetId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	
	public Long getStudijskiProgramId() {
		return  studijskiProgramId;
	}
	
	public void setStudijskiProgramId(Long studijskiProgramId) {
		this.studijskiProgramId= studijskiProgramId;
	}

	public Long getGodinaStudijaId() {
		return godinaStudijaId;
	}

	public void setGodinaStudijaId(Long godinaStudijaId) {
		this.godinaStudijaId = godinaStudijaId;
	}

	public StatusZahteva getStatus() {
		return status;
	}

	public void setStatus(StatusZahteva status) {
		this.status = status;
	}

	public LocalDateTime getVremePodnosenja() {
		return vremePodnosenja;
	}

	public void setVremePodnosenja(LocalDateTime vremePodnosenja) {
		this.vremePodnosenja = vremePodnosenja;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
    
}
