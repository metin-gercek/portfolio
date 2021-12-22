
import java.util.Scanner;

public class PositiivistenLukujenKeskiarvo {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int laskuri = 0;
        int summa = 0;
        while (true) {
            int luku = Integer.valueOf(lukija.nextLine());
            if (luku == 0) {
                break;
            } else if (luku > 0) {
                laskuri++;
                summa += luku;
            }
        }
        if (laskuri > 0) {
            System.out.println(summa / (double) laskuri);
        } else {
            System.out.println("keskiarvon laskeminen ei ole mahdollista");
        }

    }
}
