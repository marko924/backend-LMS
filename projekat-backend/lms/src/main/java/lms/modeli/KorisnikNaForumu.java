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
}
