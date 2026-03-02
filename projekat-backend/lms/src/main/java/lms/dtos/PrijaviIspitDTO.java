package lms.dtos;

public class PrijaviIspitDTO {

    private Long id;
    private Long studentNaGodiniId;
    private Long evaluacijaZnanjaId;

    public PrijaviIspitDTO() {}

    public PrijaviIspitDTO(Long id, Long studentNaGodiniId, Long evaluacijaZnanjaId) {
        this.id = id;
        this.studentNaGodiniId = studentNaGodiniId;
        this.evaluacijaZnanjaId = evaluacijaZnanjaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentNaGodiniId() {
        return studentNaGodiniId;
    }

    public void setStudentNaGodiniId(Long studentNaGodiniId) {
        this.studentNaGodiniId = studentNaGodiniId;
    }

    public Long getEvaluacijaZnanjaId() {
        return evaluacijaZnanjaId;
    }

    public void setEvaluacijaZnanjaId(Long evaluacijaZnanjaId) {
        this.evaluacijaZnanjaId = evaluacijaZnanjaId;
    }
}