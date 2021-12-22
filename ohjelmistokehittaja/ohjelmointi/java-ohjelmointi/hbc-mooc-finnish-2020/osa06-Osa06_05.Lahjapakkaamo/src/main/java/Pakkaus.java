
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
public class Pakkaus {
    
    private ArrayList<Lahja> pakkaus;
    
    public Pakkaus() {
        this.pakkaus = new ArrayList<>();
    }
    
    public void lisaaLahja(Lahja lahja) {
        this.pakkaus.add(lahja);
        
    }
    
    public int yhteispaino() {
        int summa = 0;
        for (Lahja lahja:this.pakkaus) {
            summa += lahja.getPaino();
        }
        return summa;
        
    }
    
}
