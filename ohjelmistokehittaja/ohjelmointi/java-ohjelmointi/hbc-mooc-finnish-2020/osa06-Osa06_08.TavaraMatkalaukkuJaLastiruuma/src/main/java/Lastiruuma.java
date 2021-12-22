
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
public class Lastiruuma {
    
    private int maksimipaino;
    private ArrayList<Matkalaukku> lasti;
    
    public Lastiruuma(int maksimipaino) {
        this.lasti = new ArrayList<>();
        this.maksimipaino = maksimipaino;
    }
    
    public int yhteispaino() {
        int summa = 0;
        for (Matkalaukku matkalaukku:this.lasti) {
            summa += matkalaukku.yhteispaino();
        }
        return summa;
    }
    
    public void lisaaMatkalaukku(Matkalaukku matkalaukku) {
        if ((yhteispaino() + matkalaukku.yhteispaino()) <= maksimipaino) {
            this.lasti.add(matkalaukku);
        }
        else {
            return;
        }
        
        
        
    }
    
    public void tulostaTavarat() {
        for (Matkalaukku matkalaukku:this.lasti) {
            matkalaukku.tulostaTavarat();
            
        }
        
    }
    
    public String toString() {
        
        return this.lasti.size() + " matkalaukkua (" + yhteispaino() + " kg";
        
    }
   
    
    
}
