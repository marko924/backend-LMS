package lms.modeli;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Nastavnik extends RegistrovaniKorisnik {

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
    
    public Nastavnik () {}

	public Nastavnik(String ime, String prezime, String biografija, List<Zvanje> zvanja,
			List<NastavnikNaRealizaciji> angazovanja) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.biografija = biografija;
		this.zvanja = zvanja;
		this.angazovanja = angazovanja;
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
    
    
}
