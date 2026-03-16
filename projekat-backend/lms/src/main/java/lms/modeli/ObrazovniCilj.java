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
    
    @OneToMany(mappedBy = "obrazovniCilj")
    private Set<IshodObrazovniCilj> ishodiVeze = new HashSet<>();

	public ObrazovniCilj() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ObrazovniCilj(Long id, String opis, Set<IshodObrazovniCilj> ishodiVeze) {
		super();
		this.id = id;
		this.opis = opis;
		this.ishodiVeze = ishodiVeze;
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

	public Set<IshodObrazovniCilj> getIshodiVeze() {
		return ishodiVeze;
	}

	public void setIshodiVeze(Set<IshodObrazovniCilj> ishodiVeze) {
		this.ishodiVeze = ishodiVeze;
	}
	
}
