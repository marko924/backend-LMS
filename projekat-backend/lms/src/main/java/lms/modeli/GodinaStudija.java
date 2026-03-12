package lms.modeli;

import java.time.LocalDate;
import java.util.Set;

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
public class GodinaStudija extends LogickoBrisanje{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer godina;
    
    @Column
    private LocalDate pocetak;
    
    @Column
    private LocalDate kraj;
    
    @OneToMany()
    @JoinColumn(name = "godina_id")
    private Set<Predmet> predmeti;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id")
    private StudijskiProgram studijskiProgram;
    
    public GodinaStudija() {}

	public GodinaStudija(Long id, Integer godina, LocalDate pocetak, LocalDate kraj, Set<Predmet> predmeti,
			StudijskiProgram studijskiProgram) {
		super();
		this.id = id;
		this.godina = godina;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.predmeti = predmeti;
		this.studijskiProgram = studijskiProgram;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getGodina() {
		return godina;
	}

	public void setGodina(Integer godina) {
		this.godina = godina;
	}

	public LocalDate getPocetak() {
		return pocetak;
	}

	public void setPocetak(LocalDate pocetak) {
		this.pocetak = pocetak;
	}

	public LocalDate getKraj() {
		return kraj;
	}

	public void setKraj(LocalDate kraj) {
		this.kraj = kraj;
	}

	public Set<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(Set<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public StudijskiProgram getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}

}

