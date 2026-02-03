package lms.modeli;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Student extends RegistrovaniKorisnik {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column
    private String ime;

    @Column
    private String prezime;

    @Column(unique = true)
    private String jmbg;

    @OneToMany(mappedBy = "student")
    private List<StudentNaGodini> upisi;
    
    public Student() {}

	public Student(Long id, String ime, String prezime, String jmbg, List<StudentNaGodini> upisi) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.upisi = upisi;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
    
    
}
