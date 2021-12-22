
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
public class Tekstikayttoliittyma {
    private Scanner lukija;
    private Sanakirja sanakirja;
    
    public Tekstikayttoliittyma(Scanner lukija, Sanakirja sanakirja) {
        this.lukija = lukija;
        this.sanakirja = sanakirja;
        
    }
    
    public void kaynnista() {
        while (true) {
            System.out.println("Komento: ");
            String riivi = this.lukija.nextLine();
            
            if (riivi.equals("lopeta")) {
                System.out.println("Hei hei!");
                break;
            }
            
            if (riivi.equals("lisaa")) {
                
                System.out.println("Sana: ");
                String sana = this.lukija.nextLine();
                System.out.println("Käännös: ");
                String kaannos = this.lukija.nextLine();
                this.sanakirja.lisaa(sana, kaannos);
                                
            } else if (riivi.equals("hae")) {
                System.out.println("Haettava: ");
                String sana = this.lukija.nextLine();
                
                if (this.sanakirja.kaanna(sana)!= null) {
                    System.out.println(this.sanakirja.kaanna(sana));
                }
                
                System.out.println("Sanaa " + sana + " ei löydy");
                
            } else {
                System.out.println("Tuntematon komento");
            }
        }
        
    }
    
    
    
}
