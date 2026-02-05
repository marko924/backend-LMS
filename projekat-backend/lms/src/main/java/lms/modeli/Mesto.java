package lms.modeli;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Mesto extends LogickoBrisanje{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naziv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drzava_id", nullable = false)
    private Drzava drzava;

	public Mesto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mesto(Long id, String naziv, Drzava drzava) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.drzava = drzava;
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

	public Drzava getDrzava() {
		return drzava;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}
    
    
}
