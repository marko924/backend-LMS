package lms.modeli;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Ishod {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String opis;

    //Ovo uraditi za svaki entitet koji je povezan sa ovim
    
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "predmet_id", nullable = false)
    //private Predmet predmet;

    // Many-to-Many relacija mapirana ovde
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "Ishod_ObrazovniCilj",
        joinColumns = @JoinColumn(name = "ishod_id"),
        inverseJoinColumns = @JoinColumn(name = "obrazovni_cilj_id")
    )
    private Set<ObrazovniCilj> obrazovniCiljevi = new HashSet<>();
}
