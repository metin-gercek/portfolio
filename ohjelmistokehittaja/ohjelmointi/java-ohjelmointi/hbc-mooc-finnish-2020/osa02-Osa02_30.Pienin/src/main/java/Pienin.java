
public class Pienin {

    public static int pienin(int luku1, int luku2) {
        if (luku1 <= luku2){
            return luku1;
        }else {
            return luku2;
        }
        
    }

    public static void main(String[] args) {
        int vastaus = pienin(2, 7);
        System.out.println("Pienin: " + vastaus);
    }
}
