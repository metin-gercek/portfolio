
import java.util.Scanner;

public class NegatiivistenLukujenMaara {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        int laskuri = 0;
        
        while (true) {
            System.out.println("Syötä luku");
            int luku = Integer.valueOf(lukija.nextLine());
            if (luku == 0) {
                break;
            } 
            if (luku <0) {
                laskuri = laskuri + 1;
            } 
        }
        System.out.println("Negatiivisia lukuja yhteensä " + laskuri);

    }
}
