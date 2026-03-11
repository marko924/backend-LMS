package lms.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class EvaluacijaZnanjaDTO {
	private Long id;
	private LocalDateTime vremePocetka;
	private LocalDateTime vremeZavrsetka;
	private Double maksimalniBodovi;
	private Long tipEvaluacijeId;
	private Long realizacijaPredmetaId;
	private Long instrumentEvaluacijeId;
	private Long ispitniRokId;
	private List<Long> polaganjaId;
	private List<Long> ishodiId;
	
	public EvaluacijaZnanjaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EvaluacijaZnanjaDTO(Long id, LocalDateTime vremePocetka, LocalDateTime vremeZavrsetka,
			Double maksimalniBodovi, Long tipEvaluacijeId, Long realizacijaPredmetaId, Long instrumentEvaluacijeId,
			Long ispitniRokId, List<Long> polaganjaId, List<Long> ishodiId) {
		super();
		this.id = id;
		this.vremePocetka = vremePocetka;
		this.vremeZavrsetka = vremeZavrsetka;
		this.maksimalniBodovi = maksimalniBodovi;
		this.tipEvaluacijeId = tipEvaluacijeId;
		this.realizacijaPredmetaId = realizacijaPredmetaId;
		this.instrumentEvaluacijeId = instrumentEvaluacijeId;
		this.ispitniRokId = ispitniRokId;
		this.polaganjaId = polaganjaId;
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
	public Double getMaksimalniBodovi() {
		return maksimalniBodovi;
	}
	public void setMaksimalniBodovi(Double maksimalniBodovi) {
		this.maksimalniBodovi = maksimalniBodovi;
	}
	public Long getTipEvaluacijeId() {
		return tipEvaluacijeId;
	}
	public void setTipEvaluacijeId(Long tipEvaluacijeId) {
		this.tipEvaluacijeId = tipEvaluacijeId;
	}
	public Long getRealizacijaPredmetaId() {
		return realizacijaPredmetaId;
	}
	public void setRealizacijaPredmetaId(Long realizacijaPredmetaId) {
		this.realizacijaPredmetaId = realizacijaPredmetaId;
	}
	public Long getInstrumentEvaluacijeId() {
		return instrumentEvaluacijeId;
	}
	public void setInstrumentEvaluacijeId(Long instrumentEvaluacijeId) {
		this.instrumentEvaluacijeId = instrumentEvaluacijeId;
	}

	public Long getIspitniRokId() {
		return ispitniRokId;
	}

	public void setIspitniRokId(Long ispitniRokId) {
		this.ispitniRokId = ispitniRokId;
	}

	public List<Long> getPolaganjaId() {
		return polaganjaId;
	}

	public void setPolaganjaId(List<Long> polaganjaId) {
		this.polaganjaId = polaganjaId;
	}

	public List<Long> getIshodiId() {
		return ishodiId;
	}

	public void setIshodiId(List<Long> ishodiId) {
		this.ishodiId = ishodiId;
	}
	
}
