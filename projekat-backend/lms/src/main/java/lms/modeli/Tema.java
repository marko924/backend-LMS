package lms.modeli;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Tema extends LogickoBrisanje{
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
    private KorisnikNaForumu autor;

    @OneToMany(mappedBy = "tema", cascade = CascadeType.ALL) //zbog kompozicije
    private List<Objava> objave;

	public Tema() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tema(Long id, String naslov, LocalDateTime vremeKreiranja, Forum forum, KorisnikNaForumu autor,
			List<Objava> objave) {
		super();
		this.id = id;
		this.naslov = naslov;
		this.vremeKreiranja = vremeKreiranja;
		this.forum = forum;
		this.autor = autor;
		this.objave = objave;
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

	public LocalDateTime getVremeKreiranja() {
		return vremeKreiranja;
	}

	public void setVremeKreiranja(LocalDateTime vremeKreiranja) {
		this.vremeKreiranja = vremeKreiranja;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public KorisnikNaForumu getAutor() {
		return autor;
	}

	public void setAutor(KorisnikNaForumu autor) {
		this.autor = autor;
	}

	public List<Objava> getObjave() {
		return objave;
	}

	public void setObjave(List<Objava> objave) {
		this.objave = objave;
	}
    
    
}
