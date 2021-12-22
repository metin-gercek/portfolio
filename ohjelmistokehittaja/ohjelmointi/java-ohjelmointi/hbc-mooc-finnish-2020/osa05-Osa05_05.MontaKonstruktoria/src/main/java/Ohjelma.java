
public class Ohjelma {

    public static void main(String[] args) {
        // tee tänne testikoodia
        Esine mitta = new Esine("Mitta");
        Esine laasti = new Esine("Laasti", "remonttitavarat");
        Esine rengas = new Esine("Rengas", 5);

        System.out.println(mitta);
        System.out.println(laasti);
        System.out.println(rengas);

        Esine e = new Esine("laastikasa", 42);
        System.out.println(e.getNimi());
        System.out.println(e.getSijainti());
        System.out.println(e.getPaino());
    }
}
