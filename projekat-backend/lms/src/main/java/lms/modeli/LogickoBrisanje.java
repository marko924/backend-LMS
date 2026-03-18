package lms.modeli;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass //sa ovim sam rekao da ova klasa nije tabela vec da se samo sva njena polja trebaju dodati u ostale tabele koje je naslede
public abstract class LogickoBrisanje {

    @Column(nullable = false)
    protected boolean obrisan = false;

    public boolean isObrisan() {
        return obrisan;
    }

    public void setObrisan(boolean obrisan) {
        this.obrisan = obrisan;
    }
    
}
