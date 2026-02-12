package lms.repozitorijumi;

import org.springframework.stereotype.Repository;
import lms.modeli.Predmet;

@Repository
public interface PredmetRepository extends LogickoBrisanjeRepozitorijum<Predmet, Long> { }
