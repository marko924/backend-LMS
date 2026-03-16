package lms.modeli;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Ishod extends LogickoBrisanje {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String opis;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "predmet_id", nullable = false)
    private Predmet predmet;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluacija_id", nullable = false)
    private EvaluacijaZnanja evaluacija;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "termin_nastave_id", nullable = false)
    private TerminNastave terminNastave;
    
    @OneToMany(mappedBy = "ishod")
    private List<NastavniMaterijal> nastavniMaterijali;
    
    @OneToMany(mappedBy = "ishod")
    private Set<IshodObrazovniCilj> ciljeviVeze = new HashSet<>();

	public Ishod() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ishod(Long id, String opis, Predmet predmet, EvaluacijaZnanja evaluacija, TerminNastave terminNastave,
			List<NastavniMaterijal> nastavniMaterijali, Set<IshodObrazovniCilj> ciljeviVeze) {
		super();
		this.id = id;
		this.opis = opis;
		this.predmet = predmet;
		this.evaluacija = evaluacija;
		this.terminNastave = terminNastave;
		this.nastavniMaterijali = nastavniMaterijali;
		this.ciljeviVeze = ciljeviVeze;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Set<IshodObrazovniCilj> getCiljeviVeze() {
		return ciljeviVeze;
	}

	public void setCiljeviVeze(Set<IshodObrazovniCilj> ciljeviVeze) {
		this.ciljeviVeze = ciljeviVeze;
	}

	public EvaluacijaZnanja getEvaluacija() {
		return evaluacija;
	}

	public void setEvaluacija(EvaluacijaZnanja evaluacija) {
		this.evaluacija = evaluacija;
	}

	public TerminNastave getTerminNastave() {
		return terminNastave;
	}

	public void setTerminNastave(TerminNastave terminNastave) {
		this.terminNastave = terminNastave;
	}

	public List<NastavniMaterijal> getNastavniMaterijali() {
		return nastavniMaterijali;
	}

	public void setNastavniMaterijali(List<NastavniMaterijal> nastavniMaterijali) {
		this.nastavniMaterijali = nastavniMaterijali;
	}
    
}
