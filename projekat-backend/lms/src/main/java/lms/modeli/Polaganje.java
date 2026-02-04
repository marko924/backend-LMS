package lms.modeli;

import jakarta.persistence.*;

@Entity
public class Polaganje {
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

    //Ovo uraditi za sve entitete koji su povezani sa ovim
    
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "student_na_godini_id", nullable = false)
    //private StudentNaGodini studentNaGodini;
}
