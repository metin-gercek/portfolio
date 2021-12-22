
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Esine {

    private String nimi;
    private LocalDateTime luotu;

    public Esine(String nimi) {
        this.nimi = nimi;
        this.luotu = LocalDateTime.now();
    }

    public String getNimi() {
        return nimi;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        return this.nimi + " (luotu: " + formatter.format(this.luotu) + ")";
    }
}
