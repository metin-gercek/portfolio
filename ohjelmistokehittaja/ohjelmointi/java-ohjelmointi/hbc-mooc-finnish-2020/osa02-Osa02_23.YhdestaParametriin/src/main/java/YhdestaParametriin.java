
import java.util.Scanner;

public class YhdestaParametriin {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int luku = Integer.valueOf(lukija.nextLine());
        tulostaLukuunAsti(5);
    }
    public static void tulostaLukuunAsti(int luku) {
        for (int i = 1; i<= luku;i++){
            System.out.println(i);
            
        }
    }

}
