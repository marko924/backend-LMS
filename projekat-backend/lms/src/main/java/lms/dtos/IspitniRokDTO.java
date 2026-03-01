package lms.dtos;

import java.time.LocalDateTime;

public class IspitniRokDTO {

	private Long id;
	private String naziv;
	private LocalDateTime datumPocetka;
	private LocalDateTime datumZavrsetka;
	
	public IspitniRokDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IspitniRokDTO(Long id, String naziv, LocalDateTime datumPocetka, LocalDateTime datumZavrsetka) {
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
