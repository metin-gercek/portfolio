
public class TulosteluaLikeABoss {

    public static void tulostaTahtia(int maara) {
        for (int i = 1; i <= maara; i ++) {
            System.out.print("*");
        }
        System.out.print("\n");
    }

    public static void tulostaTyhjaa(int maara) {
        
        int i = 0;
        while (i < maara) {
            System.out.print(" ");
            i++;
        }

       
    }

    public static void tulostaKolmio(int koko) {
        int i = 1;
        while (i<= koko){
            tulostaTyhjaa(koko-i);
            tulostaTahtia(i);
            i++;
            
        }
    }

    public static void jouluKuusi(int korkeus) {
        int i = 1;
        while (i <= korkeus){
            tulostaTyhjaa(korkeus - i);
            tulostaTahtia(i+(i-1));
            i++;
        }
        tulostaTyhjaa(korkeus - 2);
        tulostaTahtia(3);
        tulostaTyhjaa(korkeus - 2);
        tulostaTahtia(3);

    }

    public static void main(String[] args) {
        // Testit eivät katso main-metodia, voit muutella tätä vapaasti.

        tulostaKolmio(5);
        System.out.println("---");
        jouluKuusi(4);
        System.out.println("---");
        jouluKuusi(10);
    }
}
