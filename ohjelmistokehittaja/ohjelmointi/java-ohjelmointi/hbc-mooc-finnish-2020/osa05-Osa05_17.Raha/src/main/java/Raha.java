
public class Raha {

    private final int euroa;
    private final int senttia;

    public Raha(int euroa, int senttia) {

        if (senttia > 99) {
            euroa = euroa + senttia / 100;
            senttia = senttia % 100;
        }

        this.euroa = euroa;
        this.senttia = senttia;
    }

    public int eurot() {
        return this.euroa;
    }

    public int sentit() {
        return this.senttia;
    }
    
    public Raha plus(Raha lisattava) {
        Raha uusi = new Raha((this.euroa + lisattava.euroa), (this.senttia + lisattava.senttia));
        return uusi;
    }
    
    public boolean vahemman(Raha verrattava) {
        
        if (this.euroa < verrattava.euroa){
            return true;
        }
        if (this.euroa == verrattava.euroa && this.senttia < verrattava.senttia) {
            return true;
        }
        return false;
        
    }
    public Raha miinus(Raha vahentaja) {
        
        int uusiEuro = euroa -vahentaja.eurot();
        int uusiSentti = senttia - vahentaja.sentit();
                
        if(uusiSentti < 0) {
            uusiSentti = uusiSentti +100;
            uusiEuro = uusiEuro -1;
        }
        if (uusiEuro < 0) {
            uusiEuro = 0;
            uusiSentti = 0;
        }
        
        Raha uusiRaha = new Raha(uusiEuro, uusiSentti);
        return uusiRaha;
    }

    @Override
    public String toString() {
        String nolla = "";
        if (this.senttia < 10) {
            nolla = "0";
        }

        return this.euroa + "." + nolla + this.senttia + "e";
    }
    
    
    

}
