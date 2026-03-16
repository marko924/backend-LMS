package lms.dtos;

public class KorisnikUlogaDTO {

	private Long id;
	private Long korisnikId;
	private Long ulogaId;
	
	public KorisnikUlogaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KorisnikUlogaDTO(Long id, Long korisnikId, Long ulogaId) {
		super();
		this.id = id;
		this.korisnikId = korisnikId;
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

	public Long getUlogaId() {
		return ulogaId;
	}

	public void setUlogaId(Long ulogaId) {
		this.ulogaId = ulogaId;
	}
	
}
