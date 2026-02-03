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
public class StudijskiProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @ManyToOne
    private Fakultet fakultet;

    @ManyToOne
    private Nastavnik rukovodilac;

    @OneToMany(mappedBy = "studijskiProgram")
    private List<Predmet> predmeti;
    
    public StudijskiProgram() {}
    
	public StudijskiProgram(Long id, String naziv, Fakultet fakultet, Nastavnik rukovodilac, List<Predmet> predmeti) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.fakultet = fakultet;
		this.rukovodilac = rukovodilac;
		this.predmeti = predmeti;
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

	public Fakultet getFakultet() {
		return fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}

	public Nastavnik getRukovodilac() {
		return rukovodilac;
	}

	public void setRukovodilac(Nastavnik rukovodilac) {
		this.rukovodilac = rukovodilac;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
    
    
}
