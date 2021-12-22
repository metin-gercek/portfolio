
import java.util.Scanner;

public class LukujenKeskiarvo {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        double summa = 0;
        double laskuri = 0;
        
        while (true){
            System.out.println("Syötä luku");
            int luku = Integer.valueOf(lukija.nextLine());
            if (luku == 0) {
                break;
            } else {
                summa = summa + luku;
                laskuri = laskuri + 1;
             
            }
            
        }
        double keskiarvo = summa/laskuri;
        System.out.println("Lukujen keskiarvo " + keskiarvo);


    }
}
