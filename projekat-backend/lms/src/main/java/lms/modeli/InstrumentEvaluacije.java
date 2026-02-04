package lms.modeli;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
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
public class InstrumentEvaluacije {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naziv;

    @Column
    private String opis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluacija_id", nullable = false)
    private EvaluacijaZnanja evaluacijaZnanja;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "instrument_evaluacije_id") // Unidirekciona veza ka fajlovima
    private List<Fajl> fajlovi = new ArrayList<>();
}
