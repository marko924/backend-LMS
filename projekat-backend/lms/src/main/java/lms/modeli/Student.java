package lms.modeli;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Student extends RegistrovaniKorisnik{
	
	
    @Column
    private String ime;

    @Column
    private String prezime;

    @Column(unique = true)
    private String jmbg;

    @OneToMany(mappedBy = "student")
    private List<StudentNaGodini> upisi;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adresa_id", nullable = false)
    private Adresa adresa;
    
    public Student() {}

	public Student(String ime, String prezime, String jmbg, List<StudentNaGodini> upisi, Adresa adresa) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.upisi = upisi;
		this.adresa = adresa;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public List<StudentNaGodini> getUpisi() {
		return upisi;
	}

	public void setUpisi(List<StudentNaGodini> upisi) {
		this.upisi = upisi;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
    
}
