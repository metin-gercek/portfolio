
public class Ohjelma {

    public static void main(String[] args) {
        // tee tänne testikoodia
        Laskuri testi = new Laskuri();
        testi.vahenna();
        System.out.println(testi.arvo());
        
        testi.lisaa();
        System.out.println(testi.arvo());
        
        testi.lisaa(16);
        System.out.println(testi.arvo());
        
        testi.vahenna(3);
        System.out.println(testi.arvo());
    }
}
