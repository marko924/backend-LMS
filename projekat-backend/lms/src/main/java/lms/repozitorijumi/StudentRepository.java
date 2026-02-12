package lms.repozitorijumi;

import org.springframework.stereotype.Repository;
import lms.modeli.Student;

@Repository
public interface StudentRepository extends LogickoBrisanjeRepozitorijum<Student, Long> { }
