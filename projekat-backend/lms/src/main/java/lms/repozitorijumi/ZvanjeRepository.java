package lms.repozitorijumi;

import org.springframework.stereotype.Repository;
import lms.modeli.Zvanje;

@Repository
public interface ZvanjeRepository extends LogickoBrisanjeRepozitorijum<Zvanje, Long> { }
