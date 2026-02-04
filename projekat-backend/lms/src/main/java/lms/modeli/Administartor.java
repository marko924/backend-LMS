package lms.modeli;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Administartor extends RegistrovaniKorisnik{

	public Administartor() {
		super();
		// TODO Auto-generated constructor stub
	}

}
