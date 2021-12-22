
public class Suurin {

    public static int suurin(int luku1, int luku2, int luku3) {
        int suurin = luku1;
        if (luku2 > suurin){
            suurin = luku2;
        }
        if (luku3 >suurin) {
            suurin = luku3;
        }

        return suurin;
    }

    public static void main(String[] args) {
        int vastaus = suurin(2, 7, 3);
        System.out.println("Suurin: " + vastaus);
    }
}
