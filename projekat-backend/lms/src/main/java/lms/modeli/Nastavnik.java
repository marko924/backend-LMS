package lms.modeli;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Nastavnik extends RegistrovaniKorisnik{

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column(columnDefinition = "TEXT")
    private String biografija;

    @OneToMany(mappedBy = "nastavnik")
    private List<Zvanje> zvanja;

    @OneToMany(mappedBy = "nastavnik")
    private List<NastavnikNaRealizaciji> angazovanja;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adresa_id", nullable = false)
    private Adresa adresa;
    
    public Nastavnik () {
    	super();
    }

	public Nastavnik(String ime, String prezime, String biografija, List<Zvanje> zvanja,
			List<NastavnikNaRealizaciji> angazovanja, Adresa adresa) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.biografija = biografija;
		this.zvanja = zvanja;
		this.angazovanja = angazovanja;
		this.adresa = adresa;
	}



	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getBiografija() {
		return biografija;
	}

	public void setBiografija(String biografija) {
		this.biografija = biografija;
	}

	public List<Zvanje> getZvanja() {
		return zvanja;
	}

	public void setZvanja(List<Zvanje> zvanja) {
		this.zvanja = zvanja;
	}

	public List<NastavnikNaRealizaciji> getAngazovanja() {
		return angazovanja;
	}

	public void setAngazovanja(List<NastavnikNaRealizaciji> angazovanja) {
		this.angazovanja = angazovanja;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
    
}
