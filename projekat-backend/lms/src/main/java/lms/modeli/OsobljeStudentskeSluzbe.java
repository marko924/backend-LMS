package lms.modeli;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id") //Ovo je da se vidi da je id registrovanog korisnika i id objekta osobljeStudentskeSluzbe
public class OsobljeStudentskeSluzbe extends RegistrovaniKorisnik{
	@Column(nullable = false, length = 50)
    private String ime;

    @Column(nullable = false, length = 50)
    private String prezime;
}
