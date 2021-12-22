
import java.util.ArrayList;
import java.util.Scanner;

public class Henkilotiedot {

    public static void main(String[] args) {
        // toteuta luokkaa Henkilotieto käyttävä ohjelmasi tänne

        ArrayList<Henkilotieto> Henkilotieto = new ArrayList<>();
        Scanner lukija = new Scanner(System.in);
        
        while (true) {
            System.out.print("Etunimi: ");
            String etunimi = lukija.nextLine();
            if (etunimi.isEmpty()){
                break;
            }
            System.out.print("Sukunimi: ");
            String sukunimi = lukija.nextLine();
            System.out.print("Henkilötunnus: ");
            String hetu = lukija.nextLine();
            
            Henkilotieto.add(new Henkilotieto(etunimi, sukunimi, hetu));
        }
        
        
        System.out.println("");
        for (Henkilotieto henkilotieto: Henkilotieto) {
            System.out.println(henkilotieto.getEtunimi() + " " + henkilotieto.getSukunimi());
        }

    }
}
