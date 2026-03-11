package lms.modeli;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ZahtevZaUpis extends LogickoBrisanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fakultet_id", nullable = false)
    private Fakultet fakultet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studijski_program_id", nullable = false) 
    private StudijskiProgram studijskiProgram;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "godina_studija_id", nullable = false)
    private GodinaStudija godinaStudija;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusZahteva status = StatusZahteva.NA_CEKANJU;

    @Column(name = "vreme_podnosenja")
    private LocalDateTime vremePodnosenja = LocalDateTime.now();

    @Column
    private String napomena;

	public ZahtevZaUpis() {
		super();
	}

	public ZahtevZaUpis(Long id, Fakultet fakultet, Student student,StudijskiProgram studijskiProgram, GodinaStudija godinaStudija, StatusZahteva status,
			LocalDateTime vremePodnosenja, String napomena) {
		super();
		this.id = id;
		this.fakultet = fakultet;
		this.student = student;
		this.studijskiProgram= studijskiProgram;
		this.godinaStudija = godinaStudija;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public StudijskiProgram getStudijskiProgram() {
		return studijskiProgram;
	}
	
	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		this.studijskiProgram= studijskiProgram;
	}
	
	public GodinaStudija getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudija godinaStudija) {
		this.godinaStudija = godinaStudija;
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

	public Fakultet getFakultet() {
		return fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}
    
}
