package lms.modeli;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Zvanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate datumIzbora;

    @ManyToOne
    private Nastavnik nastavnik;

    @ManyToOne
    private TipZvanja tipZvanja;

    @ManyToOne
    private NaucnaOblast naucnaOblast;
    
    public Zvanje() {}

	public Zvanje(Long id, LocalDate datumIzbora, Nastavnik nastavnik, TipZvanja tipZvanja, NaucnaOblast naucnaOblast) {
		super();
		this.id = id;
		this.datumIzbora = datumIzbora;
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
    
    
}

