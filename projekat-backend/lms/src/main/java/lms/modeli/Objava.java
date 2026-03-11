package lms.modeli;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Objava extends LogickoBrisanje{
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
    
    @OneToMany
    @JoinColumn(name = "objava_id")
    private List<Fajl> fajlovi;

	public Objava() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Objava(Long id, String sadrzaj, LocalDateTime vremeObjave, Tema tema, KorisnikNaForumu autor,
			List<Fajl> fajlovi) {
		super();
		this.id = id;
		this.sadrzaj = sadrzaj;
		this.vremeObjave = vremeObjave;
		this.tema = tema;
		this.autor = autor;
		this.fajlovi = fajlovi;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSadrzaj() {
		return sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public LocalDateTime getVremeObjave() {
		return vremeObjave;
	}

	public void setVremeObjave(LocalDateTime vremeObjave) {
		this.vremeObjave = vremeObjave;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public KorisnikNaForumu getAutor() {
		return autor;
	}

	public void setAutor(KorisnikNaForumu autor) {
		this.autor = autor;
	}

	public List<Fajl> getFajlovi() {
		return fajlovi;
	}

	public void setFajlovi(List<Fajl> fajlovi) {
		this.fajlovi = fajlovi;
	}
    
    
}
