
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s2100631
 */
public class Kayttoliittyma {
    private Tehtavalista tehtava;
    private Scanner lukija;
    
    public Kayttoliittyma(Tehtavalista tehtava, Scanner lukija) {
        this.lukija = lukija;
        this.tehtava = tehtava;
        
    }
    
    public void kaynnista() {
        while (true) {
            System.out.print("Komento: ");
            String riivi = this.lukija.nextLine();
            
            if(riivi.equals("lopeta")) {
                break;
            }
            if(riivi.equals("lisaa")) {
                System.out.print("Lisättävä: ");
                this.tehtava.lisaa(this.lukija.nextLine());
                
                
            }
            
            if (riivi.equals("listaa")) {
                this.tehtava.tulosta();
            }
            
            if (riivi.equals("poista")) {
                System.out.print("Mikä poistetaan? ");
                this.tehtava.poista(Integer.valueOf(this.lukija.nextLine()));
            }
        }
    }
    
    
}
