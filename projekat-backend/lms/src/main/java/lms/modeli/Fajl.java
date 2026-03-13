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
public class Fajl extends LogickoBrisanje {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column
    private String opis;

    @Column(nullable = false)
    private String url;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nastavni_materijal_id")
    private NastavniMaterijal nastavniMaterijal;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instrument_evaluacije_id")
    private InstrumentEvaluacije instrumentEvaluacije;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "obavestenje_id", nullable = true)
    private Obavestenje obavestenje;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "objava_id", nullable = true)
    private Objava objava;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "poruka_id", nullable = true)
    private Poruka poruka;

	public Fajl() {
		super();
	}

	public Fajl(Long id, String opis, String url, NastavniMaterijal nastavniMaterijal,
			InstrumentEvaluacije instrumentEvaluacije, Obavestenje obavestenje, Objava objava, Poruka poruka) {
		super();
		this.id = id;
		this.opis = opis;
		this.url = url;
		this.nastavniMaterijal = nastavniMaterijal;
		this.instrumentEvaluacije = instrumentEvaluacije;
		this.obavestenje = obavestenje;
		this.objava = objava;
		this.poruka = poruka;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public NastavniMaterijal getNastavniMaterijal() {
		return nastavniMaterijal;
	}

	public void setNastavniMaterijal(NastavniMaterijal nastavniMaterijal) {
		this.nastavniMaterijal = nastavniMaterijal;
	}

	public InstrumentEvaluacije getInstrumentEvaluacije() {
		return instrumentEvaluacije;
	}

	public void setInstrumentEvaluacije(InstrumentEvaluacije instrumentEvaluacije) {
		this.instrumentEvaluacije = instrumentEvaluacije;
	}

	public Obavestenje getObavestenje() {
		return obavestenje;
	}

	public void setObavestenje(Obavestenje obavestenje) {
		this.obavestenje = obavestenje;
	}

	public Objava getObjava() {
		return objava;
	}

	public void setObjava(Objava objava) {
		this.objava = objava;
	}

	public Poruka getPoruka() {
		return poruka;
	}

	public void setPoruka(Poruka poruka) {
		this.poruka = poruka;
	}
    
}
