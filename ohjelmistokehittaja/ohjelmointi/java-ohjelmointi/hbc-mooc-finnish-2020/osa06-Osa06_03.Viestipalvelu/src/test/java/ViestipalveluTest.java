
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class ViestipalveluTest {

    @Test
    @Points("06-03")
    public void onLuokkaViestipalvelu() throws Throwable {
        Reflex.reflect("Viestipalvelu").requirePublic();
        Reflex.reflect("Viestipalvelu").ctor().takingNoParams().requirePublic();
    }

    @Test
    @Points("06-03")
    public void luokallaViestipalveluArrayListTyyppinenOliomuuttuja() throws Throwable {
        Reflex.reflect("Viestipalvelu").requirePublic();
        Class clazz = Reflex.reflect("Viestipalvelu").cls();

        assertEquals("Luokalla Viestipalvelu tulee olla vain yksi oliomuuttuja. Nyt niitä oli: " + clazz.getDeclaredFields().length, 1, clazz.getDeclaredFields().length);
        Field f = clazz.getDeclaredFields()[0];
        assertEquals("Luokalla Viestipalvelu tulee olla oliomuuttujana ArrayList-tyyppinen olio. Nyt oliomuuttujan tyyppi oli: ", ArrayList.class, f.getType());
    }

    @Test
    @Points("06-03")
    public void onMetodiGetViestit() throws Throwable {
        Reflex.reflect("Viestipalvelu").method("getViestit").returning(ArrayList.class).takingNoParams().requirePublic();
    }

    @Test
    @Points("06-03")
    public void lisaaViestin() throws Throwable {
        Object vp = Reflex.reflect("Viestipalvelu").ctor().takingNoParams().invoke();

        String koodi = "Viestipalvelu vp = new Viestipalvelu();\nSystem.out.println(vp.getViestit());";

        ArrayList viestit = null;
        try {
            viestit = Reflex.reflect("Viestipalvelu").method("getViestit").returning(ArrayList.class).takingNoParams().invokeOn(vp);
        } catch (Throwable t) {
            fail("Virhe ohjelmaa suorittaessa. Kokeile ohjelmaasi koodilla:\n" + koodi);
        }

        assertNotNull("Viestipalvelun getViestit-metodin ei tule palauttaa null-viitettä. Kokeile ohjelmaasi koodilla:\n" + koodi, viestit);
        assertEquals("Kun viestipalveluun ei ole lisätty yhtäkään viestiä, pitäisi viestipalvelun getViestit-metodin palauttaa tyhjä lista.\nKokeile ohjelmaasi koodilla:\n" + koodi, 0, viestit.size());

        koodi += "\nViesti v = new Viesti(\"lahettaja\", \"viesti\");\nvp.lisaa(v);\nSystem.out.println(vp.getViestit());";
        Viesti v = new Viesti("lahettaja", "viesti");
        try {
            Reflex.reflect("Viestipalvelu").method("lisaa").returning(void.class).taking(Viesti.class).invokeOn(vp, v);
            viestit = Reflex.reflect("Viestipalvelu").method("getViestit").returning(ArrayList.class).takingNoParams().invokeOn(vp);
        } catch (Throwable t) {
            fail("Virhe ohjelmaa suorittaessa. Kokeile ohjelmaasi koodilla:\n" + koodi);
        }

        assertNotNull("Viestipalvelun getViestit-metodin ei tule palauttaa null-viitettä. Kokeile ohjelmaasi koodilla:\n" + koodi, viestit);
        assertEquals("Kun viestipalveluun on lisätty yksi viesti, pitäisi viestipalvelun getViestit-metodin palauttaa yhden viestin sisältävä lista.\nKokeile ohjelmaasi koodilla:\n" + koodi, 1, viestit.size());

        Viesti palautettu = (Viesti) viestit.get(0);
        assertEquals("Viestipalveluun lisätyn viestin pitäisi olla sama kuin getViestit-metodin palauttamalla listalla oleva viesti. Nyt ei ollut. Kokeile koodia:\n" + koodi, v, palautettu);
        assertNotEquals("Viesti-luokan equals-metodin toimintaa on todennäköisesti muutettu.", new Viesti("satunnainen", "jotain"), palautettu);
    }

    @Test
    @Points("06-03")
    public void hyvaksyy280MerkkiaPitkanViestin() throws Throwable {
        testaaViestinLisaaminen(280);
    }

    @Test
    @Points("06-03")
    public void eiHyvaksy281MerkkiaPitkaaViestia() throws Throwable {
        testaaViestinLisaaminen(281);
    }

    private void testaaViestinLisaaminen(int viestinPituus) throws Throwable {
        Object vp = Reflex.reflect("Viestipalvelu").ctor().takingNoParams().invoke();
        String vs = "abcdefghijklmnopqrstuvxyz";
        vs = vs + vs + vs + vs + vs + vs + vs + vs + vs + vs + vs + vs + vs + vs + vs + vs + vs + vs;
        vs = vs.substring(0, viestinPituus);

        Viesti v = new Viesti("lahettaja", vs);
        ArrayList<Viesti> viestit = null;
        try {
            Reflex.reflect("Viestipalvelu").method("lisaa").returning(void.class).taking(Viesti.class).invokeOn(vp, v);
            viestit = Reflex.reflect("Viestipalvelu").method("getViestit").returning(ArrayList.class).takingNoParams().invokeOn(vp);
        } catch (Throwable t) {
            fail("Virhe ohjelmaa suorittaessa. Kokeile luoda ohjelma, jossa listalle lisätään täsmälleen " + viestinPituus + " merkkiä sisältävä viesti.");
        }

        assertNotNull("Viestipalvelun getViestit-metodin ei tule palauttaa null-viitettä.", viestit);
        if (viestinPituus > 280) {
            assertEquals("Kun viestipalveluun on lisätty yksi " + viestinPituus + " merkkiä sisältävä viesti, pitäisi viestipalvelun getViestit-metodin palauttaa tyhjä lista.", 0, viestit.size());
            return;
        }

        assertEquals("Kun viestipalveluun on lisätty yksi " + viestinPituus + " merkkiä sisältävä viesti, pitäisi viestipalvelun getViestit-metodin palauttaa yhden viestin sisältävä lista.", 1, viestit.size());

        Viesti palautettu = (Viesti) viestit.get(0);
        assertEquals("Viestipalveluun lisätyn viestin pitäisi olla sama kuin getViestit-metodin palauttamalla listalla oleva viesti.", v, palautettu);
        assertNotEquals("Viesti-luokan equals-metodin toimintaa on todennäköisesti muutettu.", new Viesti("satunnainen", "jotain"), palautettu);
    }
}
