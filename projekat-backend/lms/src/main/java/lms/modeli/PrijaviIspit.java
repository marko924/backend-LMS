package lms.modeli;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PrijaviIspit extends LogickoBrisanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_na_godini_id", nullable = false)
    private StudentNaGodini studentNaGodini;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluacija_znanja_id", nullable = false)
    private EvaluacijaZnanja evaluacijaZnanja;

    public PrijaviIspit() {}

    public PrijaviIspit(Long id, StudentNaGodini studentNaGodini, EvaluacijaZnanja evaluacijaZnanja) {
        super();
        this.id = id;
        this.studentNaGodini = studentNaGodini;
        this.evaluacijaZnanja = evaluacijaZnanja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentNaGodini getStudentNaGodini() {
        return studentNaGodini;
    }

    public void setStudentNaGodini(StudentNaGodini studentNaGodini) {
        this.studentNaGodini = studentNaGodini;
    }

    public EvaluacijaZnanja getEvaluacijaZnanja() {
        return evaluacijaZnanja;
    }

    public void setEvaluacijaZnanja(EvaluacijaZnanja evaluacijaZnanja) {
        this.evaluacijaZnanja = evaluacijaZnanja;
    }
}