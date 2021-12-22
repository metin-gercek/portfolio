
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ohjelma {

    public static void main(String[] args) {

        Vitsipankki pankki = new Vitsipankki();
        Scanner lukija = new Scanner(System.in);

        Kayttoliittyma liittyma = new Kayttoliittyma(pankki, lukija);
        liittyma.kaynnista();

    }
}
