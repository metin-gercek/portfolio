
import java.util.ArrayList;

public class Arvosanarekisteri {

    private ArrayList<Integer> arvosanat;
    private ArrayList<Integer> koepistet;

    public Arvosanarekisteri() {
        this.arvosanat = new ArrayList<>();
        this.koepistet = new ArrayList<>();
    }

    public void lisaaArvosanaPisteidenPerusteella(int pisteet) {
        this.arvosanat.add(pisteetArvosanaksi(pisteet));
        this.koepistet.add(pisteet);
    }

    public int montakoSaanutArvosanan(int arvosana) {
        int lkm = 0;
        for (int saatu : this.arvosanat) {
            if (saatu == arvosana) {
                lkm++;
            }
        }

        return lkm;
    }

    public static int pisteetArvosanaksi(int pisteet) {

        int arvosana = 0;
        if (pisteet < 50) {
            arvosana = 0;
        } else if (pisteet < 60) {
            arvosana = 1;
        } else if (pisteet < 70) {
            arvosana = 2;
        } else if (pisteet < 80) {
            arvosana = 3;
        } else if (pisteet < 90) {
            arvosana = 4;
        } else {
            arvosana = 5;
        }

        return arvosana;
    }
    
    public double arvosanojenKeskiarvo() {
        int summa = 0;
        double keskiarvo = 0;
        
        
        if(arvosanat.isEmpty()) {
            keskiarvo = -1;
        } else {
            int numero = arvosanat.size();
            
            for(int arvosana: arvosanat) {
                summa += arvosana;
            }
            
            keskiarvo = (double) summa / numero;
        }
        
        return keskiarvo;
        
    }
    
    public double koepisteidenKeskiarvo() {
        int summa = 0;
        double keskiarvo = 0;
        
        if (koepistet.isEmpty()) {
            keskiarvo = -1;
        } else {
            int numero = koepistet.size();
            
            for (int koepistet: koepistet) {
                summa = summa + koepistet;
            }
            
            keskiarvo = (double) summa / numero;
        }
        
        return keskiarvo;
    }
}
