package lms.dtos;

public class PohadjanjePredmetaDTO {

    private Long id;
    private Integer konacnaOcena;
    private Long studentNaGodiniId;
    private Long realizacijaId;

    public PohadjanjePredmetaDTO() {}

    public PohadjanjePredmetaDTO(Long id, Integer konacnaOcena, Long studentNaGodiniId, Long realizacijaId) {
        this.id = id;
        this.konacnaOcena = konacnaOcena;
        this.studentNaGodiniId = studentNaGodiniId;
        this.realizacijaId = realizacijaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getKonacnaOcena() {
        return konacnaOcena;
    }

    public void setKonacnaOcena(Integer konacnaOcena) {
        this.konacnaOcena = konacnaOcena;
    }

    public Long getStudentNaGodiniId() {
        return studentNaGodiniId;
    }

    public void setStudentNaGodiniId(Long studentNaGodiniId) {
        this.studentNaGodiniId = studentNaGodiniId;
    }

    public Long getRealizacijaId() {
        return realizacijaId;
    }

    public void setRealizacijaId(Long realizacijaId) {
        this.realizacijaId = realizacijaId;
    }
}