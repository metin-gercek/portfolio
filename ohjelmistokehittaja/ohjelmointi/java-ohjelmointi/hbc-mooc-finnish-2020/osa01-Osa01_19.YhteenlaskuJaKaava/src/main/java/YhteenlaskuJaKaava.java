
import java.util.Scanner;

public class YhteenlaskuJaKaava {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Syötä ensimmäinen luku!");
        int eka = Integer.valueOf(lukija.nextLine());
        System.out.println("Syötä toinen luku!");
        int toka = Integer.valueOf(lukija.nextLine());
        int summa = eka + toka;
        System.out.println(eka + " + " + toka + " = "+ summa);

    }
}
