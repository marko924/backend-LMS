package lms.modeli;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fajl extends LogickoBrisanje {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column
    private String opis;

    @Column(nullable = false)
    private String url;

	public Fajl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fajl(Long id, String opis, String url) {
		super();
		this.id = id;
		this.opis = opis;
		this.url = url;
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
    
    //Bilo gde se ovaj Entitet koristi onda u tom entitetu napisati nesto poput ovoga:
    
    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "objava_id") // Unidirekciona veza ka fajlovima
    //private List<Fajl> fajlovi = new ArrayList<>();
    
    //Sa ovim samo entitet koji je povezan sa fajlom njega moze da vidi ali ne i obrnuto
    
    
}
