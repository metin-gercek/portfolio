
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Kokeile sovelluksen osien yhteistoimintaa täällä

        Sanakirja kirja = new Sanakirja();
        kirja.lisaa("yksi", "one");
        kirja.lisaa("kaksi", "two");

        System.out.println(kirja.kaanna("yksi"));
        System.out.println(kirja.kaanna("kaksi"));
        System.out.println(kirja.kaanna("kolme"));
    }
}
