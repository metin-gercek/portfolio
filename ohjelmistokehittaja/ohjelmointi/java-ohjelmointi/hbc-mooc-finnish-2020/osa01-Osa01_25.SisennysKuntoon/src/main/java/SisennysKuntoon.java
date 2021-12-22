
import java.util.Scanner;

public class SisennysKuntoon {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

System.out.println("Anna luku: ");
int ensimmainen = Integer.valueOf(lukija.nextLine());
System.out.println("Anna toinen luku: ");
int toinen = Integer.valueOf(lukija.nextLine());
if (ensimmainen == toinen) { System.out.println("Samat!"); }
else if (ensimmainen > toinen) { System.out.println("Ensimmäinen oli suurempi kuin toinen!"); }
else {
System.out.println("Toinen oli suurempi kuin ensimmäinen!");
}

    }
}
