package lms.repozitorijumi;

import org.springframework.data.jpa.domain.Specification;

import lms.modeli.LogickoBrisanje;

public class LogickoBrisanjeSpecifikacija {

    @SuppressWarnings("unused")
	public static <T extends LogickoBrisanje> Specification<T> notDeleted() {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.isFalse(root.get("obrisan"));
    }
}