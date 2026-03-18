package lms.modeli;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;

@Entity  //oznacav tabelu u bazi
@Inheritance(strategy = InheritanceType.JOINED) //ovo znaci da ce svaka tabela koja nasledi ovu klasu imati sva njena polja i da ce deliti id
public class RegistrovaniKorisnik extends LogickoBrisanje{
	@Id //oznaka primarnog kljuca
    @GeneratedValue(strategy = GenerationType.IDENTITY) //sa ovim govorim da se on sam treba generisati
    private Long id;

    @Column(unique = true, nullable = false)
    private String korisnickoIme;

    @Column(nullable = false)
    private String lozinka;

    @Column(unique = true, nullable = false)
    private String email;

    //Sa ovim smo rekli da je druga strana vlasnik veze
    //A sa CascadeType.ALL sam rekao da ako obrisem ili sacuvam korisnika, automatski se te operacije prenose i na njegove uloge
    //A sa orphanRemoval ako se ukloni uloga iz liste automatski se brise i iz baze (ne dozvoljava da ostane siroce)
    @OneToMany(mappedBy = "korisnik", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<KorisnikUloga> uloge = new HashSet<>();  //Koristio sam Set da mi se ne bi prikazivali duplikati kao kada koristim List
    
    @OneToMany(mappedBy = "korisnik")
    private List<KorisnikNaForumu> clanstvaNaForumima;

	public RegistrovaniKorisnik() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegistrovaniKorisnik(Long id, String korisnickoIme, String lozinka, String email, Set<KorisnikUloga> uloge,
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

	public Set<KorisnikUloga> getUloge() {
		return uloge;
	}

	public void setUloge(Set<KorisnikUloga> uloge) {
		this.uloge = uloge;
	}

	public List<KorisnikNaForumu> getClanstvaNaForumima() {
		return clanstvaNaForumima;
	}

	public void setClanstvaNaForumima(List<KorisnikNaForumu> clanstvaNaForumima) {
		this.clanstvaNaForumima = clanstvaNaForumima;
	}
    
    
}
