
import java.util.Scanner;

public class Tarina {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Kerron kohta tarinan, mutta tarvitsen siihen hieman tietoja.");
        System.out.println("Minkä niminen tarinassa esiintyvä hahmo on?");
        String ensi = lukija.nextLine();
        System.out.println("Mikä hahmon ammatti on?");
        String toka = lukija.nextLine();
        System.out.println("Tässä tarina:");
        System.out.println("Olipa kerran "+ ensi + ", joka oli ammatiltaan "+ toka + ".");
        System.out.println("Matkatessaan töihin, "+ ensi + " mietti arkeaan.");
        System.out.println("Ehkäpä "+ ensi + " ei olekaan koko elämäänsä "+ toka + ".");


    }
}
