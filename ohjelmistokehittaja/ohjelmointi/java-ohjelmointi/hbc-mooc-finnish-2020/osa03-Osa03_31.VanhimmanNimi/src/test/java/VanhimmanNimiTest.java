
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import org.junit.*;
import static org.junit.Assert.*;

@Points("03-31")
public class VanhimmanNimiTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void test1() {
        String syote = "leevi,2\nlilja,1\nvenla,5\n\n";
        io.setSysIn(syote);
        String oldOut = io.getSysOut();
        callMain(VanhimmanNimi.class);

        String out = io.getSysOut().replace(oldOut, "").trim();
        assertTrue("Kun syöte oli:\n " + syote + ", odotettiin että tulostus päättyy merkkijonoon \"venla\". Nyt tulostus oli: " + out, out.endsWith("venla"));
    }

    @Test
    public void test2() {
        String syote = "gabriel,6\nleevi,2\nlilja,1\n\n";
        io.setSysIn(syote);
        String oldOut = io.getSysOut();
        callMain(VanhimmanNimi.class);

        String out = io.getSysOut().replace(oldOut, "").trim();
        assertTrue("Kun syöte oli:\n " + syote + ", odotettiin että tulostus päättyy merkkijonoon \"gabriel\". Nyt tulostus oli: " + out, out.endsWith("gabriel"));
    }

    @Test
    public void test3() {
        randomInputTest();
    }

    @Test
    public void test4() {
        randomInputTest();
    }

    private void randomInputTest() {
        Random rnd = new Random();
        String syote = "";

        Set<Integer> used = new HashSet<>();
        int vIka = -1;
        String vNimi = "";
        for (int i = 0; i < 10; i++) {
            int ika = rnd.nextInt(100);
            while (used.contains(ika)) {
                ika = rnd.nextInt(100);
            }

            String n = UUID.randomUUID().toString().substring(0, 4);
            if (ika > vIka) {
                vIka = ika;
                vNimi = n;
            }

            syote += n + "," + ika + "\n";
        }
        syote += "\n";

        io.setSysIn(syote);
        String oldOut = io.getSysOut();
        callMain(VanhimmanNimi.class);

        String out = io.getSysOut().replace(oldOut, "").trim();
        assertTrue("Kun syöte oli:\n " + syote + ", odotettiin että tulostus päättyy merkkijonoon \"" + vNimi + "\". Nyt tulostus oli: " + out, out.endsWith("" + vNimi));
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
