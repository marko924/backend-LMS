package lms.modeli;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PohadjanjePredmeta extends LogickoBrisanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer konacnaOcena;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_na_godini_id",nullable=false)
    private StudentNaGodini studentNaGodini;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="realizacija_predmeta_id",nullable=false)
    private RealizacijaPredmeta realizacija;
    
    public PohadjanjePredmeta() {}

	public PohadjanjePredmeta(Long id, Integer konacnaOcena, StudentNaGodini studentNaGodini,
			RealizacijaPredmeta realizacija) {
		super();
		this.id = id;
		this.konacnaOcena = konacnaOcena;
		this.studentNaGodini = studentNaGodini;
		this.realizacija = realizacija;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getKonacnaOcena() {
		return konacnaOcena;
	}

	public void setKonacnaOcena(Integer konacnaOcena) {
		this.konacnaOcena = konacnaOcena;
	}

	public StudentNaGodini getStudentNaGodini() {
		return studentNaGodini;
	}

	public void setStudentNaGodini(StudentNaGodini studentNaGodini) {
		this.studentNaGodini = studentNaGodini;
	}

	public RealizacijaPredmeta getRealizacija() {
		return realizacija;
	}

	public void setRealizacija(RealizacijaPredmeta realizacija) {
		this.realizacija = realizacija;
	}
    
    
}
