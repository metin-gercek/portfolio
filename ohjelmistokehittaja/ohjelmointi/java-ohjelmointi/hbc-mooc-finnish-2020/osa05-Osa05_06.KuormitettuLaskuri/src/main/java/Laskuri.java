/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s2100631
 */
public class Laskuri {
    private int arvo;
    
    public Laskuri(int alkuarvo) {
        this.arvo = alkuarvo;
        
    }
    public Laskuri() {
        this(0);
        
    }
    
    public int arvo() {
        return this.arvo;
        
    }
    
    public void lisaa(int lisays) {
        if(lisays > 0) {
            this.arvo += lisays;
        }
        
    }
    
    public void lisaa() {
        this.lisaa(1);
        
    }
    public void vahenna() {
        this.vahenna(1);
        
    }
    
    public void vahenna(int vahennys) {
        if(vahennys > 0) {
            this.arvo -= vahennys;
        
        }
   
    }
}