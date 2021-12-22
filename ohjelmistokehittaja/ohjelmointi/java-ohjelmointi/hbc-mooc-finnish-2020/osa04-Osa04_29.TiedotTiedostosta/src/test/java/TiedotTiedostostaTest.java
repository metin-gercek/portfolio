
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

@Points("04-29")
public class TiedotTiedostostaTest {

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
        io.setSysIn(tiedosto + "\n");

        String out = io.getSysOut();

        try {
            TiedotTiedostosta.main(new String[]{});
        } catch (Exception e) {
            fail("Ohjelman suorituksessa tapahtui virhe: " + e.getMessage());
        } finally {
            poista(tiedosto);
        }

        out = io.getSysOut().replace(out, "");

        String syote = "";
        for (String osa : data) {
            syote = syote + osa + "\n";
        }

        for (String osa : data) {
            String[] palat = osa.split(",");
            String nimi = palat[0];
            int ika = Integer.valueOf(palat[1]);

            if (ika == 1) {
                long hits = rivit(out).stream().filter(r -> r.contains(nimi) && r.contains(ika + " vuosi")).count();
                assertTrue("Kun syöte on:\n" + syote + "tulostuksessa tulee esiintyä rivi:\n" + nimi + ", ikä: " + ika + " vuosi\nNyt tulostus oli:\n" + out, hits == 1);
            } else {
                long hits = rivit(out).stream().filter(r -> r.contains(nimi) && r.contains(ika + " vuotta")).count();
                assertTrue("Kun syöte on:\n" + syote + "tulostuksessa tulee esiintyä rivi:\n" + nimi + ", ikä: " + ika + " vuotta\nNyt tulostus oli:\n" + out, hits == 1);
            }
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
