
import java.util.ArrayList;
import java.util.Scanner;

public class ListanKoko {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        ArrayList<String> lista = new ArrayList<>();
        int luku = 0;
        while (true) {
            String luettu = lukija.nextLine();
            if (luettu.equals("")) {
                break;
            }

            lista.add(luettu);
            luku++;
        }
        System.out.println("Yhteensä:" + luku);

    }
}
