package lms.modeli;

import jakarta.persistence.*;

@Entity
public class KorisnikNaForumu {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "korisnik_id")
    private RegistrovaniKorisnik korisnik;

    @ManyToOne
    @JoinColumn(name = "forum_id")
    private Forum forum;

    @ManyToOne
    @JoinColumn(name = "uloga_id")
    private Uloga uloga; // Posetilac, Moderator, Administrator

	public KorisnikNaForumu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KorisnikNaForumu(Long id, RegistrovaniKorisnik korisnik, Forum forum, Uloga uloga) {
		super();
		this.id = id;
		this.korisnik = korisnik;
		this.forum = forum;
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

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public Uloga getUloga() {
		return uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}
    
    
}
