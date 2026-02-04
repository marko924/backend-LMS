package lms.modeli;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class RegistrovaniKorisnik {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String korisnickoIme;

    @Column(nullable = false)
    private String lozinka;

    @Column(unique = true, nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)  //Ovde je fatchType Eagre zbog toga sto u procesu registracije mi treba odmah sve uloge
    @JoinTable( //A ovo smo uradili zato sto ovaj entitet to jest tabela nema ni jedan drugi atribut sem referenci na korisnika i ulogu pa mozemo da napravimo ovo ali ako ima jos neki atribut ona bih morao da napravim odvojeni entitet
        name = "Korisnik_Uloga",
        joinColumns = @JoinColumn(name = "korisnik_id"),
        inverseJoinColumns = @JoinColumn(name = "uloga_id")
    )
    private Set<Uloga> uloge = new HashSet<>();  //Koristio sam Set da mi se ne bi prikazivali duplikati kao kada koristim List
    
    // Lista svih učešća ovog korisnika na različitim forumima
    @OneToMany(mappedBy = "korisnik", cascade = CascadeType.ALL)
    private List<KorisnikNaForumu> clanstvaNaForumima = new ArrayList<>();
}
