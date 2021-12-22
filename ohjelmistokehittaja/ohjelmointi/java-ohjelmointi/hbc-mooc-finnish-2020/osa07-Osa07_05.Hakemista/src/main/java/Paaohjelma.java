
import java.util.ArrayList;
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        // Alla on ohjelma tehtävässä toteuttamiesi hakualgoritmien testaamiseen.
        Scanner lukija = new Scanner(System.in);
        ArrayList<Kirja> kirjat = new ArrayList<>();
        System.out.println("Kuinka monta kirjaa luodaan?");
        int kirjoja = Integer.valueOf(lukija.nextLine());
        for (int i = 0; i < kirjoja; i++) {
            kirjat.add(new Kirja(i, "nimi kirjalle " + i));
        }

        System.out.println("Millä tunnuksella haetaan kirjaa?");
        int haettava = Integer.valueOf(lukija.nextLine());

        System.out.println("");
        System.out.println("Haetaan peräkkäishaulla:");
        long alku = System.currentTimeMillis();
        int perakkaishakuId = perakkaishaku(kirjat, haettava);
        System.out.println("Haku kesti " + (System.currentTimeMillis() - alku) + " millisekuntia.");
        if (perakkaishakuId < 0) {
            System.out.println("Ei löytynyt.");
        } else {
            System.out.println("Löytyi! " + kirjat.get(perakkaishakuId));
        }

        System.out.println("");

        System.out.println("");
        System.out.println("Haetaan binäärihaulla:");
        alku = System.currentTimeMillis();
        int binaarihakuId = perakkaishaku(kirjat, haettava);
        System.out.println("Haku kesti " + (System.currentTimeMillis() - alku) + " millisekuntia.");
        if (binaarihakuId < 0) {
            System.out.println("Ei löytynyt.");
        } else {
            System.out.println("Löytyi! " + kirjat.get(binaarihakuId));
        }

    }

    public static int perakkaishaku(ArrayList<Kirja> kirjat, int haettavaId) {
        return -1;
    }

    public static int binaarihaku(ArrayList<Kirja> kirjat, long haettavaId) {
        return -1;
    }
}

