package lms.modeli;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "nastavni_materijal_id")
    private List<Fajl> fajlovi = new ArrayList<>();
    
    @ManyToMany(mappedBy = "nastavniMaterijali")
    private Set<RealizacijaPredmeta> realizacije = new HashSet<>();

    public NastavniMaterijal() {}

    public NastavniMaterijal(Long id, String naziv, String opis, List<Fajl> fajlovi,
			Set<RealizacijaPredmeta> realizacije) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.fajlovi = fajlovi;
		this.realizacije = realizacije;
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

    public List<Fajl> getFajlovi() {
        return fajlovi;
    }

    public void setFajlovi(List<Fajl> fajlovi) {
        this.fajlovi = fajlovi;
    }

	public Set<RealizacijaPredmeta> getRealizacije() {
		return realizacije;
	}

	public void setRealizacije(Set<RealizacijaPredmeta> realizacije) {
		this.realizacije = realizacije;
	}
    
}
