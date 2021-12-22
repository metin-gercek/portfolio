/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s2100631
 */
public class Sekuntikello {
    private Viisari sadaSekuntti;
    private Viisari sekuntti;
    
    public Sekuntikello() {
        this.sadaSekuntti = new Viisari(100);
        this.sekuntti = new Viisari(60);
    }
    public void etene() {
        this.sadaSekuntti.etene();
        if (this.sadaSekuntti.arvo() == 0) {
            this.sekuntti.etene();
        }
    }

    @Override
    public String toString() {
        return this.sekuntti + ":" + this.sadaSekuntti;
    }
    
    
}
