
import java.util.ArrayList;


public class Tehtavienhallinta {
    private ArrayList<Tehtava> tehtavat;
    
    public Tehtavienhallinta() {
        this.tehtavat = new ArrayList<>();
    }
    
    public ArrayList<String> tehtavalista() {
        ArrayList<String> lista = new ArrayList<>();
        for (Tehtava tehtava:this.tehtavat) {
            lista.add(tehtava.getNimi());
        }
        return lista;
    }
    public void lisaa(String tehtava){
        this.tehtavat.add(new Tehtava(tehtava));
    }
    
    public boolean onTehty(String tehtava) {
        for (Tehtava teh:this.tehtavat) {
            if (teh.getNimi().equals(tehtava)) {
                return teh.onValmis();
            }
        }
        return false;
    }
    
    public void merkkaaTehdyksi(String tehtava) {
        for (Tehtava teh:this.tehtavat) {
            if (teh.getNimi().equals(tehtava)) {
                teh.setValmis(true);
            }
        }
    }

}
