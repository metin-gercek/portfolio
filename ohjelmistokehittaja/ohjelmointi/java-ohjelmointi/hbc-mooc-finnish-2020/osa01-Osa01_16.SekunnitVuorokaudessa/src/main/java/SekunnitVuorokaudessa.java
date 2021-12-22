
import java.util.Scanner;

public class SekunnitVuorokaudessa {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Kuinka monen vuorokauden sekunnit tulostetaan?");
        int luku = Integer.valueOf(lukija.nextLine());
        int uusi = luku * 24 * 60 * 60;
        System.out.println(uusi);


    }
}
