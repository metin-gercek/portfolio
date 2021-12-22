
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s2100631
 */
public class Tehtavalista {
    private ArrayList<String> tehtava;
    
    public Tehtavalista() {
        this.tehtava = new ArrayList<>();
    }
    
    public void lisaa(String tehtava) {
        this.tehtava.add(tehtava);
    }
    
    public void tulosta() {
        int indeksi = 1;
        for (String tehtava:tehtava) {
            System.out.println(indeksi + ": " + tehtava);
            indeksi++;
        }
        
    }
    
    public void poista(int numero) {
        tehtava.remove(numero - 1);
    }
    
    
}
