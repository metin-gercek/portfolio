
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        Lukutilasto luku = new Lukutilasto();
        Lukutilasto lukuPari = new Lukutilasto();
        Lukutilasto lukuPariton = new Lukutilasto();
        System.out.println("Anna lukuja: ");
        while (true) {
            int input = Integer.valueOf(lukija.nextLine());
            if (input == -1) {
                break;
            }
            luku.lisaaLuku(input);
            if (input % 2 == 0) {
                lukuPari.lisaaLuku(input);
            } else {
                lukuPariton.lisaaLuku(input);
            }
        }
        
        System.out.println("Summa: " + luku.summa());
        System.out.println("Parillisten summa: " + lukuPari.summa());
        System.out.println("Parittomien summa: " + lukuPariton.summa());
        
        
        


        // voit tehdä testikoodia tänne
        // poista kaikki ylimääräinen koodi kuitenkin tehtävän viimeisiä osia tehdessäsi

        // Jotta testi toimisi, on oliot luotava pääohjelmassa oikeassa järjestyksessä 
        //  eli ensin kaikkien summan laskeva olio, toisena parillisten summan laskeva 
        //  ja viimeisenä parittomien summan laskeva olio)!
    }
}
