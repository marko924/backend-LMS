package lms.modeli;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ishod_obrazovni_cilj")
public class IshodObrazovniCilj extends LogickoBrisanje{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ishod_id")
    private Ishod ishod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "obrazovni_cilj_id")
    private ObrazovniCilj obrazovniCilj;

	public IshodObrazovniCilj() {
		super();
	}

	public IshodObrazovniCilj(Long id, Ishod ishod, ObrazovniCilj obrazovniCilj) {
		super();
		this.id = id;
		this.ishod = ishod;
		this.obrazovniCilj = obrazovniCilj;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ishod getIshod() {
		return ishod;
	}

	public void setIshod(Ishod ishod) {
		this.ishod = ishod;
	}

	public ObrazovniCilj getObrazovniCilj() {
		return obrazovniCilj;
	}

	public void setObrazovniCilj(ObrazovniCilj obrazovniCilj) {
		this.obrazovniCilj = obrazovniCilj;
	}
    
}
