package lms.modeli;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "korisnik_uloga")
public class KorisnikUloga extends LogickoBrisanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "korisnik_id")
    private RegistrovaniKorisnik korisnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uloga_id")
    private Uloga uloga;

	public KorisnikUloga() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KorisnikUloga(Long id, RegistrovaniKorisnik korisnik, Uloga uloga) {
		super();
		this.id = id;
		this.korisnik = korisnik;
		this.uloga = uloga;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RegistrovaniKorisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(RegistrovaniKorisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Uloga getUloga() {
		return uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

}
