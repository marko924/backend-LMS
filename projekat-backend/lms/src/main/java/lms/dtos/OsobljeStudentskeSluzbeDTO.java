package lms.dtos;

public class OsobljeStudentskeSluzbeDTO {
	
	private Long id;
	private String korisnickoIme;
    private String lozinka;
    private String email;
	private String ime;
	private String prezime;
	
	public OsobljeStudentskeSluzbeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OsobljeStudentskeSluzbeDTO(Long id, String korisnickoIme, String lozinka, String email, String ime,
			String prezime) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.email = email;
		this.ime = ime;
		this.prezime = prezime;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
