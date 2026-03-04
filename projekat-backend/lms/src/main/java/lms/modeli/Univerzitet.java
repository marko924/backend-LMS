package lms.modeli;

import java.time.LocalDate;
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
public class Univerzitet extends LogickoBrisanje{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private LocalDate datumOsnivanja;
    
    @Column
    private String opis;
    
    @Column
    private String kontakt;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nastavnik_id",nullable=false)
    private Nastavnik rektor;

    @OneToMany(mappedBy = "univerzitet")
    private List<Fakultet> fakulteti;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adresa_id", nullable = false)
    private Adresa adresa;
    
    public Univerzitet() {
    	super();
    }

	public Univerzitet(Long id, String naziv, LocalDate datumOsnivanja, String opis, String kontakt, Nastavnik rektor,
			List<Fakultet> fakulteti, Adresa adresa) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
		this.opis = opis;
		this.kontakt = kontakt;
		this.rektor = rektor;
		this.fakulteti = fakulteti;
		this.adresa = adresa;
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

	public LocalDate getDatumOsnivanja() {
		return datumOsnivanja;
	}
	
	public String getOpis() {
		return opis;
	}
	
	public void setOpis(String opis) {
		this.opis= opis;
	}

	public void setDatumOsnivanja(LocalDate datumOsnivanja) {
		this.datumOsnivanja = datumOsnivanja;
	}

	public Nastavnik getRektor() {
		return rektor;
	}

	public void setRektor(Nastavnik rektor) {
		this.rektor = rektor;
	}

	public List<Fakultet> getFakulteti() {
		return fakulteti;
	}

	public void setFakulteti(List<Fakultet> fakulteti) {
		this.fakulteti = fakulteti;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}
    
}

