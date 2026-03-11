package lms.modeli;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Predmet extends LogickoBrisanje{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;
    
    @Column
    private String opis;

    @Column
    private Integer espb;

    @Column
    private boolean obavezan;
    
    @Column
    private Integer brojPredavanja;
    
    @Column
    private Integer brojVezbi;
    
    @Column
    private Integer drugiObliciNastave;
    
    @Column
    private Integer istrazivackiRad;
    
    @Column 
    private Integer ostaliCasovi;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "preduslov_id", nullable = true)
    private Predmet preduslov;

    @OneToMany(mappedBy = "predmet")
    private List<RealizacijaPredmeta> realizacije;
    
    @OneToMany
    @JoinColumn(name="predmet_id")
    private List<Ishod> ishodi;
    
    public Predmet() {}

	public Predmet(Long id, String naziv, String opis, Integer espb, boolean obavezan, Integer brojPredavanja,
			Integer brojVezbi, Integer drugiObliciNastave, Integer istrazivackiRad, Integer ostaliCasovi,
			Predmet preduslov, List<RealizacijaPredmeta> realizacije, List<Ishod> ishodi) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.espb = espb;
		this.obavezan = obavezan;
		this.brojPredavanja = brojPredavanja;
		this.brojVezbi = brojVezbi;
		this.drugiObliciNastave = drugiObliciNastave;
		this.istrazivackiRad = istrazivackiRad;
		this.ostaliCasovi = ostaliCasovi;
		this.preduslov = preduslov;
		this.realizacije = realizacije;
		this.ishodi = ishodi;
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
	
	public String getOpis() {
		return opis;
	}
	
	public void setOpis(String opis) {
		this.opis= opis;
	}

	public Integer getEspb() {
		return espb;
	}

	public void setEspb(Integer espb) {
		this.espb = espb;
	}

	public List<RealizacijaPredmeta> getRealizacije() {
		return realizacije;
	}

	public void setRealizacije(List<RealizacijaPredmeta> realizacije) {
		this.realizacije = realizacije;
	}

	public boolean isObavezan() {
		return obavezan;
	}

	public void setObavezan(boolean obavezan) {
		this.obavezan = obavezan;
	}

	public Integer getBrojPredavanja() {
		return brojPredavanja;
	}

	public void setBrojPredavanja(Integer brojPredavanja) {
		this.brojPredavanja = brojPredavanja;
	}

	public Integer getBrojVezbi() {
		return brojVezbi;
	}

	public void setBrojVezbi(Integer brojVezbi) {
		this.brojVezbi = brojVezbi;
	}

	public Integer getDrugiObliciNastave() {
		return drugiObliciNastave;
	}

	public void setDrugiObliciNastave(Integer drugiObliciNastave) {
		this.drugiObliciNastave = drugiObliciNastave;
	}

	public Integer getIstrazivackiRad() {
		return istrazivackiRad;
	}

	public void setIstrazivackiRad(Integer istrazivackiRad) {
		this.istrazivackiRad = istrazivackiRad;
	}

	public Integer getOstaliCasovi() {
		return ostaliCasovi;
	}

	public void setOstaliCasovi(Integer ostaliCasovi) {
		this.ostaliCasovi = ostaliCasovi;
	}

	public Predmet getPreduslov() {
		return preduslov;
	}

	public void setPreduslov(Predmet preduslov) {
		this.preduslov = preduslov;
	}

	public List<Ishod> getIshodi() {
		return ishodi;
	}

	public void setIshodi(List<Ishod> ishodi) {
		this.ishodi = ishodi;
	}
    
}

