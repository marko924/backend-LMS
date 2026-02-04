package lms.modeli;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Poruka {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column
    private String naslov;

    @Column(nullable = false)
    private String sadrzaj;

    @Column(name = "vreme_slanja")
    private LocalDateTime vremeSlanja = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posiljalac_id", nullable = false)
    private RegistrovaniKorisnik posiljalac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "primalac_id", nullable = false)
    private RegistrovaniKorisnik primalac;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "poruka_id") // Unidirekciona veza ka fajlovima
    private List<Fajl> fajlovi = new ArrayList<>();
}
