/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s2100631
 */
public class Maksukortti {
    private double saldo;
    
    public Maksukortti (double alkusaldo) {
        this.saldo = alkusaldo;
    }
    
    public void syoEdullisesti() {
        if (this.saldo >= 2.60) {
            this.saldo = this.saldo - 2.60;
        }
        
    }
    
    public void syoMaukkaasti () {
        if (this.saldo >= 4.60) {
            this.saldo = this.saldo - 4.60;
        }
        
    }
    
    public void lataaRahaa(double rahamaara) {
        
        if (rahamaara < 0) {
            
        } else if (this.saldo + rahamaara > 150) {
            this.saldo = 150;
        } else {
            this.saldo += rahamaara;
        }
        
        
    }
    @Override
    public String toString() {
        return "Kortilla on rahaa " + this.saldo + " euroa";
    }
    
}
