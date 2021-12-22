
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
public class Pakka {
    private ArrayList<String> lista;
    
    public Pakka() {
        this.lista = new ArrayList<>();
    }
    
    public boolean onTyhja() {
        
        if (this.lista.size() == 0) {
            return true;
        }
        return false;
        
    }
    
    public void lisaa(String arvo) {
        this.lista.add(arvo);
        
    }
    
    public ArrayList<String> arvot() {
        return this.lista;
    }
    
    public String ota() {
        
        int paaIndeksi = (this.lista.size() - 1);
        String paalimmain = this.lista.get(paaIndeksi);
        this.lista.remove(paaIndeksi);
        return paalimmain;
    }
}
