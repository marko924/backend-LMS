package lms.modeli;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Zvanje extends LogickoBrisanje{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate datumIzbora;
    
    @Column
    private LocalDate datumOtkaza;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nastavnik_id",nullable=false)
    private Nastavnik nastavnik;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tip_zvanja_id",nullable=false)
    private TipZvanja tipZvanja;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="naucna_oblast_id",nullable=false)
    private NaucnaOblast naucnaOblast;
    
    public Zvanje() {
    	super();
    }

	public Zvanje(Long id, LocalDate datumIzbora, LocalDate datumOtkaza, Nastavnik nastavnik, TipZvanja tipZvanja,
			NaucnaOblast naucnaOblast) {
		super();
		this.id = id;
		this.datumIzbora = datumIzbora;
		this.datumOtkaza = datumOtkaza;
		this.nastavnik = nastavnik;
		this.tipZvanja = tipZvanja;
		this.naucnaOblast = naucnaOblast;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDatumIzbora() {
		return datumIzbora;
	}

	public void setDatumIzbora(LocalDate datumIzbora) {
		this.datumIzbora = datumIzbora;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public TipZvanja getTipZvanja() {
		return tipZvanja;
	}

	public void setTipZvanja(TipZvanja tipZvanja) {
		this.tipZvanja = tipZvanja;
	}

	public NaucnaOblast getNaucnaOblast() {
		return naucnaOblast;
	}

	public void setNaucnaOblast(NaucnaOblast naucnaOblast) {
		this.naucnaOblast = naucnaOblast;
	}

	public LocalDate getDatumOtkaza() {
		return datumOtkaza;
	}

	public void setDatumOtkaza(LocalDate datumOtkaza) {
		this.datumOtkaza = datumOtkaza;
	}
    
    
}

