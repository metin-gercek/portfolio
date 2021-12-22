// Älä muokkaa tätä luokkaa
import java.util.Objects;

public class Henkilo {

    private String nimi;
    private int pituus;

    public Henkilo(String nimi, int pituus) {
        this.nimi = nimi;
        this.pituus = pituus;
    }

    public String getNimi() {
        return nimi;
    }

    public int getPituus() {
        return pituus;
    }

    @Override
    public String toString() {
        return this.nimi + " (" + this.pituus + " cm)";
    }

    // Luotu NetBeansin insert code toiminnallisuudella
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
        final Henkilo other = (Henkilo) obj;
        if (this.pituus != other.pituus) {
            return false;
        }
        if (!Objects.equals(this.nimi, other.nimi)) {
            return false;
        }
        return true;
    }

}
