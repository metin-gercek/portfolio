
public class Kirja {

    private String nimi;
    private int julkaisuvuosi;

    public Kirja(String nimi, int julkaisuvuosi) {
        this.nimi = nimi;
        this.julkaisuvuosi = julkaisuvuosi;
    }

    public String getNimi() {
        return nimi;
    }

    public int getJulkaisuvuosi() {
        return julkaisuvuosi;
    }
    @Override
    public boolean equals(Object verrattava){
        if (this == verrattava) {
            return true;
            
        }
        if(!(verrattava instanceof Kirja)) {
            return false;
        }
        
        Kirja kirjaVerrattava = (Kirja) verrattava;
        
        if (this.nimi.equals(kirjaVerrattava.nimi) && this.julkaisuvuosi == kirjaVerrattava.julkaisuvuosi) {
        return true;
        }
        return false;
    }

   
}
