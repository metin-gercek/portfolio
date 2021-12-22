
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
public class Matkalaukku {
    private ArrayList<Tavara> matkalaukku;
    private int maksimipaino;
    
    public Matkalaukku(int maksimipaino) {
        this.maksimipaino = maksimipaino;
        this.matkalaukku = new ArrayList<>();
    }
    
    public int yhteispaino () {
        int summa = 0;
        for (Tavara tavara:this.matkalaukku) {
            summa += tavara.getPaino();
        }
        return summa;
    }
    
    public void lisaaTavara(Tavara tavara) {
        if ((yhteispaino() + tavara.getPaino()) <= maksimipaino) {
            this.matkalaukku.add(tavara);
        }
        else {
            return;
        }
    }
    
    public void tulostaTavarat () {
        for(Tavara tavara:this.matkalaukku) {
            System.out.println(tavara);
        }
        
        
    }
    
    public Tavara raskainTavara() {
        if (this.matkalaukku.isEmpty()) {
            return null;
        }
        Tavara raskain = this.matkalaukku.get(0);
        
        for (Tavara tavara:matkalaukku) {
            if (tavara.getPaino() > raskain.getPaino()) {
                raskain = tavara;
            }
        }
        return raskain;
    
}
    
    public String toString() {
        if (this.matkalaukku.isEmpty()) {
            return "ei tavaroita (" + this.yhteispaino() + " kg)";
        }
        else if (this.matkalaukku.size() == 1) {
            return this.matkalaukku.size() + " tavara (" + this.yhteispaino() + " kg)";
            
        } 
        else {
            return this.matkalaukku.size() + " tavaraa (" + this.yhteispaino() + " kg)";
        }
        
        
    }
    
    
}
