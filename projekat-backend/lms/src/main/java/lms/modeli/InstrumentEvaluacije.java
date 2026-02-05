package lms.modeli;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
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
public class InstrumentEvaluacije extends LogickoBrisanje{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naziv;

    @Column
    private String opis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluacija_id", nullable = false)
    private EvaluacijaZnanja evaluacijaZnanja;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "instrument_evaluacije_id") // Unidirekciona veza ka fajlovima
    private List<Fajl> fajlovi = new ArrayList<>();

	public InstrumentEvaluacije() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InstrumentEvaluacije(Long id, String naziv, String opis, EvaluacijaZnanja evaluacijaZnanja,
			List<Fajl> fajlovi) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.evaluacijaZnanja = evaluacijaZnanja;
		this.fajlovi = fajlovi;
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
		this.opis = opis;
	}

	public EvaluacijaZnanja getEvaluacijaZnanja() {
		return evaluacijaZnanja;
	}

	public void setEvaluacijaZnanja(EvaluacijaZnanja evaluacijaZnanja) {
		this.evaluacijaZnanja = evaluacijaZnanja;
	}

	public List<Fajl> getFajlovi() {
		return fajlovi;
	}

	public void setFajlovi(List<Fajl> fajlovi) {
		this.fajlovi = fajlovi;
	}
    
    
}
