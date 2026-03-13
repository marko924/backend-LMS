package lms.modeli;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Poruka extends LogickoBrisanje {
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
    
    @OneToMany(mappedBy="poruka")
    private List<Fajl> fajlovi;

	public Poruka() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Poruka(Long id, String naslov, String sadrzaj, LocalDateTime vremeSlanja, RegistrovaniKorisnik posiljalac,
			RegistrovaniKorisnik primalac, List<Fajl> fajlovi) {
		super();
		this.id = id;
		this.naslov = naslov;
		this.sadrzaj = sadrzaj;
		this.vremeSlanja = vremeSlanja;
		this.posiljalac = posiljalac;
		this.primalac = primalac;
		this.fajlovi = fajlovi;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getSadrzaj() {
		return sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public LocalDateTime getVremeSlanja() {
		return vremeSlanja;
	}

	public void setVremeSlanja(LocalDateTime vremeSlanja) {
		this.vremeSlanja = vremeSlanja;
	}

	public RegistrovaniKorisnik getPosiljalac() {
		return posiljalac;
	}

	public void setPosiljalac(RegistrovaniKorisnik posiljalac) {
		this.posiljalac = posiljalac;
	}

	public RegistrovaniKorisnik getPrimalac() {
		return primalac;
	}

	public void setPrimalac(RegistrovaniKorisnik primalac) {
		this.primalac = primalac;
	}

	public List<Fajl> getFajlovi() {
		return fajlovi;
	}

	public void setFajlovi(List<Fajl> fajlovi) {
		this.fajlovi = fajlovi;
	}
    
    
}
