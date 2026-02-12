package lms.dtos;


public class GodinaStudijaDTO {

    private Long id;
    private Integer godina;

    public GodinaStudijaDTO() {}

    public GodinaStudijaDTO(Long id, Integer godina) {
        this.id = id;
        this.godina = godina;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGodina() {
        return godina;
    }

    public void setGodina(Integer godina) {
        this.godina = godina;
    }
}

