package lms.modeli;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Forum extends LogickoBrisanje {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
    private boolean javni;

    @OneToMany(mappedBy = "forum", cascade = CascadeType.ALL) //Zbog kompozicije (crni kvadrat)
    private List<Tema> teme;
    
    @OneToMany(mappedBy = "forum")
    private List<KorisnikNaForumu> clanovi;

	public Forum() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Forum(Long id, boolean javni, List<Tema> teme, List<KorisnikNaForumu> clanovi) {
		super();
		this.id = id;
		this.javni = javni;
		this.teme = teme;
		this.clanovi = clanovi;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isJavni() {
		return javni;
	}

	public void setJavni(boolean javni) {
		this.javni = javni;
	}

	public List<Tema> getTeme() {
		return teme;
	}

	public void setTeme(List<Tema> teme) {
		this.teme = teme;
	}

	public List<KorisnikNaForumu> getClanovi() {
		return clanovi;
	}

	public void setClanovi(List<KorisnikNaForumu> clanovi) {
		this.clanovi = clanovi;
	}
    
}
