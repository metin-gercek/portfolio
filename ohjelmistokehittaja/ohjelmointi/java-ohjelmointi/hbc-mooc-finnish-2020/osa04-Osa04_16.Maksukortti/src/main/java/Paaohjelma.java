
import java.util.Scanner;


public class Paaohjelma {

    public static void main(String[] args) {
        Maksukortti pekanKortti = new Maksukortti(20);
        Maksukortti matinKortti = new Maksukortti(30);
        
        Scanner lukija = new Scanner(System.in);
        Maksukortti pekkaCard = new Maksukortti(20);
        Maksukortti matiCard = new Maksukortti(30);
        
        pekkaCard.syoMaukkaasti();
        matiCard.syoEdullisesti();
        
        System.out.println("Pekka: " + pekkaCard);
        System.out.println("Mati: " + matiCard);
        
        pekkaCard.lataaRahaa(20);
        matiCard.syoMaukkaasti();
        
        System.out.println("Pekka: " + pekkaCard);
        System.out.println("Mati: " + matiCard);
        
        pekkaCard.syoEdullisesti();
        pekkaCard.syoEdullisesti();
        matiCard.lataaRahaa(50);
        
        System.out.println("Pekka: " + pekkaCard);
        System.out.println("Mati: " + matiCard);
        
        
        
        // Tee tänne koodia jolla testaat että Maksukortti toimii halutulla tavalla
        // muista kuitenkin pyyhkiä ylimääräinen koodi pois tehtävän viimeisessä osassa!

    }
}
