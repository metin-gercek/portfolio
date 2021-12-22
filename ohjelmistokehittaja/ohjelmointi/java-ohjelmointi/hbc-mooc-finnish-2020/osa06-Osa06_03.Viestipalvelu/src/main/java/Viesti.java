
import java.util.Objects;

public class Viesti {

    private String lahettaja;
    private String sisalto;

    public Viesti(String lahettaja, String sisalto) {
        this.lahettaja = lahettaja;
        this.sisalto = sisalto;
    }

    public String getLahettaja() {
        return lahettaja;
    }

    public String getSisalto() {
        return sisalto;
    }

    public String toString() {
        return this.lahettaja + ": " + this.sisalto;
    }

    // luotu NetBeansin insert code -toiminnallisuudella
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Viesti other = (Viesti) obj;
        if (!Objects.equals(this.lahettaja, other.lahettaja)) {
            return false;
        }
        if (!Objects.equals(this.sisalto, other.sisalto)) {
            return false;
        }
        return true;
    }

}
