package lms.modeli;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class NastavniMaterijal extends LogickoBrisanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String opis;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ishod_id")
    private Ishod ishod;

    @OneToMany(mappedBy = "nastavniMaterijal")
    private List<Fajl> fajlovi;

    public NastavniMaterijal() {}

	public NastavniMaterijal(Long id, String naziv, String opis, Ishod ishod, List<Fajl> fajlovi) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.ishod = ishod;
		this.fajlovi = fajlovi;
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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Ishod getIshod() {
		return ishod;
	}

	public void setIshod(Ishod ishod) {
		this.ishod = ishod;
	}

	public List<Fajl> getFajlovi() {
        return fajlovi;
    }

    public void setFajlovi(List<Fajl> fajlovi) {
        this.fajlovi = fajlovi;
    }
    
}
