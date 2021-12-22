
import java.util.Scanner;

public class RajatunLukusarjanSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int summa = 0;
        System.out.println("Ensimäinen: ");
        int eka = Integer.valueOf(lukija.nextLine());
        System.out.println("Viimeinen: ");
        int viime = Integer.valueOf(lukija.nextLine());
        for (int i = eka; i <= viime; i++) {
            summa += i;
        }
        System.out.println("Summa on " + summa);

    }
}
