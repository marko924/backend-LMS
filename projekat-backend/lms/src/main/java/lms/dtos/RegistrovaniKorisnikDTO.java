package lms.dtos;

import java.util.List;
import java.util.Set;

public class RegistrovaniKorisnikDTO {
	
	private Long id;
	private String korisnickoIme;
	private String lozinka;
	private String email;
	private Set<Long> ulogeId;
	private List<Long> clanstvaNaForumimaId;
	
	public RegistrovaniKorisnikDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RegistrovaniKorisnikDTO(Long id, String korisnickoIme, String lozinka, String email, Set<Long> ulogeId,
			List<Long> clanstvaNaForumimaId) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.email = email;
		this.ulogeId = ulogeId;
		this.clanstvaNaForumimaId = clanstvaNaForumimaId;
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
	public Set<Long> getUlogeId() {
		return ulogeId;
	}
	public void setUlogeId(Set<Long> ulogeId) {
		this.ulogeId = ulogeId;
	}
	public List<Long> getClanstvaNaForumimaId() {
		return clanstvaNaForumimaId;
	}
	public void setClanstvaNaForumimaId(List<Long> clanstvaNaForumimaId) {
		this.clanstvaNaForumimaId = clanstvaNaForumimaId;
	}
	
}
