package lms.repozitorijumi;

import org.springframework.data.jpa.domain.Specification;

import lms.modeli.LogickoBrisanje;

public class LogickoBrisanjeSpecifikacija {
	
	//Ovo je specifikacija koja mi pomaze da izvucem samo one podatke koji nisu obrisani

    @SuppressWarnings("unused")
    //Ova metoda vraca pravilo koje kaze da treba da se izvuku samo oni redovi gde je vrednost kolone obrisan false
	public static <T extends LogickoBrisanje> Specification<T> notDeleted() {
    	//navodjenje <T extends LogickoBrisanje> sam naglasio da ovu specifikaciju smeju da koriste samo oni entiteti koji nasledjuju LogickoBrisanje 
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.isFalse(root.get("obrisan")); //sa ovim delom pristupam polju obrisan iz tabele u bazi i uzimam njenu vrednost
                                                          //criteriaBuilder.isFalse() se u pozadini prevodi kao sql upit: WHERE obrisan = false 
    }
}