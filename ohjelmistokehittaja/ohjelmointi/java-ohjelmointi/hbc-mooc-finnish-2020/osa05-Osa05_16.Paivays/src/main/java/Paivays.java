
public class Paivays {

    private int paiva;
    private int kuukausi;
    private int vuosi;

    public Paivays(int paiva, int kuukausi, int vuosi) {
        this.paiva = paiva;
        this.kuukausi = kuukausi;
        this.vuosi = vuosi;
    }
    
    public void etene() {
        this.paiva++;
        
        if (this.paiva > 30) {
            this.kuukausi++;
            this.paiva = 1;
        }
        
        if (this.kuukausi > 12) {
            this.vuosi++;
            this.kuukausi = 1;
            
        }
    }
    
    public void etene(int montakoPaivaa) {
        for (int i = 0; i < montakoPaivaa; i++) {
            this.etene();
        }
    }
    
    
    public Paivays paivienPaasta(int paivia) {
        Paivays uusiPaivays = new Paivays(this.paiva, this.kuukausi, this.vuosi);
        
        for (int i= 0; i < paivia; i++) {
            uusiPaivays.etene();
        }
        return uusiPaivays;
    }
    

    @Override
    public String toString() {
        return this.paiva + "." + this.kuukausi + "." + this.vuosi;
    }

    public boolean aiemmin(Paivays verrattava) {
        if (this.vuosi < verrattava.vuosi) {
            return true;
        }

        if (this.vuosi == verrattava.vuosi && this.kuukausi < verrattava.kuukausi) {
            return true;
        }

        if (this.vuosi == verrattava.vuosi && this.kuukausi == verrattava.kuukausi &&
                 this.paiva < verrattava.paiva) {
            return true;
        }

        return false;
    }

}
