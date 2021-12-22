
public class Main {

    public static void main(String[] args) {

        // Kokeile luokkaasi täällä
        Pakka p = new Pakka();
        System.out.println(p.onTyhja());
        System.out.println(p.arvot());
        p.lisaa("Arvo");
        System.out.println(p.onTyhja());
        System.out.println(p.arvot());

    }
}
