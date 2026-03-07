package lms.modeli;

import jakarta.persistence.*;

@Entity
public class Polaganje extends LogickoBrisanje {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "osvojeni_bodovi", nullable = false)
    private Double osvojeniBodovi;

    @Column(columnDefinition = "TEXT")
    private String napomena;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluacija_id", nullable = false)
    private EvaluacijaZnanja evaluacijaZnanja;

	public Polaganje() {
		super();
	}

	public Polaganje(Long id, Double osvojeniBodovi, String napomena, EvaluacijaZnanja evaluacijaZnanja) {
		super();
		this.id = id;
		this.osvojeniBodovi = osvojeniBodovi;
		this.napomena = napomena;
		this.evaluacijaZnanja = evaluacijaZnanja;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getOsvojeniBodovi() {
		return osvojeniBodovi;
	}

	public void setOsvojeniBodovi(Double osvojeniBodovi) {
		this.osvojeniBodovi = osvojeniBodovi;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public EvaluacijaZnanja getEvaluacijaZnanja() {
		return evaluacijaZnanja;
	}

	public void setEvaluacijaZnanja(EvaluacijaZnanja evaluacijaZnanja) {
		this.evaluacijaZnanja = evaluacijaZnanja;
	}

    
}
