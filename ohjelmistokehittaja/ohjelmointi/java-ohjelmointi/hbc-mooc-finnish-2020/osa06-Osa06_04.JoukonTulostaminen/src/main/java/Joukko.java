
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

   
    @Override
    public String toString() {
        
        if (this.alkiot.isEmpty()){
            return "Joukko "+ this.nimi+ " on tyhjä.";
        }
        
        String alkioAlkiot = "";
        for (String alkio:this.alkiot) {
            alkioAlkiot = alkioAlkiot + "\n" + alkio;
        }
        
        if (this.alkiot.size() == 1) {
            return "Joukossa " + this.nimi + " on " + this.alkiot.size() + " alkio:" + alkioAlkiot;
        } else {
            return "Joukossa " + this.nimi + " on " + this.alkiot.size() + " alkiota:" + alkioAlkiot;
            
        }      
    }
    
    
    
}
