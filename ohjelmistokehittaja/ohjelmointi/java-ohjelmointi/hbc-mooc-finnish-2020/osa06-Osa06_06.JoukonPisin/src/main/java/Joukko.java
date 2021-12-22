
import java.util.ArrayList;

public class Joukko {

    private String nimi;
    private ArrayList<String> alkiot;

    public Joukko(String nimi) {
        this.nimi = nimi;
        this.alkiot = new ArrayList<>();
    }

    public void lisaa(String alkio) {
        this.alkiot.add(alkio);
    }

    public ArrayList<String> getAlkiot() {
        return this.alkiot;
    }
    
    public String pisin() {
        if (this.alkiot.isEmpty()) {
            return null;
        }
        
        String pisin = "";
        for (String alkio: this.alkiot) {
            if(alkio.length() > pisin.length()) {
                pisin = alkio;
            }
        
            
        }
        return pisin;
    }

}
