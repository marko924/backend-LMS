package lms.modeli;

import java.time.LocalDateTime;
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
public class EvaluacijaZnanja extends LogickoBrisanje {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vreme_pocetka", nullable = false)
    private LocalDateTime vremePocetka;

    @Column(name = "vreme_zavrsetka", nullable = false)
    private LocalDateTime vremeZavrsetka;

    @Column(name = "maksimalni_bodovi")
    private Double maksimalniBodovi = 100.0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tip_evaluacije_id", nullable = false)
    private TipEvaluacije tipEvaluacije;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "realizacija_predmeta_id", nullable = false)
    private RealizacijaPredmeta realizacijaPredmeta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instrument_id", nullable = false)
    private InstrumentEvaluacije instrumentEvaluacije;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ispitni_rok_id", nullable = true)
    private IspitniRok ispitniRok;
    
    @OneToMany(mappedBy = "evaluacijaZnanja")
    private List<Polaganje> polaganja;
    
    @OneToMany(mappedBy = "evaluacija")
    private List<Ishod> ishodi;

	public EvaluacijaZnanja() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EvaluacijaZnanja(Long id, LocalDateTime vremePocetka, LocalDateTime vremeZavrsetka, Double maksimalniBodovi,
			TipEvaluacije tipEvaluacije, RealizacijaPredmeta realizacijaPredmeta,
			InstrumentEvaluacije instrumentEvaluacije, IspitniRok ispitniRok, List<Polaganje> polaganja,
			List<Ishod> ishodi) {
		super();
		this.id = id;
		this.vremePocetka = vremePocetka;
		this.vremeZavrsetka = vremeZavrsetka;
		this.maksimalniBodovi = maksimalniBodovi;
		this.tipEvaluacije = tipEvaluacije;
		this.realizacijaPredmeta = realizacijaPredmeta;
		this.instrumentEvaluacije = instrumentEvaluacije;
		this.ispitniRok = ispitniRok;
		this.polaganja = polaganja;
		this.ishodi = ishodi;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getVremePocetka() {
		return vremePocetka;
	}

	public void setVremePocetka(LocalDateTime vremePocetka) {
		this.vremePocetka = vremePocetka;
	}

	public LocalDateTime getVremeZavrsetka() {
		return vremeZavrsetka;
	}

	public void setVremeZavrsetka(LocalDateTime vremeZavrsetka) {
		this.vremeZavrsetka = vremeZavrsetka;
	}

	public Double getMaksimalniBodovi() {
		return maksimalniBodovi;
	}

	public void setMaksimalniBodovi(Double maksimalniBodovi) {
		this.maksimalniBodovi = maksimalniBodovi;
	}

	public TipEvaluacije getTipEvaluacije() {
		return tipEvaluacije;
	}

	public void setTipEvaluacije(TipEvaluacije tipEvaluacije) {
		this.tipEvaluacije = tipEvaluacije;
	}

	public RealizacijaPredmeta getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmeta realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public InstrumentEvaluacije getInstrumentEvaluacije() {
		return instrumentEvaluacije;
	}

	public void setInstrumentEvaluacije(InstrumentEvaluacije instrumentEvaluacije) {
		this.instrumentEvaluacije = instrumentEvaluacije;
	}

	public IspitniRok getIspitniRok() {
		return ispitniRok;
	}

	public void setIspitniRok(IspitniRok ispitniRok) {
		this.ispitniRok = ispitniRok;
	}

	public List<Polaganje> getPolaganja() {
		return polaganja;
	}

	public void setPolaganja(List<Polaganje> polaganja) {
		this.polaganja = polaganja;
	}

	public List<Ishod> getIshodi() {
		return ishodi;
	}

	public void setIshodi(List<Ishod> ishodi) {
		this.ishodi = ishodi;
	}
    
}
