package lms.dtos;

public class PolaganjeDTO {

    
    private Long id;
    private Double osvojeniBodovi;
    private String napomena;
    private Long evaluacijaZnanjaId;


    public PolaganjeDTO() {
        super();
    }

    
    public PolaganjeDTO(Long id, Double osvojeniBodovi, String napomena, Long evaluacijaZnanjaId) {
        super();
        this.id = id;
        this.osvojeniBodovi = osvojeniBodovi;
        this.napomena = napomena;
        this.evaluacijaZnanjaId = evaluacijaZnanjaId;
        
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
    
}

    
