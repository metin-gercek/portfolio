
import java.util.Scanner;

public class MuuttujienLukeminenYhdessa {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Syötä merkkijono!");
        String merkkijono = lukija.nextLine();
        System.out.println("Syötä kokonaisluku!");
        int kokonaisluku = Integer.valueOf(lukija.nextLine());
        System.out.println("Syötä liukuluku!");
        double liukuluku = Double.valueOf(lukija.nextLine());
        System.out.println("Syötä totuusarvo!");
        boolean totuusarvo = Boolean.valueOf(lukija.nextLine());
        System.out.println("Syötit merkkijonon "+ merkkijono);
        System.out.println("Syötit kokonaisluvun " + kokonaisluku);
        System.out.println("Syötit liukuluvun " + liukuluku);
        System.out.println("Syötit totuusarvon " + totuusarvo);


    }
}
