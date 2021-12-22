
import java.util.Scanner;

public class Kertoma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int summa = 1;
       
        System.out.println("Anna luku: ");
        int luku = Integer.valueOf(lukija.nextLine());
        if (luku ==0) {
            System.out.println("Kertoma on: 1");
        }
        
        for (int i=1; i<=luku; i++){
            summa = summa * i;
        }
        System.out.println("Kertoma on "+ summa);


    }
}
