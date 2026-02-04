package lms.modeli;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Adresa {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String ulica;

    @Column(nullable = false, length = 10)
    private String broj;

    @ManyToOne(fetch = FetchType.LAZY) //Mi stavljamo fatchType da je Lazy zbog toga sto ako bi bilo drugacije onda bi program bezveze slao mnogo upita ka bazi bez ikakve potrebe
    @JoinColumn(name = "mesto_id", nullable = false) //A ovako ako nam treba nesto iz entiteta onda cemo to dobiti preko get metode
    private Mesto mesto;
}
