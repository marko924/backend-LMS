package lms.modeli;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Univerzitet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private LocalDate datumOsnivanja;

    @ManyToOne
    private Nastavnik rektor;

    @OneToMany(mappedBy = "univerzitet")
    private List<Fakultet> fakulteti;
    
    public Univerzitet() {}

	public Univerzitet(Long id, String naziv, LocalDate datumOsnivanja, Nastavnik rektor, List<Fakultet> fakulteti) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
		this.rektor = rektor;
		this.fakulteti = fakulteti;
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

	public LocalDate getDatumOsnivanja() {
		return datumOsnivanja;
	}

	public void setDatumOsnivanja(LocalDate datumOsnivanja) {
		this.datumOsnivanja = datumOsnivanja;
	}

	public Nastavnik getRektor() {
		return rektor;
	}

	public void setRektor(Nastavnik rektor) {
		this.rektor = rektor;
	}

	public List<Fakultet> getFakulteti() {
		return fakulteti;
	}

	public void setFakulteti(List<Fakultet> fakulteti) {
		this.fakulteti = fakulteti;
	}
    
    
}

