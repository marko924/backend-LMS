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
public class RegistrovaniKorisnik extends LogickoBrisanje{
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

	public RegistrovaniKorisnik() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegistrovaniKorisnik(Long id, String korisnickoIme, String lozinka, String email, Set<Uloga> uloge,
			List<KorisnikNaForumu> clanstvaNaForumima) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.email = email;
		this.uloge = uloge;
		this.clanstvaNaForumima = clanstvaNaForumima;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Uloga> getUloge() {
		return uloge;
	}

	public void setUloge(Set<Uloga> uloge) {
		this.uloge = uloge;
	}

	public List<KorisnikNaForumu> getClanstvaNaForumima() {
		return clanstvaNaForumima;
	}

	public void setClanstvaNaForumima(List<KorisnikNaForumu> clanstvaNaForumima) {
		this.clanstvaNaForumima = clanstvaNaForumima;
	}
    
    
}
