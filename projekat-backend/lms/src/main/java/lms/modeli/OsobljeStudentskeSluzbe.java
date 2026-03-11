package lms.modeli;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id") //Ovo je da se vidi da je id registrovanog korisnika i id objekta osobljeStudentskeSluzbe
public class OsobljeStudentskeSluzbe extends RegistrovaniKorisnik{
	@Column(nullable = false, length = 50)
    private String ime;

    @Column(nullable = false, length = 50)
    private String prezime;

	public OsobljeStudentskeSluzbe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OsobljeStudentskeSluzbe(String ime, String prezime) {
		super();
		this.ime = ime;
		this.prezime = prezime;
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
    
    
}
