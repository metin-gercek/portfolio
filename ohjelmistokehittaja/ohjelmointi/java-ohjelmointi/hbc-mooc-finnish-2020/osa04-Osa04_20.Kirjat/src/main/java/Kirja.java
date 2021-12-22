/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s2100631
 */
public class Kirja {
    private String nimi;
    private int  sivuja;
    private int julkaisvuosi;
    public Kirja(String nimi, int sivuja, int julkaisvuosi) {
        this.nimi = nimi;
        this.sivuja = sivuja;
        this.julkaisvuosi = julkaisvuosi;
    
    
    }
    public String getNimi() {
        return this.nimi;
    }
    
    public int getSivuja() {
        return this.sivuja;
    }
    public int getJulkaisvuosi() {
        return this.julkaisvuosi;
    }
    
    
}
