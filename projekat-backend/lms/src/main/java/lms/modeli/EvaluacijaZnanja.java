package lms.modeli;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EvaluacijaZnanja {
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
    @JoinColumn(name = "realizacija_id", nullable = false)
    private RealizacijaPredmeta realizacijaPredmeta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instrument_id", nullable = false)
    private InstrumentEvaluacije instrumentEvaluacije;

	public EvaluacijaZnanja() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EvaluacijaZnanja(Long id, LocalDateTime vremePocetka, LocalDateTime vremeZavrsetka, Double maksimalniBodovi,
			TipEvaluacije tipEvaluacije, RealizacijaPredmeta realizacijaPredmeta,
			InstrumentEvaluacije instrumentEvaluacije) {
		super();
		this.id = id;
		this.vremePocetka = vremePocetka;
		this.vremeZavrsetka = vremeZavrsetka;
		this.maksimalniBodovi = maksimalniBodovi;
		this.tipEvaluacije = tipEvaluacije;
		this.realizacijaPredmeta = realizacijaPredmeta;
		this.instrumentEvaluacije = instrumentEvaluacije;
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
    
    
}
