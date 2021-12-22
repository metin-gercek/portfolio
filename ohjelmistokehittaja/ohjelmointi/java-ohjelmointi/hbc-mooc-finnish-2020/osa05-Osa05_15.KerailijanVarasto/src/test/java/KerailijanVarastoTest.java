
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.fail;
import org.junit.Rule;
import org.junit.Test;

public class KerailijanVarastoTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Points("05-15.1")
    @Test
    public void yhdenEsineenLisaysJaTulostus() {
        test("tunnus\nesine5\n\n", "tunnus: esine5");
    }

    @Points("05-15.1")
    @Test
    public void kahdenEsineenLisaysJaTulostus() {
        test("tunnus\nesine\ntoinen\ntoinenEsine\n\n", "tunnus: esine", "toinen: toinenEsine");
    }

    @Points("05-15.1")
    @Test
    public void lukeminenLopetetaanJosNimiTyhja() {
        test("tunnus\nesine3\ntoinen\n\n", "tunnus: esine3");
    }

    @Points("05-15.2")
    @Test
    public void kahdenSamanEsineenTulostusSisaltaaVainYhdenEsineen() {
        test("tunnus\nesine2\ntunnus\nesine2\n\n", "tunnus: esine2");
    }

    @Points("05-15.2")
    @Test
    public void kahdenEriNimisenMuttaSamaTunnuksisenEsineenTulostusSisaltaaVainYhdenEsineen() {
        test("tunnus\nesine1\ntunnus\nesine2\n\n", "tunnus: esine1");
    }

    @Points("05-15.2")
    @Test
    public void kahdenSamanNimisenMuttaEriTunnuksisenEsineenTulostusSisaltaaKaksiEsinetta() {
        test("tunnus1\nesine\ntunnus2\nesine\n\n", "tunnus1: esine", "tunnus2: esine");
    }

    private void test(String input, String... odotettuTulostus) {
        io.setSysIn(input);

        try {
            Main.main(new String[]{});
        } catch (Throwable t) {
            fail("Ohjelman suorittaminen epäonnistui.");
        }

        List<String> rivit = new ArrayList<>();
        Arrays.stream(io.getSysOut().split("\n")).filter(r -> r.contains(":")).forEach(r -> rivit.add(r));

        if (rivit.size() != odotettuTulostus.length) {
            fail("Kun syöte oli:" + input + "tulostuksessa oli " + rivit.size() + " esinettä:\n" + rivit + "\nOdotettiin, että esineitä olisi ollut " + odotettuTulostus.length + ".\nTarkasta ohjelmasi -- varmista myös, että käytät kaksoispistettä vain esineiden tulostuksessa.");
        }

        NEXT:
        for (String odotettu : odotettuTulostus) {
            for (String rivi : rivit) {
                if (rivi.contains(odotettu)) {
                    continue NEXT;
                }
            }

            fail("Kun syöte oli:\n" + input + "\nodotettiin, että tulostuksessa olisi merkkijono:\n\"" + odotettu + "\"\nNyt ei ollut. Kokeile ohjelmaasi annetulla syötteellä.");
        }
    }

}
