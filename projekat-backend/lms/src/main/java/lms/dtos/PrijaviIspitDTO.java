package lms.dtos;

public class PrijaviIspitDTO {

    private Long id;
    private Long studentId;
    private Long predmetId;

    public PrijaviIspitDTO() {}

    public PrijaviIspitDTO(Long id, Long studentId, Long predmetId) {
        this.id = id;
        this.studentId = studentId;
        this.predmetId = predmetId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getPredmetId() {
        return predmetId;
    }

    public void setPredmetId(Long predmetId) {
        this.predmetId = predmetId;
    }
}