
import java.util.Scanner;

public class LukusarjanSumma {

    public static void main(String[] args) {
        
        int summa = 0;
        Scanner lukija = new Scanner(System.in);
        System.out.println("Mihin asti?");
        int mihin = Integer.valueOf(lukija.nextLine());
        for (int i=1; i<=mihin; i++){
            summa += i;
        }
        System.out.println("Summa on "+ summa);

    }
}
