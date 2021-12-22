
import java.util.Scanner;

public class Tervehdys {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Mikä on nimesi?");
        String viesti = lukija.nextLine();
        System.out.println("Hei " + viesti);


    }
}
