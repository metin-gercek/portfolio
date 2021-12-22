
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Rule;
import org.junit.Test;

@Points("04-30")
public class HenkilotTiedostostaTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void test1() {
        test("tiedosto1.txt", "sauli,32", "tarja,30", "aaro,1", "martti,44", "lennu,0");
    }

    @Test
    public void test2() {
        test("tiedosto2.txt", "sauli,41", "tarja,9", "martti,13", "anton,42", "aamu,0", "lilja,13", "leena,41");
    }

    private void test(String tiedosto, String... data) {
        poistaJaLuo(tiedosto, data);
        
        List<Henkilo> odotettu = Arrays.stream(data).map(line -> line.split(",")).map(arr -> new Henkilo(arr[0], Integer.valueOf(arr[1]))).collect(Collectors.toList());
        List<Henkilo> todellinen = HenkilotTiedostosta.lueHenkilot(tiedosto);
        
        
        String syote = "";
        for (String osa : data) {
            syote = syote + osa + "\n";
        }
        
        assertTrue("Palautettujen henkilöiden määrä ei vastaa tiedostossa olevien henkilöiden määrää.\nKokeile metodiasi seuraavat rivit sisältävällä tiedostolla:\n" + syote, odotettu.size() == todellinen.size());

        NEXT:
        for (Henkilo o : odotettu) {
            for (Henkilo t : todellinen) {
                if(t == null || t.getNimi() == null) {
                    continue;
                }
                
                if(o.getNimi().equals(t.getNimi()) && o.getIka() == t.getIka()) {
                    continue NEXT;
                }
            }
            
            fail("Henkilölistasta ei löytynyt henkilöä, jonka nimi on " + o.getNimi() + " ja ikä on " + o.getIka() + ".\nKäytetyn tiedoston sisältö oli:\n" + syote);            
        }
        

    }

    private List<String> rivit(String out) {
        return Arrays.asList(out.split("\n")).stream().map(l -> l.trim()).filter(l -> !l.isEmpty()).collect(Collectors.toList());
    }

    private void poistaJaLuo(String tiedosto, String... rivit) {
        poista(tiedosto);

        try {
            kirjoitaTiedostoon(tiedosto, rivit);
        } catch (Exception e) {
            fail("Tiedoston " + tiedosto + " luominen epäonnistui testejä ajettaessa.\nMikäli ohjelma toimii mielestäsi oikein, palauta se palvelimelle.");
        }

    }

    private void poista(String tiedosto) {
        if (new File(tiedosto).exists()) {
            try {
                new File(tiedosto).delete();
            } catch (Exception e) {
                fail("Tiedoston " + tiedosto + " poistaminen epäonnistui testejä ajettaessa.\nMikäli ohjelma toimii mielestäsi oikein, palauta se palvelimelle.");
            }
        }
    }

    private void kirjoitaTiedostoon(String tiedosto, String[] rivit) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(new File(tiedosto))) {
            for (String rivi : rivit) {
                pw.println(rivi);
            }
            pw.flush();
        }
    }
}
