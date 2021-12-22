/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s2100631
 */
public class Tehtava {
    private String nimi;
    private boolean valmis;
    public Tehtava(String nimi) {
        this.nimi = nimi;
        this.valmis = false;
        
    }
    
    public String getNimi() {
        return nimi;
    }
    
    public void setValmis(boolean valmis) {
        this.valmis = valmis;
    }
    
    public boolean onValmis() {
        return this.valmis;
    }
    
}
