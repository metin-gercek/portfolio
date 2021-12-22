
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

public class UrheilutilastotTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    @Points("04-31.1")
    public void ottelut1() {
        String tiedosto = "tiedosto1.txt";
        String tiedostonSisalto = "sauli,tarja,32,34\nsauli,tarja,30,31\nmartti,aaro,1,0\naaro,sauli,3,0";
        poistaJaLuo(tiedosto, tiedostonSisalto.split("\n"));
        io.setSysIn(tiedosto + "\nsauli\n");
        
        try {
            Urheilutilastot.main(new String[]{});
        } catch (Exception e) {
            fail("Ohjelman suorituksessa tapahtui virhe: " + e.getMessage());
        } finally {
            poista(tiedosto);
        }
       
        assertTrue("Kun tiedoston sisältö on:\n" + tiedostonSisalto + "\nJa haetaan sauli:n otteluita, tulostuksessa tulee olla rivi \"Otteluita: 3\".\nNyt tulostus oli:\n" + io.getSysOut(), rivit(io.getSysOut()).stream().filter(l -> l.contains("Otteluita: 3")).count() == 1);
    }

    @Test
    @Points("04-31.1")
    public void ottelut2() {
        String tiedosto = "tiedosto1.txt";
        String tiedostonSisalto = "sauli,tarja,32,34\nsauli,tarja,30,31\nsauli,aaro,1,0\naaro,sauli,3,0";
        poistaJaLuo(tiedosto, tiedostonSisalto.split("\n"));
        io.setSysIn(tiedosto + "\nsauli\n");
        
        try {
            Urheilutilastot.main(new String[]{});
        } catch (Exception e) {
            fail("Ohjelman suorituksessa tapahtui virhe: " + e.getMessage());
        } finally {
            poista(tiedosto);
        }
       
        assertTrue("Kun tiedoston sisältö on:\n" + tiedostonSisalto + "\nJa haetaan sauli:n otteluita, tulostuksessa tulee olla rivi \"Otteluita: 4\".\nNyt tulostus oli:\n" + io.getSysOut(), rivit(io.getSysOut()).stream().filter(l -> l.contains("Otteluita: 4")).count() == 1);
    }

    @Test
    @Points("04-31.1")
    public void ottelut3() {
        String tiedosto = "tiedosto2.txt";
        String tiedostonSisalto = "sauli,tarja,32,34\nsauli,tarja,30,31\nsauli,aaro,1,0\naaro,sauli,3,0";
        poistaJaLuo(tiedosto, tiedostonSisalto.split("\n"));
        io.setSysIn(tiedosto + "\npaavo\n");
        
        try {
            Urheilutilastot.main(new String[]{});
        } catch (Exception e) {
            fail("Ohjelman suorituksessa tapahtui virhe: " + e.getMessage());
        } finally {
            poista(tiedosto);
        }
       
        assertTrue("Kun tiedoston sisältö on:\n" + tiedostonSisalto + "\nJa haetaan paavo:n otteluita, tulostuksessa tulee olla rivi \"Otteluita: 0\".\nNyt tulostus oli:\n" + io.getSysOut(), rivit(io.getSysOut()).stream().filter(l -> l.contains("Otteluita: 0")).count() == 1);
    }

    @Test
    @Points("04-31.2")
    public void voitotjatappiot1() {
        String tiedosto = "tiedosto1.txt";
        String tiedostonSisalto = "sauli,tarja,32,34\nsauli,tarja,30,31\nmartti,aaro,1,0\naaro,sauli,3,0";
        poistaJaLuo(tiedosto, tiedostonSisalto.split("\n"));
        io.setSysIn(tiedosto + "\nsauli\n");
        
        try {
            Urheilutilastot.main(new String[]{});
        } catch (Exception e) {
            fail("Ohjelman suorituksessa tapahtui virhe: " + e.getMessage());
        } finally {
            poista(tiedosto);
        }
       
        assertTrue("Kun tiedoston sisältö on:\n" + tiedostonSisalto + "\nJa haetaan sauli:n otteluita, tulostuksessa tulee olla rivi \"Voittoja: 0\".\nNyt tulostus oli:\n" + io.getSysOut(), rivit(io.getSysOut()).stream().filter(l -> l.contains("Voittoja: 0")).count() == 1);
        assertTrue("Kun tiedoston sisältö on:\n" + tiedostonSisalto + "\nJa haetaan sauli:n otteluita, tulostuksessa tulee olla rivi \"Tappioita: 3\".\nNyt tulostus oli:\n" + io.getSysOut(), rivit(io.getSysOut()).stream().filter(l -> l.contains("Tappioita: 3")).count() == 1);
    }

    @Test
    @Points("04-31.2")
    public void voitotjatappiot2() {
        String tiedosto = "tiedosto1.txt";
        String tiedostonSisalto = "sauli,tarja,32,34\nsauli,tarja,30,31\nsauli,aaro,1,0\naaro,sauli,3,0";
        poistaJaLuo(tiedosto, tiedostonSisalto.split("\n"));
        io.setSysIn(tiedosto + "\nsauli\n");
        
        try {
            Urheilutilastot.main(new String[]{});
        } catch (Exception e) {
            fail("Ohjelman suorituksessa tapahtui virhe: " + e.getMessage());
        } finally {
            poista(tiedosto);
        }
       
        assertTrue("Kun tiedoston sisältö on:\n" + tiedostonSisalto + "\nJa haetaan sauli:n otteluita, tulostuksessa tulee olla rivi \"Voittoja: 1\".\nNyt tulostus oli:\n" + io.getSysOut(), rivit(io.getSysOut()).stream().filter(l -> l.contains("Voittoja: 1")).count() == 1);
        assertTrue("Kun tiedoston sisältö on:\n" + tiedostonSisalto + "\nJa haetaan sauli:n otteluita, tulostuksessa tulee olla rivi \"Tappioita: 3\".\nNyt tulostus oli:\n" + io.getSysOut(), rivit(io.getSysOut()).stream().filter(l -> l.contains("Tappioita: 3")).count() == 1);
    }

    @Test
    @Points("04-31.2")
    public void voitotjatappiot3() {
        String tiedosto = "tiedosto1.txt";
        String tiedostonSisalto = "sauli,tarja,32,34\nsauli,tarja,30,31\nsauli,aaro,1,0\naaro,sauli,3,0";
        poistaJaLuo(tiedosto, tiedostonSisalto.split("\n"));
        io.setSysIn(tiedosto + "\npaavo\n");
        
        try {
            Urheilutilastot.main(new String[]{});
        } catch (Exception e) {
            fail("Ohjelman suorituksessa tapahtui virhe: " + e.getMessage());
        } finally {
            poista(tiedosto);
        }
       
        assertTrue("Kun tiedoston sisältö on:\n" + tiedostonSisalto + "\nJa haetaan paavo:n otteluita, tulostuksessa tulee olla rivi \"Voittoja: 0\".\nNyt tulostus oli:\n" + io.getSysOut(), rivit(io.getSysOut()).stream().filter(l -> l.contains("Voittoja: 0")).count() == 1);
        assertTrue("Kun tiedoston sisältö on:\n" + tiedostonSisalto + "\nJa haetaan paavo:n otteluita, tulostuksessa tulee olla rivi \"Tappioita: 0\".\nNyt tulostus oli:\n" + io.getSysOut(), rivit(io.getSysOut()).stream().filter(l -> l.contains("Tappioita: 0")).count() == 1);
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
