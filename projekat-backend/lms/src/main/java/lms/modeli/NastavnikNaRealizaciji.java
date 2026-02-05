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
public class NastavnikNaRealizaciji extends LogickoBrisanje{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer brojCasova;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nastavnik_id",nullable=false)
    private Nastavnik nastavnik;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="realizacija_predmeta_id",nullable=false)
    private RealizacijaPredmeta realizacija;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tip_nastave_id",nullable=false)
    private TipNastave tipNastave;
    
    public NastavnikNaRealizaciji() {}

	public NastavnikNaRealizaciji(Long id, Integer brojCasova, Nastavnik nastavnik, RealizacijaPredmeta realizacija,
			TipNastave tipNastave) {
		super();
		this.id = id;
		this.brojCasova = brojCasova;
		this.nastavnik = nastavnik;
		this.realizacija = realizacija;
		this.tipNastave = tipNastave;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBrojCasova() {
		return brojCasova;
	}

	public void setBrojCasova(Integer brojCasova) {
		this.brojCasova = brojCasova;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public RealizacijaPredmeta getRealizacija() {
		return realizacija;
	}

	public void setRealizacija(RealizacijaPredmeta realizacija) {
		this.realizacija = realizacija;
	}

	public TipNastave getTipNastave() {
		return tipNastave;
	}

	public void setTipNastave(TipNastave tipNastave) {
		this.tipNastave = tipNastave;
	}
    
    
}
