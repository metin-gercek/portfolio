
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.*;
import static org.junit.Assert.*;

@Points("03-09")
public class ListanSuurinLukuTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void testi() {
        int[][] syotteet = {
            {3, 6, 9, 12, 15, -1},
            {1, -1},
            {9, -1},
            {-40200, 123, 999, 999999, 9, -1},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1}
        };

        for (int[] syote : syotteet) {
            tarkista(syote);
        }
    }

    private void tarkista(int[] syoteLuvut) {
        int oldOut = io.getSysOut().length();
        String syote = "";
        int suurin = syoteLuvut[0];
        for (int luku : syoteLuvut) {
            if (luku != -1 && luku > suurin) {
                suurin = luku;
            }

            syote += luku + "\n";
        }

        io.setSysIn(syote);
        callMain(ListanSuurinLuku.class);
        String out = io.getSysOut().substring(oldOut);

        int vastaus = otaLukuLopusta(out);

        syote = syote.replaceAll("\n", " ").trim();
        String virheIlm = "Kun syötettiin luvut:\n" + syote + "\nSuurimman luvun pitäisi olla " + suurin + " tulostit \"" + vastaus + "\"";
        assertTrue("et tulosta mitään!", out.length() > 0);
        assertEquals(virheIlm, suurin, vastaus);
    }

    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(kl);
            String x[] = new String[0];
            Method m = ReflectionUtils.requireMethod(kl, "main", x.getClass());
            ReflectionUtils.invokeMethod(Void.TYPE, m, null, (Object) x);
        } catch (NoSuchElementException e) {
            fail("Varmista että kysely lopetetaan kun käyttäjä syöttää nollan.");
        } catch (Throwable e) {
            fail(kl + "-luokan public static void main(String[] args) -metodi on hävinnyt!");
        }
    }

    private static int otaLukuLopusta(String inputStr) {
        String patternStr = "(?s).*?(\\d+)\\s*$";

        Matcher matcher = Pattern.compile(patternStr).matcher(inputStr);

        assertTrue("Viimeisen rivin tulostuksen pitäisi olla muotoa \"Summa lopussa: 10\"", matcher.find());

        int luku = Integer.valueOf(matcher.group(1));
        return luku;
    }
}
