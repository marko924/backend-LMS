package lms.modeli;

import jakarta.persistence.*;

@Entity
public class ObrazovniCilj extends LogickoBrisanje {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String opis;

	public ObrazovniCilj() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ObrazovniCilj(Long id, String opis) {
		super();
		this.id = id;
		this.opis = opis;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

    
}
