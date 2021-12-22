
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

@Points("04-18")
public class HenkilotiedotTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void luokkaaHenkilotietoEiMuokattu() {
        Henkilotieto tieto = new Henkilotieto("etu", "suku", "hetu");
        assertEquals("Muutit luokkaa Henkilotieto. Peru luokkaan tekemäsi muutokset.", "suku, etu (hetu)", tieto.toString());
    }

    @Test
    public void testaaSyoteEka() {
        List<Henkilotieto> henkilot = new ArrayList<>();
        henkilot.add(new Henkilotieto("Jean", "Bartik", "271224"));
        henkilot.add(new Henkilotieto("Betty", "Holberton", "070317"));

        syotaJaTarkista(henkilot);
        assertFalse("Tulostuksessa oli jotain sinne kuulumatonta.", io.getSysOut().contains("Martti"));
    }

    @Test
    public void testaaSyoteToka() {
        List<Henkilotieto> henkilot = new ArrayList<>();
        henkilot.add(new Henkilotieto("Martti", "Ahtisaari", "230637"));
        henkilot.add(new Henkilotieto("Tarja", "Halonen", "241243"));
        henkilot.add(new Henkilotieto("Urho", "Kekkonen", "030900"));

        syotaJaTarkista(henkilot);
        assertFalse("Tulostuksessa oli jotain sinne kuulumatonta.", io.getSysOut().contains("Betty"));
    }

    private void syotaJaTarkista(List<Henkilotieto> henkilot) {
        String syote = "";
        for (Henkilotieto h : henkilot) {
            syote += h.getEtunimi() + "\n" + h.getSukunimi() + "\n" + h.getHetu() + "\n";
        }
        syote += "\n";

        io.setSysIn(syote);
        callMain(Henkilotiedot.class);

        for (Henkilotieto h : henkilot) {
            assertFalse("Kun syöte on\n" + syote + "\n, ohjelman tulostuksessa ei tule esiintyä merkkijonoa \"" + h.getHetu() + "\". Tulostus oli:\n" + io.getSysOut(), io.getSysOut().contains(h.getHetu()));
        }

        for (Henkilotieto h : henkilot) {
            assertTrue("Kun syöte on\n" + syote + "\n, ohjelman tulostuksessa tulee esiintyä merkkijono \"" + h.getEtunimi() + " " + h.getSukunimi() + "\". Tulostus oli:\n" + io.getSysOut(), io.getSysOut().contains(h.getEtunimi() + " " + h.getSukunimi()));
        }

        for (Henkilotieto h : henkilot) {
            String n = h.getEtunimi() + " " + h.getSukunimi();
            assertTrue("Kun syöte on\n" + syote + "\n, merkkijonon \"" + n + "\" tulee esiintyä omalla rivillään (jolla ei ole muuta tulostetta). Tulostus oli:\n" + io.getSysOut(), rivit().contains(n));
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
