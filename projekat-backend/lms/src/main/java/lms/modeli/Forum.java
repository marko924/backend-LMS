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

    @OneToMany(mappedBy = "forum", cascade = CascadeType.ALL)
    private List<Tema> teme;

	public Forum() {
		super();
		// TODO Auto-generated constructor stub
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
    
    
}
