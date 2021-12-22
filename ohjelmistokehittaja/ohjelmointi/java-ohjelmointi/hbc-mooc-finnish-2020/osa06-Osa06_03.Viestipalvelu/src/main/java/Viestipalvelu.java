
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s2100631
 */
public class Viestipalvelu {
    
    private ArrayList<Viesti> viesti;
    
    public Viestipalvelu(){
        this.viesti = new ArrayList<>();
    }
    
    public void lisaa(Viesti viesti) {
        
        if (!(viesti.getSisalto().length() > 280)) {
            this.viesti.add(viesti);
        }
        
    }
    public ArrayList<Viesti> getViestit() {
        return this.viesti;
    }
    
}
