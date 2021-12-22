
public class Ohjelma {

    public static void main(String[] args) {
        // Tämä on vain tyhjä main-metodi jossa voit kokeilla
        // Harjoitusapuri-luokkaasi

        Harjoitusapuri apuri = new Harjoitusapuri(30, 60);

        double prosenttiosuus = 0.5;

        while (prosenttiosuus < 1.0) {
            double tavoite = apuri.tavoitesyke(prosenttiosuus);
            System.out.println("Tavoite " + (prosenttiosuus * 100) + "% maksimista: " + tavoite);
            prosenttiosuus += 0.1;
        }

    }
}
