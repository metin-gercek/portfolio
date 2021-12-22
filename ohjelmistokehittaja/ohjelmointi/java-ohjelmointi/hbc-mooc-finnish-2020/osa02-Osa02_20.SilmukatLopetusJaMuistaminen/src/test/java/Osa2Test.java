
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.*;
import static org.junit.Assert.*;

@Points("02-20.2")
public class Osa2Test {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void testi() {
        int[][] syotteet = {
            {1, -1, 1},
            {2, 5, -1, 7},
            {6, 1, 4, 7, 4, 9, -1, 31}
        };

        for (int i = 0; i < syotteet.length; i++) {
            tarkasta(syotteet[i], "Summa");
        }
    }

    private void tarkasta(int[] syotteet, String mj) {
        int oldOut = io.getSysOut().length();
        io.setSysIn(stringiksi(syotteet));
        callMain(SilmukatLopetusMuistaminen.class);
        String out = io.getSysOut().substring(oldOut);
        int odotettu = tulos(syotteet);

        String virheIlm = "Syötteellä " + stringiksiValilla(syotteet)
                + " pitäisi tulostaa \"" + mj + ": " + odotettu + "\"";
        assertTrue("et tulosta mitään!", out.length() > 0);
        assertEquals(virheIlm, odotettu, otaLukuLopusta(rivi(out, mj)));
    }

    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(kl);
            String[] t = null;
            String x[] = new String[0];
            Method m = ReflectionUtils.requireMethod(kl, "main", x.getClass());
            ReflectionUtils.invokeMethod(Void.TYPE, m, null, (Object) x);
        } catch (NoSuchElementException e) {
            fail("muista lopettaa kun käyttäjä antaa syötteen -1");
        } catch (Throwable e) {
            fail("odottamaton ongelma, et kai jaa ohjelmassa nollalla?");
        }
    }

    private static int otaLukuLopusta(String inputStr) {
        String nums = inputStr.replaceAll("[^0-9]", " ");
        nums = nums.trim().replaceAll("\\s+", " ");
        assertTrue("Tulostuksessa on oltava rivi muotoa \"Summa: 3\". Varmista ettet käytä esimerkiksi desimaalilukuja summan tulostamiseen.", nums.split("\\s+").length == 1);

        String patternStr = "(?s).*?(\\d+)\\s*$";

        Matcher matcher = Pattern.compile(patternStr).matcher(inputStr);

        assertTrue("Tulostuksessa on oltava rivi muotoa \"Summa: 3\"", matcher.find());

        int luku = Integer.valueOf(matcher.group(1));
        return luku;
    }

    private String stringiksi(int[] taulukko) {
        String tuloste = "";
        for (int i = 0; i < taulukko.length - 1; i++) {
            tuloste += taulukko[i] + "\n";

        }

        return tuloste;
    }

    private String stringiksiValilla(int[] taulukko) {
        String tuloste = "";
        for (int i = 0; i < taulukko.length - 1; i++) {
            tuloste += taulukko[i] + " ";
        }

        return tuloste;
    }

    private int tulos(int[] syotteet) {
        return syotteet[syotteet.length - 1];
    }

    private String rivi(String out, String mj) {
        for (String rivi : out.split("\n")) {
            if (rivi.toLowerCase().contains(mj.toLowerCase())) {
                return rivi;
            }
        }

        fail("Ohjelmasi pitäisi tulostaa lukujen summa");
        return "";
    }
}
