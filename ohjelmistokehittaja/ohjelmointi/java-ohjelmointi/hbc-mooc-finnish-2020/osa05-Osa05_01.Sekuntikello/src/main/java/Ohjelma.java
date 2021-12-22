
import java.util.Scanner;

public class Ohjelma {

    public static void main(String[] args) {
        Sekuntikello sekuntikello = new Sekuntikello();

        while (true) {
            System.out.println(sekuntikello);
            sekuntikello.etene();

            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }
        }

    }
}
