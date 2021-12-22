
import java.util.Scanner;

public class Kuutiot {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        while (true) {

            String luku = lukija.nextLine();
                if (luku.equals("loppu")) {
                    break;
                }
            int uusi = Integer.valueOf(luku)*Integer.valueOf(luku)*Integer.valueOf(luku);
            System.out.println(uusi);

        }
    }
}
