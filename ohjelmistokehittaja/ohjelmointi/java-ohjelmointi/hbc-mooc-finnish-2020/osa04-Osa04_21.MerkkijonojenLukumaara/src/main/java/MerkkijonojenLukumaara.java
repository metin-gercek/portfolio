
import java.util.Scanner;

public class MerkkijonojenLukumaara {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        int indeksi = 0;

        while (true) {
            String nimi = lukija.nextLine();
            if (nimi.equals("loppu")) {
                break;
            }
            indeksi += 1;

        }
        System.out.println(indeksi);
    }
}
