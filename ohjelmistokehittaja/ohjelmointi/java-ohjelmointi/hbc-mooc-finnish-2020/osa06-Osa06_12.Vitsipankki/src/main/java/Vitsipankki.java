
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s2100631
 */
public class Vitsipankki {
    private ArrayList<String> vitsit;
    
    public Vitsipankki() {
        this.vitsit = new ArrayList<>();
    }
    
    public void lisaaVitsi(String vitsi) {
        this.vitsit.add(vitsi);
    }
    
    public String arvoVitsi() {
        if (vitsit.isEmpty()) {
            return "Vitsit vähissä.";
        }
        Random arvo = new Random();
        
        int randomArvo = arvo.nextInt(vitsit.size());
        
        return vitsit.get(randomArvo);
    }
    
    public void tulostaVitsit() {
        for (String vitsi:vitsit) {
            System.out.println(vitsi);
        }
    }
}
