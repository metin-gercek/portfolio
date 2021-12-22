
public class Asunto {

    private int huoneita;
    private int nelioita;
    private int neliohinta;

    public Asunto(int huoneita, int nelioita, int neliohinta) {
        this.huoneita = huoneita;
        this.nelioita = nelioita;
        this.neliohinta = neliohinta;
    }
    
    public boolean suurempi(Asunto verrattava) {
        return this.nelioita > verrattava.nelioita;
    }
    
    public int hinta() {
        return this.nelioita * this.neliohinta;
    }
    
    public int hintaero(Asunto verrattava) {
        return Math.abs(this.hinta() - verrattava.hinta());
    }
    
    public boolean kalliimpi(Asunto verrattava) {
        return this.hinta() > verrattava.hinta();
    }

}
