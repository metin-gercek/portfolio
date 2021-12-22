
import java.util.Scanner;

public class NestesailiotOlioilla {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        Sailio eka = new Sailio();
        Sailio toka = new Sailio();
        


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
            
            if (komento.equals("lisaa")) {
                eka.lisaa(maara);
            }
            
            if (komento.equals("siirra")) {
                if (eka.sisalto() >= maara) {
                    toka.lisaa(maara);
                    eka.poista(maara);
                } else {
                    toka.lisaa(eka.sisalto());
                    eka.poista(eka.sisalto());
                }
            }
            
            if (komento.equals("poista")) {
                toka.poista(maara);
            }
            
            System.out.println("Ensimäinen: " + eka.toString());
            System.out.println("Toinen: " + toka.toString());

        }
    }

}
