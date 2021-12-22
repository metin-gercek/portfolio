
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        ArrayList<Item> varasto = new ArrayList<>();
        
        while (true) {
            System.out.println("Syötä esineen tunnus, tyhjä lopettaa.");
            String tunnus = lukija.nextLine();
            
            if (tunnus.equals("")) {
                break;
            }
            
            System.out.println("Syötä esineen nimi, tyhjä lopettaa.");
            String nimi = lukija.nextLine();
            if (nimi.equals("")) {
                break;
            }
            
            Item item = new Item (tunnus, nimi);
            
            if (!(varasto.contains(item))) {
                varasto.add(new Item(tunnus, nimi));
            }
        }
        
        for (Item item:varasto) {
            System.out.println(item.toString());
        }


    }
}
