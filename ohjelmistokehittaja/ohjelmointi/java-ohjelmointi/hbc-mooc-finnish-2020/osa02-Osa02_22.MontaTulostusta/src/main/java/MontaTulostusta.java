
import java.util.Scanner;

public class MontaTulostusta {

    public static void main(String[] args) {
        
        Scanner lukija = new Scanner(System.in);
        System.out.println("Kuinka monta?");
        int luku = Integer.valueOf(lukija.nextLine());
        int i = 1;
        while (i <= luku) {
            tulostaTeksti();
            i++;
        }
             
        
    }
    
    // HUOM: älä muuta metodin määrittelevää eli seuraavaa riviä!
    // (tässä tehtävässä ei ole vielä tarkoitus laittaa metodille parametria)
    public static void tulostaTeksti() {
        System.out.println("Alussa olivat suo, kuokka ja Java.");
    }
}
