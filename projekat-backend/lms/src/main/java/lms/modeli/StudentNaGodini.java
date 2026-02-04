package lms.modeli;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class StudentNaGodini {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String brojIndeksa;

    @Column
    private LocalDate datumUpisa;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id",nullable=false)
    private Student student;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="godina_studija_id",nullable=false)
    private GodinaStudija godinaStudija;

    @OneToMany(mappedBy = "studentNaGodini")
    private List<PohadjanjePredmeta> pohadjanja;
    
    public StudentNaGodini() {}

	public StudentNaGodini(Long id, String brojIndeksa, LocalDate datumUpisa, Student student,
			GodinaStudija godinaStudija, List<PohadjanjePredmeta> pohadjanja) {
		super();
		this.id = id;
		this.brojIndeksa = brojIndeksa;
		this.datumUpisa = datumUpisa;
		this.student = student;
		this.godinaStudija = godinaStudija;
		this.pohadjanja = pohadjanja;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public LocalDate getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(LocalDate datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public GodinaStudija getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudija godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public List<PohadjanjePredmeta> getPohadjanja() {
		return pohadjanja;
	}

	public void setPohadjanja(List<PohadjanjePredmeta> pohadjanja) {
		this.pohadjanja = pohadjanja;
	}
    
	
    
}

