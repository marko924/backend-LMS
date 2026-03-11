package lms.dtos;

public class PolaganjeDTO {
    
    private Long id;
    private Double osvojeniBodovi;
    private String napomena;
    private Long evaluacijaZnanjaId;
    private Long studentNaGodiniId;

    public PolaganjeDTO() {
        super();
    }

    // Ažuriran konstruktor sa studentNaGodiniId
    public PolaganjeDTO(Long id, Double osvojeniBodovi, String napomena, Long evaluacijaZnanjaId, Long studentNaGodiniId) {
        super();
        this.id = id;
        this.osvojeniBodovi = osvojeniBodovi;
        this.napomena = napomena;
        this.evaluacijaZnanjaId = evaluacijaZnanjaId;
        this.studentNaGodiniId = studentNaGodiniId;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getOsvojeniBodovi() {
        return osvojeniBodovi;
    }
    public void setOsvojeniBodovi(Double osvojeniBodovi) {
        this.osvojeniBodovi = osvojeniBodovi;
    }
    public String getNapomena() {
        return napomena;
    }
    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }
    public Long getEvaluacijaZnanjaId() {
        return evaluacijaZnanjaId;
    }
    public void setEvaluacijaZnanjaId(Long evaluacijaZnanjaId) {
        this.evaluacijaZnanjaId = evaluacijaZnanjaId;
    }

    // DODATI GETER I SETER ZA NOVO POLJE
    public Long getStudentNaGodiniId() {
        return studentNaGodiniId;
    }
    public void setStudentNaGodiniId(Long studentNaGodiniId) {
        this.studentNaGodiniId = studentNaGodiniId;
    }
}