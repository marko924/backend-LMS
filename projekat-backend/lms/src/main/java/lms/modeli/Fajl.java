package lms.modeli;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fajl {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column
    private String opis;

    @Column(nullable = false)
    private String url; 
    
    //Bilo gde se ovaj Entitet koristi onda u tom entitetu napisati nesto poput ovoga:
    
    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "objava_id") // Unidirekciona veza ka fajlovima
    //private List<Fajl> fajlovi = new ArrayList<>();
    
    //Sa ovim samo entitet koji je povezan sa fajlom njega moze da vidi ali ne i obrnuto
}
