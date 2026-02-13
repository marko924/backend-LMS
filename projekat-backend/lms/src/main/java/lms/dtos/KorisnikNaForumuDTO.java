package lms.dtos;

public class KorisnikNaForumuDTO {
	
	private Long id;
	private Long korisnikId;
	private Long forumId;
	private Long ulogaId;
	
	public KorisnikNaForumuDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public KorisnikNaForumuDTO(Long id, Long korisnikId, Long forumId, Long ulogaId) {
		super();
		this.id = id;
		this.korisnikId = korisnikId;
		this.forumId = forumId;
		this.ulogaId = ulogaId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getKorisnikId() {
		return korisnikId;
	}
	public void setKorisnikId(Long korisnikId) {
		this.korisnikId = korisnikId;
	}
	public Long getForumId() {
		return forumId;
	}
	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}
	public Long getUlogaId() {
		return ulogaId;
	}
	public void setUlogaId(Long ulogaId) {
		this.ulogaId = ulogaId;
	}
	
}
