package lms.modeli;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Objava {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String sadrzaj;

    @Column(name = "vreme_objave")
    private LocalDateTime vremeObjave = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tema_id", nullable = false)
    private Tema tema;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id", nullable = false)
    private KorisnikNaForumu autor;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "objava_id") // Unidirekciona veza ka fajlovima
    private List<Fajl> fajlovi = new ArrayList<>();
}
