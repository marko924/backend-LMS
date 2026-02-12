package lms.dtos;


import java.time.LocalDate;

public class ZvanjeDTO {

    private Long id;
    private LocalDate datumIzbora;
    private LocalDate datumOtkaza;
    private Long nastavnikId;       
    private Long tipZvanjaId;       
    private Long naucnaOblastId;    

    public ZvanjeDTO() {}

    public ZvanjeDTO(Long id, LocalDate datumIzbora, LocalDate datumOtkaza,
                     Long nastavnikId, Long tipZvanjaId, Long naucnaOblastId) {
        this.id = id;
        this.datumIzbora = datumIzbora;
        this.datumOtkaza = datumOtkaza;
        this.nastavnikId = nastavnikId;
        this.tipZvanjaId = tipZvanjaId;
        this.naucnaOblastId = naucnaOblastId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDatumIzbora() {
        return datumIzbora;
    }

    public void setDatumIzbora(LocalDate datumIzbora) {
        this.datumIzbora = datumIzbora;
    }

    public LocalDate getDatumOtkaza() {
        return datumOtkaza;
    }

    public void setDatumOtkaza(LocalDate datumOtkaza) {
        this.datumOtkaza = datumOtkaza;
    }

    public Long getNastavnikId() {
        return nastavnikId;
    }

    public void setNastavnikId(Long nastavnikId) {
        this.nastavnikId = nastavnikId;
    }

    public Long getTipZvanjaId() {
        return tipZvanjaId;
    }

    public void setTipZvanjaId(Long tipZvanjaId) {
        this.tipZvanjaId = tipZvanjaId;
    }

    public Long getNaucnaOblastId() {
        return naucnaOblastId;
    }

    public void setNaucnaOblastId(Long naucnaOblastId) {
        this.naucnaOblastId = naucnaOblastId;
    }
}

