package lms.modeli;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Obavestenje {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naslov;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String sadrzaj;

    @Column(name = "datum_objave")
    private LocalDateTime datumObjave = LocalDateTime.now();
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "obavestenje_id") // Unidirekciona veza ka fajlovima
    private List<Fajl> fajlovi = new ArrayList<>();

    //Ovo uraditi za svaki entitte koji je povezan sa ovim

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "realizacija_id", nullable = false)
    //private RealizacijaPredmeta realizacijaPredmeta;
}
