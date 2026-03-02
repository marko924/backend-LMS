package lms.modeli;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class StudijskiProgram extends LogickoBrisanje{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;
    
    @Column
    private String opis;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fakultet_id",nullable=false)
    private Fakultet fakultet;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nastavnik_id",nullable=false)
    private Nastavnik rukovodilac;

    @ManyToMany(mappedBy = "studijskiProgrami")
    private Set<Predmet> predmeti = new HashSet<>();
    
    public StudijskiProgram() {}

	public StudijskiProgram(Long id, String naziv, String opis, Fakultet fakultet, Nastavnik rukovodilac,
			Set<Predmet> predmeti) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
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
	
	public String getOpis() {
		return opis;
	}
	
	public void setOpis(String opis) {
		this.opis= opis;
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

	public Set<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(Set<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
    
}
