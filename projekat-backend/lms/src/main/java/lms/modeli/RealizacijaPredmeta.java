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
public class RealizacijaPredmeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="predmet_id",nullable=false)
    private Predmet predmet;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nastavni_materijal_id",nullable=false)
    private NastavniMaterijal nastavniMaterijal;

    @OneToMany(mappedBy = "realizacija")
    private List<TerminNastave> termini;

    @OneToMany(mappedBy = "realizacija")
    private List<NastavnikNaRealizaciji> nastavnici;

    @OneToMany(mappedBy = "realizacija")
    private List<PohadjanjePredmeta> pohadjanja;
    
    public RealizacijaPredmeta() {}

	public RealizacijaPredmeta(Long id, Predmet predmet, NastavniMaterijal nastavniMaterijal,
			List<TerminNastave> termini, List<NastavnikNaRealizaciji> nastavnici, List<PohadjanjePredmeta> pohadjanja) {
		super();
		this.id = id;
		this.predmet = predmet;
		this.nastavniMaterijal = nastavniMaterijal;
		this.termini = termini;
		this.nastavnici = nastavnici;
		this.pohadjanja = pohadjanja;
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

	public NastavniMaterijal getNastavniMaterijal() {
		return nastavniMaterijal;
	}

	public void setNastavniMaterijal(NastavniMaterijal nastavniMaterijal) {
		this.nastavniMaterijal = nastavniMaterijal;
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
    
    
}

