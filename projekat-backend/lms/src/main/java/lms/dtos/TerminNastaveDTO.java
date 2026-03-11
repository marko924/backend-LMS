package lms.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class TerminNastaveDTO {

    private Long id;
    private LocalDateTime vremePocetka;
    private LocalDateTime vremeZavrsetka;
    private Long realizacijaId;
    private Long tipNastaveId;
    private List<Long> ishodiId;

    public TerminNastaveDTO() {}

    public TerminNastaveDTO(Long id, LocalDateTime vremePocetka, LocalDateTime vremeZavrsetka, Long realizacijaId,
			Long tipNastaveId, List<Long> ishodiId) {
		super();
		this.id = id;
		this.vremePocetka = vremePocetka;
		this.vremeZavrsetka = vremeZavrsetka;
		this.realizacijaId = realizacijaId;
		this.tipNastaveId = tipNastaveId;
		this.ishodiId = ishodiId;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getVremePocetka() {
        return vremePocetka;
    }

    public void setVremePocetka(LocalDateTime vremePocetka) {
        this.vremePocetka = vremePocetka;
    }

    public LocalDateTime getVremeZavrsetka() {
        return vremeZavrsetka;
    }

    public void setVremeZavrsetka(LocalDateTime vremeZavrsetka) {
        this.vremeZavrsetka = vremeZavrsetka;
    }

    public Long getRealizacijaId() {
        return realizacijaId;
    }

    public void setRealizacijaId(Long realizacijaId) {
        this.realizacijaId = realizacijaId;
    }

    public Long getTipNastaveId() {
        return tipNastaveId;
    }

    public void setTipNastaveId(Long tipNastaveId) {
        this.tipNastaveId = tipNastaveId;
    }

	public List<Long> getIshodiId() {
		return ishodiId;
	}

	public void setIshodiId(List<Long> ishodiId) {
		this.ishodiId = ishodiId;
	}
    
}
