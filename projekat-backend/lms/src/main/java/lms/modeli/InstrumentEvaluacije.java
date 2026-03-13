package lms.modeli;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class InstrumentEvaluacije extends LogickoBrisanje{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naziv;

    @Column
    private String opis;
    
    @OneToMany(mappedBy="instrumentEvaluacije")
    private List<Fajl> fajlovi;

	public InstrumentEvaluacije() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InstrumentEvaluacije(Long id, String naziv, String opis, List<Fajl> fajlovi) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
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

	public List<Fajl> getFajlovi() {
		return fajlovi;
	}

	public void setFajlovi(List<Fajl> fajlovi) {
		this.fajlovi = fajlovi;
	}
    
    
}
