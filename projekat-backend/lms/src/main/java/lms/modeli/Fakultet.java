package lms.modeli;

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
public class Fakultet {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="univerzitet_id",nullable=false)
    private Univerzitet univerzitet;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nastavnik_id",nullable=false)
    private Nastavnik dekan;

    @OneToMany(mappedBy = "fakultet")
    private List<StudijskiProgram> programi;
    
    public Fakultet() {}
    
    public Fakultet(Long id, String naziv, Univerzitet univerzitet, Nastavnik dekan, List<StudijskiProgram> programi) {
  		super();
  		this.id = id;
  		this.naziv = naziv;
  		this.univerzitet = univerzitet;
  		this.dekan = dekan;
  		this.programi = programi;
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

	public Univerzitet getUniverzitet() {
		return univerzitet;
	}

	public void setUniverzitet(Univerzitet univerzitet) {
		this.univerzitet = univerzitet;
	}

	public Nastavnik getDekan() {
		return dekan;
	}

	public void setDekan(Nastavnik dekan) {
		this.dekan = dekan;
	}

	public List<StudijskiProgram> getProgrami() {
		return programi;
	}

	public void setProgrami(List<StudijskiProgram> programi) {
		this.programi = programi;
	}
    
    
}

