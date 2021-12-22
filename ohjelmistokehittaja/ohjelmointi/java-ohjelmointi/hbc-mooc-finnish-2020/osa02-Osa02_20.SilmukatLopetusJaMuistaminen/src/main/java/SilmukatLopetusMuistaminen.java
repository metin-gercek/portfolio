
import java.util.Scanner;

public class SilmukatLopetusMuistaminen {

    public static void main(String[] args) {
        
        Scanner lukija = new Scanner(System.in);
        
        int summa = 0;
        int laskuri = 0;
        double keskiarvo = 0;
        int parillinen = 0;
        int pariton = 0;
        
        System.out.println("Syötä luvut: ");
        while (true) {
            int luku = Integer.valueOf(lukija.nextLine());
            if (luku == -1){
                break;
            }
            if (luku % 2 ==0) {
                parillinen +=1;
            } else {
                pariton +=1;
            }
            summa += luku;
            laskuri +=1;
            keskiarvo = (double) summa / laskuri;
        }
        System.out.println("Kiitos ja näkemiin!");
        System.out.println("Summa: " + summa);
        System.out.println("Lukuja: " + laskuri);
        System.out.println("Keskiarvo: " + keskiarvo);
        System.out.println("Parillisia: " + parillinen);
        System.out.println("Parittomia: " + pariton);
    }

}

