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
public class TerminNastave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime vremePocetka;

    @Column
    private LocalDateTime vremeZavrsetka;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="realizacija_predmeta_id",nullable=false)
    private RealizacijaPredmeta realizacija;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tip_nastave_id",nullable=false)
    private TipNastave tipNastave;
    
    public TerminNastave() {}

	public TerminNastave(Long id, LocalDateTime vremePocetka, LocalDateTime vremeZavrsetka,
			RealizacijaPredmeta realizacija, TipNastave tipNastave) {
		super();
		this.id = id;
		this.vremePocetka = vremePocetka;
		this.vremeZavrsetka = vremeZavrsetka;
		this.realizacija = realizacija;
		this.tipNastave = tipNastave;
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
