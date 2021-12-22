
import java.util.HashMap;

public class Sanakirja {

    private HashMap<String, String> kaannokset;

    public Sanakirja() {
        this.kaannokset = new HashMap<>();
    }

    public String kaanna(String sana) {
        return this.kaannokset.get(sana);
    }

    public void lisaa(String sana, String kaannos) {
        this.kaannokset.put(sana, kaannos);
    }
}
