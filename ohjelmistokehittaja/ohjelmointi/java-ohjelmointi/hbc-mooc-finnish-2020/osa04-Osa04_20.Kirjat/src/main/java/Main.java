
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // toteuta tänne toiminnallisuus, jonka avulla käyttäjä voi syöttää
        // kirjoja sekä tarkastella niitä
        
        ArrayList<Kirja> kirjat = new ArrayList<>();
        Scanner lukija = new Scanner(System.in);
        
        while (true) {
            System.out.print("Nimi: ");
            String nimi = lukija.nextLine();
            if (nimi.isEmpty()){
                break;
            }
            System.out.print("Sivuja: ");
            int sivuja = Integer.valueOf(lukija.nextLine());
            System.out.print("Julkaisvuosi: ");
            int julkaisvuosi = Integer.valueOf(lukija.nextLine());
            kirjat.add(new Kirja(nimi, sivuja, julkaisvuosi));
        }
        
        
        
        System.out.print("Mitä tulostetaan? ");
        String tulos = lukija.nextLine();
        if (tulos.equals("kaikki")) {
            for (Kirja kirja: kirjat) {
                System.out.println(kirja.getNimi()+ ", " + kirja.getSivuja() + " sivua, " + kirja.getJulkaisvuosi());
            }
        }
        if (tulos.equals("nimi")) {
            for (Kirja kirja: kirjat) {
                System.out.println(kirja.getNimi());
            }
        }
    }
}
