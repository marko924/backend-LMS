package lms.modeli;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Uloga extends LogickoBrisanje{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naziv;     //'ROLE_STUDENT', 'ROLE_NASTAVNIK', 'ROLE_ADMIN', 'ROLE_SLUZBA'
    
    @OneToMany(mappedBy = "uloga", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<KorisnikUloga> korisnici = new HashSet<>();

	public Uloga() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Uloga(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<KorisnikUloga> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(Set<KorisnikUloga> korisnici) {
		this.korisnici = korisnici;
	}
    
}
