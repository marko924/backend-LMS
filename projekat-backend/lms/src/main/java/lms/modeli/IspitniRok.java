package lms.modeli;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class IspitniRok extends LogickoBrisanje{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@Column(nullable = false)
	private LocalDateTime datumPocetka;
	
	@Column(nullable = false)
	private LocalDateTime datumZavrsetka;

	public IspitniRok() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IspitniRok(Long id, String naziv, LocalDateTime datumPocetka, LocalDateTime datumZavrsetka) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumPocetka = datumPocetka;
		this.datumZavrsetka = datumZavrsetka;
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

	public LocalDateTime getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(LocalDateTime datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public LocalDateTime getDatumZavrsetka() {
		return datumZavrsetka;
	}

	public void setDatumZavrsetka(LocalDateTime datumZavrsetka) {
		this.datumZavrsetka = datumZavrsetka;
	}
	
}
