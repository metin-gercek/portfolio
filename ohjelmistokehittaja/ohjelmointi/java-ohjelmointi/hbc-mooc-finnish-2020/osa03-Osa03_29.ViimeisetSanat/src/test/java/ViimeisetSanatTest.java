
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import org.junit.*;
import static org.junit.Assert.*;

@Points("03-29")
public class ViimeisetSanatTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void eikaiPoikkeusta() throws Exception {
        io.setSysIn("ohjelmointi on kivaa\nihan totta\n\n");
        try {
            ViimeisetSanat.main(new String[0]);
        } catch (Exception e) {
            String v = "\n\npaina nappia show backtrace, virheen syy löytyy hieman alempaa kohdasta "
                    + "\"Caused by\"\n"
                    + "klikkaamalla pääset suoraan virheen aiheuttaneelle koodiriville";

            throw new Exception("syötteellä \"ohjelmointi on kivaa\nihan totta\n\n\"" + v, e);
        }
    }

    @Test
    public void test1() {
        String syote = "kahvakuula lavalla\nhaiku\n\n";
        io.setSysIn(syote);
        String oldOut = io.getSysOut();
        callMain(ViimeisetSanat.class);

        String out = io.getSysOut().replace(oldOut, "");
        odotaSisaltaaPalat(out, syote);
    }

    @Test
    public void test2() {
        String syote = "ohjelmointia tavalla\njava\n\n";
        io.setSysIn(syote);
        String oldOut = io.getSysOut();
        callMain(ViimeisetSanat.class);

        String out = io.getSysOut().replace(oldOut, "");
        odotaSisaltaaPalat(out, syote);
    }
    
    @Test
    public void test3() {
        String syote = "torilla\navataan tavauskokous\ntavataan tavallista tavaamista\n\n";
        io.setSysIn(syote);
        String oldOut = io.getSysOut();
        callMain(ViimeisetSanat.class);

        String out = io.getSysOut().replace(oldOut, "");
        odotaSisaltaaPalat(out, syote);
    }

    private static void odotaSisaltaaPalat(String tulostus, String syote) {
        Set<String> odotetut = new HashSet<>();
        Scanner s = new Scanner(syote);
        while (s.hasNextLine()) {
            String rivi = s.nextLine();
            if (rivi.isEmpty()) {
                continue;
            }

            String[] pts = rivi.split(" ");
            odotetut.add(pts[pts.length - 1]);
        }

        for (String rivi : tulostus.split("\n")) {
            rivi = rivi.trim();
            if (!odotetut.contains(rivi)) {
                fail("Tulostuksessa oli merkkijono " + rivi + " jota ei odotettu.\nTarkista ohjelman toiminta syötteellä:\n" + syote);
            }

            odotetut.remove(rivi);
        }

        if (!odotetut.isEmpty()) {
            ArrayList<String> odotetutLista = new ArrayList(odotetut);
            fail("Tulostuksesta puuttui merkkijono " + odotetutLista.get(0) + "\nTarkista ohjelman toiminta syötteellä:\n" + syote);
        }
    }

    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(kl);
            String[] t = null;
            String x[] = new String[0];
            Method m = ReflectionUtils.requireMethod(kl, "main", x.getClass());
            ReflectionUtils.invokeMethod(Void.TYPE, m, null, (Object) x);
        } catch (NoSuchElementException e) {
            fail("luethan syöteen käyttäjältä lukija.nextLine()-komennolla?");
        } catch (Throwable e) {
            fail("Jotain kummallista tapahtui. Saattaa olla että " + kl + "-luokan public static void main(String[] args) -metodi on hävinnyt\n"
                    + "tai ohjelmasi kaatui poikkeukseen. Lisätietoja " + e);
        }
    }
}
