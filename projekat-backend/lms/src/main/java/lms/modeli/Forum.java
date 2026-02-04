package lms.modeli;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Forum {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
    private boolean javni;

    @OneToMany(mappedBy = "forum", cascade = CascadeType.ALL)
    private List<Tema> teme;
}
