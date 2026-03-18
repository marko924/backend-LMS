package lms.exception;

import java.time.LocalDateTime;

public class OdgovrNaGresku {  //ovo je samo klasa koja sluzi kao dto za obradu gresaka

	private LocalDateTime vreme;
    private int status;
    private String greska;
    private String poruka;
    
	public OdgovrNaGresku(int status, String greska, String poruka) {
		this.vreme = LocalDateTime.now();
		this.status = status;
		this.greska = greska;
		this.poruka = poruka;
	}

	public LocalDateTime getVreme() {
		return vreme;
	}

	public void setVreme(LocalDateTime vreme) {
		this.vreme = vreme;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getGreska() {
		return greska;
	}

	public void setGreska(String greska) {
		this.greska = greska;
	}

	public String getPoruka() {
		return poruka;
	}

	public void setPoruka(String poruka) {
		this.poruka = poruka;
	}
    
    
}
