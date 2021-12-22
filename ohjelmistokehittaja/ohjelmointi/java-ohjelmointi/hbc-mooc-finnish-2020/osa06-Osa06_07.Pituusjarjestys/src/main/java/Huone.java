
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
public class Huone {
    private ArrayList<Henkilo> henkilo;
    
    public Huone() {
        this.henkilo = new ArrayList<>();
    }
    
    public void lisaa(Henkilo henkilo) {
        this.henkilo.add(henkilo);
    }
    
    public boolean onTyhja() {
        if (this.henkilo.size() == 0) {
            return true;
        }
        return false;
    }
    
    public ArrayList<Henkilo> getHenkilot() {
        return this.henkilo;
    }
    
    public Henkilo lyhin() {
        if(this.onTyhja()) {
            return null;
        }
        
        Henkilo lyhinHenkilo = this.henkilo.get(0);
        
        for (Henkilo esim : henkilo) {
            if (esim.getPituus() < lyhinHenkilo.getPituus()) {
                lyhinHenkilo = esim;
            }
        }
        return lyhinHenkilo;
        
    }
        
         
    public Henkilo ota() {
        if (this.henkilo.isEmpty()) {
            return null;
        }
        
        Henkilo lyhinHenkilo = lyhin();
        
        this.henkilo.remove(lyhinHenkilo);
        
        return lyhinHenkilo;
    } 
    
    
    
}
