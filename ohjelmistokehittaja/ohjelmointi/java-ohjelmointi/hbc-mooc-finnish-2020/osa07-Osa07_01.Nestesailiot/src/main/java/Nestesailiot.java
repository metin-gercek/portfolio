
import java.util.Scanner;

public class Nestesailiot {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        int eka = 0;
        int toka = 0;

        while (true) {
            System.out.print("> ");

            String luettu = lukija.nextLine();
            if (luettu.equals("lopeta")) {
                System.out.println("Ensimäinen: 0/100");
                System.out.println("Toinen: 0/100");
                break;
            }

            String[] osat = luettu.split(" ");
            String komento = osat[0];
            int maara = Integer.valueOf(osat[1]);
            
            if(komento.equals("lisaa")) {
                if (maara < 0) {
                    maara = 0;
                }
                
                if (maara > 100) {
                    maara = 100;
                }
                
                eka += maara;
                
                if (eka >100) {
                    eka = 100;
                }
                
                
            }
            if (komento.equals("siirra")) {
                if (maara < 0) {
                    maara = 0;
                }
                
                if (maara > 100) {
                    maara = 100;
                }
                
               
                
                if (maara > eka) {
                    maara = eka;
                }
                toka += maara;
                eka -= maara;
                
                if(toka > 100) {
                    toka = 100;
                }
                
            }
            
            if(komento.equals("poista")) {
                if (maara < 0) {
                    maara = 0;
                }
                
                if (maara > 100) {
                    maara = 100;
                }
                
                toka = toka - maara;
                
                if (toka < 0) {
                    toka = 0;
                }
            }
            
            System.out.println("Ensimäinen: " + eka + "/100");
            System.out.println("Toinen: " + toka + "/100");

        }
    }

}
