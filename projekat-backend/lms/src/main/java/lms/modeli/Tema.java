package lms.modeli;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Tema {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naslov;

    @Column(name = "vreme_kreiranja")
    private LocalDateTime vremeKreiranja = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "forum_id", nullable = false)
    private Forum forum;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private KorisnikNaForumu autor; // Primećujete da je autor zapravo KorisnikNaForumu

    @OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
    private List<Objava> objave = new ArrayList<>();
}
