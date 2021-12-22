
import java.util.Scanner;

public class KolmellaJaolliset {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int luku1 = Integer.valueOf(lukija.nextLine());
        int luku2 = Integer.valueOf(lukija.nextLine());
        kolmellaJaollisetValilta(luku1,luku2);

    }
    public static void kolmellaJaollisetValilta(int alku, int loppu) {
        
        for (int i = alku; i<= loppu; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
        
    }

}
