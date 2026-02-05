package lms.modeli;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Obavestenje extends LogickoBrisanje {
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "realizacija_id", nullable = false)
    private RealizacijaPredmeta realizacijaPredmeta;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nastavni_materijal_id", nullable = false)
    private NastavniMaterijal nastavniMaterijal;

	public Obavestenje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Obavestenje(Long id, String naslov, String sadrzaj, LocalDateTime datumObjave, List<Fajl> fajlovi,
			RealizacijaPredmeta realizacijaPredmeta, NastavniMaterijal nastavniMaterijal) {
		super();
		this.id = id;
		this.naslov = naslov;
		this.sadrzaj = sadrzaj;
		this.datumObjave = datumObjave;
		this.fajlovi = fajlovi;
		this.realizacijaPredmeta = realizacijaPredmeta;
		this.nastavniMaterijal = nastavniMaterijal;
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

	public LocalDateTime getDatumObjave() {
		return datumObjave;
	}

	public void setDatumObjave(LocalDateTime datumObjave) {
		this.datumObjave = datumObjave;
	}

	public List<Fajl> getFajlovi() {
		return fajlovi;
	}

	public void setFajlovi(List<Fajl> fajlovi) {
		this.fajlovi = fajlovi;
	}

	public RealizacijaPredmeta getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmeta realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public NastavniMaterijal getNastavniMaterijal() {
		return nastavniMaterijal;
	}

	public void setNastavniMaterijal(NastavniMaterijal nastavniMaterijal) {
		this.nastavniMaterijal = nastavniMaterijal;
	}
    
    
}
