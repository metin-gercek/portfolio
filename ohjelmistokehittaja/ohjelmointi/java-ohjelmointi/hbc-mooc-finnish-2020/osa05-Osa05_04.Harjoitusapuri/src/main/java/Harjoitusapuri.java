/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s2100631
 */
public class Harjoitusapuri {
    private int ika;
    private int leposyke;
    
    public Harjoitusapuri(int ika, int leposyke) {
        this.ika = ika;
        this.leposyke = leposyke;
    }
    
    public double tavoitesyke(double prosenttiaMaksimista) {
        
        double maksimisyke;
        double tavoite;
        maksimisyke = 206.3 - (0.711 * this.ika);
        tavoite = (maksimisyke - leposyke) * (prosenttiaMaksimista) + leposyke;
        return tavoite;
        
        
    }
    
}
