package lms.dtos;

public class AdministratorDTO {
	
	private Long id;
	private String korisnickoIme;
    private String lozinka;
    private String email;

	public AdministratorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdministratorDTO(Long id, String korisnickoIme, String lozinka, String email) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.email = email;
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
	
	
}
