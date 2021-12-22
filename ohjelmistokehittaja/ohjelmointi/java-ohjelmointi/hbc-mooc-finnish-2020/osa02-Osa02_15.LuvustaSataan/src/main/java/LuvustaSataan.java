
import java.util.Scanner;

public class LuvustaSataan {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        int luku = Integer.valueOf(lukija.nextLine());
        
        for(int i=luku; i < 101; i++) {
            System.out.println(i);
            
        }

    }
}
