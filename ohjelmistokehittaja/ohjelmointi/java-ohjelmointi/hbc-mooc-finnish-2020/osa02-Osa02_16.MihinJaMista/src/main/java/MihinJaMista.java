
import java.util.Scanner;

public class MihinJaMista {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.print("Mihin asti?");
        int mihin = Integer.valueOf(lukija.nextLine());
        System.out.print("Mistä lähtien?");
        int mista = Integer.valueOf(lukija.nextLine());
        
        for (int i=mista; i< mihin+1; i++) {
            System.out.println(i);
        }
        
        
        
    }
}
