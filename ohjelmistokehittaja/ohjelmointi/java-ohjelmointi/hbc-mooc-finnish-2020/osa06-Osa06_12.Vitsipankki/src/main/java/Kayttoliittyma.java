
import java.util.ArrayList;
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
    private Vitsipankki vitsi;
    private Scanner lukija;
    
    public Kayttoliittyma(Vitsipankki vitsi, Scanner lukija) {
        this.vitsi = vitsi;
        this.lukija = lukija;
    }
    
    public void kaynnista() {
        System.out.println("Kirjoita lisättävä vitsi: ");
        
        while (true) {
            System.out.println("Komennot: ");
            System.out.println("1 - lisää vitsi: ");
            System.out.println("2 - arvo vitsi: ");
            System.out.println("3 - listaa vitsit: ");
            System.out.println("X - lopeta: ");
            
            String komentti = lukija.nextLine();
            
            if (komentti.equals("X")) {
                break;
            }
            
            if (komentti.equals("1")) {
                System.out.println("Kirjoita lisättävä vitsi: ");
                String vitsi = lukija.nextLine();
                this.vitsi.lisaaVitsi(vitsi);
                
                
            } else if (komentti.equals("2")) {
                System.out.println(this.vitsi.arvoVitsi());
                
            } else if (komentti.equals("3")) {
                vitsi.tulostaVitsit();
            }
            
        }
        
    }
    
}
