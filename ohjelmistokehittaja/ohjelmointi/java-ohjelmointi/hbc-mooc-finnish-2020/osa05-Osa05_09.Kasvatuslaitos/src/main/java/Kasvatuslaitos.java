
public class Kasvatuslaitos {
    
    private int laskuri;


    public int punnitse(Henkilo henkilo) {
        // palautetaan parametrina annetun henkilön paino
        this.laskuri++;
        return henkilo.getPaino();
    }
    
    public void syota(Henkilo henkilo) {
        henkilo.setPaino(henkilo.getPaino()+1);
    }
    
    public int punnitukset () {
        return this.laskuri;
    }

}
