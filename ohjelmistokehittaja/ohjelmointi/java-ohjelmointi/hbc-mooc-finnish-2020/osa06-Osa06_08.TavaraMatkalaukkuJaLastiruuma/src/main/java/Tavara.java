/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s2100631
 */
public class Tavara {
    private String nimi;
    private int paino;
    
    public Tavara(String nimi, int paino) {
        this.nimi = nimi;
        this.paino = paino;
    }

    public String getNimi() {
        return nimi;
    }

    public int getPaino() {
        return paino;
    }
    public String toString() {
        return this.nimi + "(" + this.paino +" kg)";
    }
    
    
}
