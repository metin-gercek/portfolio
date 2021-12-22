
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;

@Points("04-17")
public class EsineetTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void luokkaaEsineEiMuokattu() {
        Esine tieto = new Esine("testi");
        assertTrue("Muutit luokkaa Esine. Peru luokkaan tekemäsi muutokset.", tieto.toString().startsWith("testi (luotu:"));
    }

    @Test
    public void testaaSyoteEka() {
        List<Esine> esineet = new ArrayList<>();
        esineet.add(new Esine("muki"));
        esineet.add(new Esine("kippo"));

        syotaJaTarkista(esineet);
        assertFalse("Tulostuksessa oli jotain sinne kuulumatonta.", io.getSysOut().contains("puhelin"));
    }

    @Test
    public void testaaSyoteToka() {
        List<Esine> esineet = new ArrayList<>();
        esineet.add(new Esine("puhelin"));
        esineet.add(new Esine("lautanen"));
        esineet.add(new Esine("matkalippu"));

        syotaJaTarkista(esineet);
        assertFalse("Tulostuksessa oli jotain sinne kuulumatonta.", io.getSysOut().contains("kippo"));
    }

    private void syotaJaTarkista(List<Esine> esineet) {
        String syote = "";
        for (Esine e : esineet) {
            syote += e.getNimi() + "\n";
        }
        syote += "\n";

        io.setSysIn(syote);
        callMain(Esineet.class);

        for (Esine e : esineet) {
            assertTrue("Kun syöte on\n" + syote + "\n, ohjelman tulostuksessa tulee esiintyä merkkijono \"" + e.getNimi() + "\". Tulostus oli:\n" + io.getSysOut(), io.getSysOut().contains(e.getNimi()));
            assertTrue("Ohjelman tulostuksessa tulee esiintyä myös esineen luomishetki. Syöte: \n" + syote + "\nTulostus:\n" + io.getSysOut(), io.getSysOut().contains(e.getNimi() + " (luotu: "));

        }
    }

    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(kl);
            String[] t = null;
            String x[] = new String[0];
            Method m = ReflectionUtils.requireMethod(kl, "main", x.getClass());
            ReflectionUtils.invokeMethod(Void.TYPE, m, null, (Object) x);
        } catch (Throwable e) {
            fail("Jotain kummallista tapahtui. Saattaa olla että " + kl + "-luokan public static void main(String[] args) -metodi on hävinnyt\n"
                    + "tai ohjelmasi kaatui poikkeukseen. Lisätietoja " + e);
        }
    }

    private List<String> rivit() {
        return Arrays.asList(io.getSysOut().split("\n")).stream().map(l -> l.trim()).filter(l -> !l.isEmpty()).collect(Collectors.toList());
    }
}
