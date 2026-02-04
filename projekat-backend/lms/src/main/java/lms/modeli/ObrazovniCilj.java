package lms.modeli;

import jakarta.persistence.*;

@Entity
public class ObrazovniCilj {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String opis;

    //Ovo uraditi za sve entitete koji su povezani sa ovim
    
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "predmet_id", nullable = false)
    //private Predmet predmet;
}
