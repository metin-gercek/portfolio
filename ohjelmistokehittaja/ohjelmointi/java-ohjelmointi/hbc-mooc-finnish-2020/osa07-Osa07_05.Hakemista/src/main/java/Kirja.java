
public class Kirja {

    private int id;
    private String nimi;

    public Kirja(int id, String nimi) {
        this.id = id;
        this.nimi = nimi;
    }

    public int getId() {
        return id;
    }

    public String getNimi() {
        return nimi;
    }

    @Override
    public String toString() {
        return "(id: " + id + "; nimi: " + nimi + ")";
    }

}
