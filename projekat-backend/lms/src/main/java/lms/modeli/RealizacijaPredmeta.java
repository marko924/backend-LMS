package lms.modeli;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class RealizacijaPredmeta extends LogickoBrisanje{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="predmet_id",nullable=false)
    private Predmet predmet;

    @OneToMany(mappedBy = "realizacija")
    private List<TerminNastave> termini;

    @OneToMany(mappedBy = "realizacijaPredmeta")
    private List<NastavnikNaRealizaciji> nastavnici;

    @OneToMany(mappedBy = "realizacijaPredmeta")
    private List<PohadjanjePredmeta> pohadjanja;
    
    @OneToMany(mappedBy = "realizacijaPredmeta")
    private List<EvaluacijaZnanja> evaluacije;
    
    @OneToMany(mappedBy = "realizacijaPredmeta")
    private List<Obavestenje> obavestenja;
    
    public RealizacijaPredmeta() {}

	public RealizacijaPredmeta(Long id, Predmet predmet,List<TerminNastave> termini, List<NastavnikNaRealizaciji> nastavnici, 
			List<PohadjanjePredmeta> pohadjanja, List<EvaluacijaZnanja> evaluacije, List<Obavestenje> obavestenja) {
		super();
		this.id = id;
		this.predmet = predmet;
		this.termini = termini;
		this.nastavnici = nastavnici;
		this.pohadjanja = pohadjanja;
		this.evaluacije = evaluacije;
		this.obavestenja = obavestenja;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public List<TerminNastave> getTermini() {
		return termini;
	}

	public void setTermini(List<TerminNastave> termini) {
		this.termini = termini;
	}

	public List<NastavnikNaRealizaciji> getNastavnici() {
		return nastavnici;
	}

	public void setNastavnici(List<NastavnikNaRealizaciji> nastavnici) {
		this.nastavnici = nastavnici;
	}

	public List<PohadjanjePredmeta> getPohadjanja() {
		return pohadjanja;
	}

	public void setPohadjanja(List<PohadjanjePredmeta> pohadjanja) {
		this.pohadjanja = pohadjanja;
	}

	public List<EvaluacijaZnanja> getEvaluacije() {
		return evaluacije;
	}

	public void setEvaluacije(List<EvaluacijaZnanja> evaluacije) {
		this.evaluacije = evaluacije;
	}

	public List<Obavestenje> getObavestenja() {
		return obavestenja;
	}

	public void setObavestenja(List<Obavestenje> obavestenja) {
		this.obavestenja = obavestenja;
	}
    
    
}

