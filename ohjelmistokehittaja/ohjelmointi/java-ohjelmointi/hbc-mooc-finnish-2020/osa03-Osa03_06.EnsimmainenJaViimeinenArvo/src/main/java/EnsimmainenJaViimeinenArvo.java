
import java.util.ArrayList;
import java.util.Scanner;

public class EnsimmainenJaViimeinenArvo {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        ArrayList<String> lista = new ArrayList<>();
        while (true) {
            String luettu = lukija.nextLine();
            if (luettu.equals("")) {
                break;
            }

            lista.add(luettu);
        }
        System.out.println(lista.get(0));
        String viimeinen = lista.get(lista.size()-1);
        System.out.println(viimeinen);

    }
}
