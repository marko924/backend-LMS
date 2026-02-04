package lms.modeli;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EvaluacijaZnanja {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vreme_pocetka", nullable = false)
    private LocalDateTime vremePocetka;

    @Column(name = "vreme_zavrsetka", nullable = false)
    private LocalDateTime vremeZavrsetka;

    @Column(name = "maksimalni_bodovi")
    private Double maksimalniBodovi = 100.0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tip_evaluacije_id", nullable = false)
    private TipEvaluacije tipEvaluacije;

    //Ovo uraditi za svaki entitet koji je spojen za ovaj:
    
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "realizacija_id", nullable = false)
    //private RealizacijaPredmeta realizacijaPredmeta;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "instrument_id", nullable = false)
    //private InstrumentEvaluacije instrumentEvaluacije;
}
