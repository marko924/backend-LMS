package lms.modeli;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class ObrazovniCilj extends LogickoBrisanje {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String opis;
    
    @ManyToMany(mappedBy = "obrazovniCiljevi", fetch = FetchType.LAZY)
    private Set<Ishod> ishodi = new HashSet<>();

	public ObrazovniCilj() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ObrazovniCilj(Long id, String opis, Set<Ishod> ishodi) {
		super();
		this.id = id;
		this.opis = opis;
		this.ishodi = ishodi;
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

	public Set<Ishod> getIshodi() {
		return ishodi;
	}

	public void setIshodi(Set<Ishod> ishodi) {
		this.ishodi = ishodi;
	}

    
}
