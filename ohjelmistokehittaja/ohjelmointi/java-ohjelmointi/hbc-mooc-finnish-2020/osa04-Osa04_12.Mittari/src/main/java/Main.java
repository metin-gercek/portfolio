
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Tämä on vain tyhjä main-metodi jossa voit tehdä kokeiluja
        Mittari m = new Mittari();

        while (!m.taynna()) {
            System.out.println("Ei täynnä! Mitta: " + m.mitta());
            m.lisaa();
        }

        System.out.println("Täynnä! Mitta: " + m.mitta());
        m.vahenna();
        System.out.println("Ei täynnä! Mitta: " + m.mitta());

    }
}
