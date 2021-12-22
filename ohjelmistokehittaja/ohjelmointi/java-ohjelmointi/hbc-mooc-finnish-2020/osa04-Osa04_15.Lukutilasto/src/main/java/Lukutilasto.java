
public class Lukutilasto {
    private int lukujenMaara;
    private int summa;
    
    public Lukutilasto () {
        lukujenMaara = 0;
        summa = 0;
        
        
    }
    public void lisaaLuku (int luku) {
        summa += luku;
        lukujenMaara++;
    }
    
    public int haeLukujenMaara() {
        return this.lukujenMaara;
                
    }
    
    public int summa() {
        return this.summa;
        
    }
    
    public double keskiarvo () {
        if (this.lukujenMaara == 0) {
            return 0;
        }
        return (double) this.summa / this.lukujenMaara;
    }
}
