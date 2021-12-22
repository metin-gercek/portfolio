
import java.util.Scanner;

public class TotuusarvonLukeminen {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Syötä jotain!");
        Boolean luku = Boolean.valueOf(lukija.nextLine());
        System.out.println("Totta vaiko ei? " + luku);
    }
}
