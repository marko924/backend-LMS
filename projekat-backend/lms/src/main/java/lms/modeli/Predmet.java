package lms.modeli;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Predmet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private Integer espb;

    @ManyToOne
    private StudijskiProgram studijskiProgram;

    @OneToMany(mappedBy = "predmet")
    private List<RealizacijaPredmeta> realizacije;
    
    public Predmet() {}

	public Predmet(Long id, String naziv, Integer espb, StudijskiProgram studijskiProgram,
			List<RealizacijaPredmeta> realizacije) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.espb = espb;
		this.studijskiProgram = studijskiProgram;
		this.realizacije = realizacije;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Integer getEspb() {
		return espb;
	}

	public void setEspb(Integer espb) {
		this.espb = espb;
	}

	public StudijskiProgram getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}

	public List<RealizacijaPredmeta> getRealizacije() {
		return realizacije;
	}

	public void setRealizacije(List<RealizacijaPredmeta> realizacije) {
		this.realizacije = realizacije;
	}
    
    
}

