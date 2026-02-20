package lms.modeli;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
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
