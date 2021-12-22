
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import org.junit.*;
import static org.junit.Assert.*;

public class JoukonPisinTest {

    @Test
    @Points("06-06")
    public void onMetodiPisin() throws Throwable {
        Reflex.reflect(Joukko.class).method("pisin").returning(String.class).takingNoParams().requirePublic();
    }

    @Test
    @Points("06-06")
    public void palauttaaNullViitteenKunJoukkoTyhja() throws Throwable {
        Joukko j = new Joukko("testi");
        String res = Reflex.reflect(Joukko.class).method("pisin").returning(String.class).takingNoParams().invokeOn(j);
        assertNull("Metodin pisin tulee palauttaa null-viite mikäli joukko on tyhjä. Nyt metodi palautti: " + res, res);
    }

    @Test
    @Points("06-06")
    public void pisinTest1() throws Throwable {
        Joukko j = new Joukko("testi");
        j.lisaa("eka");
        j.lisaa("toka");
        j.lisaa("kolmas");
        String res = Reflex.reflect(Joukko.class).method("pisin").returning(String.class).takingNoParams().invokeOn(j);
        assertEquals("Kun joukkoon on lisätty merkkijonot \"eka\", \"toka\", ja \"kolmas\", tulee metodin pisin palauttaa merkkijono \"kolmas\". Nyt metodi palautti: " + res, "kolmas", res);
    }

    @Test
    @Points("06-06")
    public void pisinTest2() throws Throwable {
        Joukko j = new Joukko("testi");
        j.lisaa("pitka");
        j.lisaa("pidempi");
        j.lisaa("lyhyt");
        String res = Reflex.reflect(Joukko.class).method("pisin").returning(String.class).takingNoParams().invokeOn(j);
        assertEquals("Kun joukkoon on lisätty merkkijonot \"pitka\", \"pidempi\", ja \"lyhyt\", tulee metodin pisin palauttaa merkkijono \"pidempi\". Nyt metodi palautti: " + res, "pidempi", res);
    }

}
