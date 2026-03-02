package lms.modeli;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Predmet extends LogickoBrisanje{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;
    
    @Column
    private String opis;

    @Column
    private Integer espb;

    @ManyToMany
    @JoinTable(
        name = "predmet_studijski_program", // Naziv spojne tabele u bazi
        joinColumns = @JoinColumn(name = "predmet_id"),
        inverseJoinColumns = @JoinColumn(name = "studijski_program_id")
    )
    private Set<StudijskiProgram> studijskiProgrami = new HashSet<>();

    @OneToMany(mappedBy = "predmet")
    private List<RealizacijaPredmeta> realizacije;
    
    public Predmet() {}

	public Predmet(Long id, String naziv, String opis, Integer espb, Set<StudijskiProgram> studijskiProgrami,
			List<RealizacijaPredmeta> realizacije) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.espb = espb;
		this.studijskiProgrami = studijskiProgrami;
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
	
	public String getOpis() {
		return opis;
	}
	
	public void setOpis(String opis) {
		this.opis= opis;
	}


	public Integer getEspb() {
		return espb;
	}

	public void setEspb(Integer espb) {
		this.espb = espb;
	}

	public Set<StudijskiProgram> getStudijskiProgrami() {
		return studijskiProgrami;
	}

	public void setStudijskiProgrami(Set<StudijskiProgram> studijskiProgrami) {
		this.studijskiProgrami = studijskiProgrami;
	}

	public List<RealizacijaPredmeta> getRealizacije() {
		return realizacije;
	}

	public void setRealizacije(List<RealizacijaPredmeta> realizacije) {
		this.realizacije = realizacije;
	}
    
    
}

