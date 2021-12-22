/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s2100631
 */
public class Kuutio {
    private int sarmanPituus;
    private int tilavuus;
    
    public Kuutio(int sarmanPituus) {
        this.sarmanPituus = sarmanPituus;
        this.tilavuus = tilavuus;
        
    }
    
    public int tilavuus() {
        
        this.tilavuus = sarmanPituus * sarmanPituus * sarmanPituus;
        return this.tilavuus;
    }

    @Override
    public String toString() {
        return "Kuution särmän pituus on " + this.sarmanPituus + ", tilavuus on "+ this.tilavuus();
    }
    
    
}
