
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Rule;
import org.junit.Test;

public class KirjatTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Points("05-14")
    @Test
    public void kahdenSamanKirjanLisays() {
        test("kirja\n1990\nkirja\n1990\n\n", 1);
    }

    @Points("05-14")
    @Test
    public void kolmenSamanKirjanLisays() {
        test("abc\n1991\nabc\n1991\nabc\n1991\n\n", 1);
    }

    @Points("05-14")
    @Test
    public void samanNimisetKirjatEriVuodella() {
        test("aapinen\n2017\naapinen\n2018\n\n", 2);
    }

    @Points("05-14")
    @Test
    public void eriNimisetKirjatSamallaVuodella() {
        test("aapinen\n2018\nbeepinen\n2018\n\n", 2);
    }

    @Points("05-14")
    @Test
    public void test1() {
        test("kirja1\n2018\nkirja2\n2018\nkirja3\n2015\nkirja4\n2015\nkirja4\n2015\nkirja5\n2018\nkirja5\n2018\n\n", 5);
    }

    private void test(String input, int odotettujaKirjoja) {
        io.setSysIn(input);

        try {
            Main.main(new String[]{});
        } catch (Throwable t) {
            fail("Ohjelman suorittaminen epäonnistui.");
        }

        String out = io.getSysOut();

        for (int i = 0; i < 10; i++) {
            if (odotettujaKirjoja == i) {
                continue;
            }

            assertFalse("Ei toivottu kirjojen lukumäärä. Kokeile ohjelmaasi syötteellä:\n" + input, out.contains("Kiitos! Kirjoja lisätty: " + i));
        }

        String odotettu = "Kiitos! Kirjoja lisätty: " + odotettujaKirjoja;
        assertTrue("Odotettiin, että tulostuksessa olisi merkkijono:\n\"" + odotettu + "\"\nNyt ei ollut. Kokeile ohjelmaasi syötteellä:\n" + input, out.contains(odotettu));
    }

}
