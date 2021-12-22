
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.*;
import static org.junit.Assert.*;

public class PakkaTest {

    @Test
    @Points("06-02.1")
    public void onLuokkaPakka() throws Throwable {
        Reflex.reflect("Pakka").requirePublic();
        Reflex.reflect("Pakka").ctor().takingNoParams().requirePublic();
    }

    @Test
    @Points("06-02.1")
    public void luokallaPakkaArrayListTyyppinenOliomuuttuja() throws Throwable {
        Reflex.reflect("Pakka").requirePublic();
        Class clazz = Reflex.reflect("Pakka").cls();

        assertEquals("Luokalla Pakka tulee olla vain yksi oliomuuttuja. Nyt niitä oli: " + clazz.getDeclaredFields().length, 1, clazz.getDeclaredFields().length);
        Field f = clazz.getDeclaredFields()[0];
        assertEquals("Luokalla Pakka tulee olla oliomuuttujana ArrayList-tyyppinen olio. Nyt oliomuuttujan tyyppi oli: ", ArrayList.class, f.getType());
    }

    @Test
    @Points("06-02.1")
    public void onMetodiOnTyhja() throws Throwable {
        Reflex.reflect("Pakka").method("onTyhja").returning(boolean.class).takingNoParams().requirePublic();
    }

    @Test
    @Points("06-02.1")
    public void onMetodiLisaa() throws Throwable {
        Reflex.reflect("Pakka").method("lisaa").returning(void.class).taking(String.class).requirePublic();
    }

    @Test
    @Points("06-02.1")
    public void pakkaAluksiTyhjaMuttaLisaaminenTayttaa() throws Throwable {
        Object pakka = Reflex.reflect("Pakka").ctor().takingNoParams().invoke();
        String koodi = "Pakka p = new Pakka();\nSystem.out.println(p.onTyhja());";

        boolean onTyhja = true;
        try {
            onTyhja = Reflex.reflect("Pakka").method("onTyhja").returning(boolean.class).takingNoParams().invokeOn(pakka);
        } catch (Throwable t) {
            fail("Ohjelmassa tapahtui virhe kun seuraava koodi suoritettiin:\n" + koodi);
        }

        assertTrue("Pakan tulee olla aluksi tyhjä. Kokeile koodia:\n" + koodi, onTyhja);

        koodi += "\np.lisaa(\"Hei maailma\");";
        try {
            Reflex.reflect("Pakka").method("lisaa").returning(void.class).taking(String.class).invokeOn(pakka, "Hei maailma");
        } catch (Throwable t) {
            fail("Ohjelmassa tapahtui virhe kun seuraava koodi suoritettiin:\n" + koodi);
        }

        koodi += "\np.lisaa(\"Hei maailma\");\nSystem.out.println(p.onTyhja());";
        onTyhja = true;
        try {
            onTyhja = Reflex.reflect("Pakka").method("onTyhja").returning(boolean.class).takingNoParams().invokeOn(pakka);
        } catch (Throwable t) {
            fail("Ohjelmassa tapahtui virhe kun seuraava koodi suoritettiin:\n" + koodi);
        }

        assertFalse("Kun pakkaan lisätään arvo, sen ei tule enää olla tyhjä. Kokeile koodia:\n" + koodi, onTyhja);
    }

    @Test
    @Points("06-02.1")
    public void onMetodiArvot() throws Throwable {
        Reflex.reflect("Pakka").method("arvot").returning(ArrayList.class).takingNoParams().requirePublic();
    }

    @Test
    @Points("06-02.1")
    public void arvotSisaltaaLisatytArvot() throws Throwable {
        Object pakka = Reflex.reflect("Pakka").ctor().takingNoParams().invoke();

        String koodi = "Pakka p = new Pakka();\nSystem.out.println(p.arvot());";
        ArrayList<String> arvot = null;
        try {
            arvot = Reflex.reflect("Pakka").method("arvot").returning(ArrayList.class).takingNoParams().invokeOn(pakka);
        } catch (Throwable t) {
            fail("Ohjelmassa tapahtui virhe kun seuraava koodi suoritettiin:\n" + koodi);
        }

        assertNotNull("Metodin arvot ei tule palauttaa null-viitettä. Kokeile ohjelmaasi seuraavalla koodilla:\n" + koodi, arvot);
        assertEquals("Kun pakkaan ei ole lisätty yhtäkään arvoa, ei metodin arvot palauttamalla listalla pitäisi olla yhtäkään arvoa.\nKokeile ohjelmaasi seuraavalla koodilla:\n" + koodi, 0, arvot.size());

        String lisattava = UUID.randomUUID().toString().substring(0, 6);
        koodi += "\np.lisaa(\"" + lisattava + "\");";
        try {
            Reflex.reflect("Pakka").method("lisaa").returning(void.class).taking(String.class).invokeOn(pakka, lisattava);
        } catch (Throwable t) {
            fail("Ohjelmassa tapahtui virhe kun seuraava koodi suoritettiin:\n" + koodi);
        }

        arvot = null;
        koodi += "\nSystem.out.println(p.arvot());";
        try {
            arvot = Reflex.reflect("Pakka").method("arvot").returning(ArrayList.class).takingNoParams().invokeOn(pakka);
        } catch (Throwable t) {
            fail("Ohjelmassa tapahtui virhe kun seuraava koodi suoritettiin:\n" + koodi);
        }

        assertNotNull("Metodin arvot ei tule palauttaa null-viitettä. Kokeile ohjelmaasi seuraavalla koodilla:\n" + koodi, arvot);
        assertEquals("Kun pakkaan on lisätty yksi arvo, pitäisi metodin arvot palauttamalla listalla olla yksi arvo.\nKokeile ohjelmaasi seuraavalla koodilla:\n" + koodi, 1, arvot.size());

        assertTrue("Pakkaan lisätyn arvon pitäisi löytyä arvot-metodin palauttamasta listasta. Kokeile ohjelmaasi seuraavalla koodilla:\n" + koodi, arvot.contains(lisattava));
    }

    @Test
    @Points("06-02.2")
    public void onMetodiOta() throws Throwable {
        Reflex.reflect("Pakka").method("ota").returning(String.class).takingNoParams().requirePublic();
    }

    @Test
    @Points("06-02.2")
    public void metodiOtaPalauttaaViimeisenPakkaanLisatynArvon() throws Throwable {
        Object pakka = Reflex.reflect("Pakka").ctor().takingNoParams().invoke();

        String koodi = "Pakka p = new Pakka();";

        String lisattava1 = UUID.randomUUID().toString().substring(0, 6);
        koodi += "\np.lisaa(\"" + lisattava1 + "\");";

        String lisattava2 = UUID.randomUUID().toString().substring(0, 6);
        koodi += "\np.lisaa(\"" + lisattava2 + "\");\nSystem.out.println(p.ota());";

        String otettu = null;
        try {
            Reflex.reflect("Pakka").method("lisaa").returning(void.class).taking(String.class).invokeOn(pakka, lisattava1);
            Reflex.reflect("Pakka").method("lisaa").returning(void.class).taking(String.class).invokeOn(pakka, lisattava2);
            otettu = Reflex.reflect("Pakka").method("ota").returning(String.class).takingNoParams().invokeOn(pakka);
        } catch (Throwable t) {
            fail("Virhe ohjelmaa suorittaessa. Kokeile ohjelmaasi seuraavalla koodilla: " + koodi);
        }
        
        assertEquals("Kun pakkaan lisätään ensin merkkijono \"" + lisattava1 + "\" ja sitten merkkijono \"" + lisattava2 + "\",\ntulee metodikutsun ota palauttaa merkkijono \"" + lisattava2 + "\".\nKokeile ohjelmaasi seuraavalla koodilla: " + koodi, lisattava2, otettu);
    }

    @Test
    @Points("06-02.2")
    public void otaPalauttaaViimeisenPakkaanLisatynArvon() throws Throwable {
        Object pakka = Reflex.reflect("Pakka").ctor().takingNoParams().invoke();

        String koodi = "Pakka p = new Pakka();";

        String lisattava1 = UUID.randomUUID().toString().substring(0, 6);
        koodi += "\np.lisaa(\"" + lisattava1 + "\");";

        String lisattava2 = UUID.randomUUID().toString().substring(0, 6);
        koodi += "\np.lisaa(\"" + lisattava2 + "\");\nSystem.out.println(p.ota());";

        String otettu = null;
        try {
            Reflex.reflect("Pakka").method("lisaa").returning(void.class).taking(String.class).invokeOn(pakka, lisattava1);
            Reflex.reflect("Pakka").method("lisaa").returning(void.class).taking(String.class).invokeOn(pakka, lisattava2);
            otettu = Reflex.reflect("Pakka").method("ota").returning(String.class).takingNoParams().invokeOn(pakka);
        } catch (Throwable t) {
            fail("Virhe ohjelmaa suorittaessa. Kokeile ohjelmaasi seuraavalla koodilla: " + koodi);
        }
        
        assertEquals("Kun pakkaan lisätään ensin merkkijono \"" + lisattava1 + "\" ja sitten merkkijono \"" + lisattava2 + "\",\ntulee metodikutsun ota palauttaa merkkijono \"" + lisattava2 + "\".\nKokeile ohjelmaasi seuraavalla koodilla: " + koodi, lisattava2, otettu);
    }

    @Test
    @Points("06-02.2")
    public void pakkaLopuksiTyhja() throws Throwable {
        Object pakka = Reflex.reflect("Pakka").ctor().takingNoParams().invoke();

        String koodi = "Pakka p = new Pakka();";

        String lisattava1 = UUID.randomUUID().toString().substring(0, 6);
        koodi += "\np.lisaa(\"" + lisattava1 + "\");";

        String lisattava2 = UUID.randomUUID().toString().substring(0, 6);
        koodi += "\np.lisaa(\"" + lisattava2 + "\");";

        String lisattava3 = UUID.randomUUID().toString().substring(0, 6);
        koodi += "\np.lisaa(\"" + lisattava3 + "\");\nSystem.out.println(p.ota());\nSystem.out.println(p.ota());\nSystem.out.println(p.ota());";

        String otettu1 = null;
        String otettu2 = null;
        String otettu3 = null;
        try {
            Reflex.reflect("Pakka").method("lisaa").returning(void.class).taking(String.class).invokeOn(pakka, lisattava1);
            Reflex.reflect("Pakka").method("lisaa").returning(void.class).taking(String.class).invokeOn(pakka, lisattava2);
            Reflex.reflect("Pakka").method("lisaa").returning(void.class).taking(String.class).invokeOn(pakka, lisattava3);
            otettu1 = Reflex.reflect("Pakka").method("ota").returning(String.class).takingNoParams().invokeOn(pakka);
            otettu2 = Reflex.reflect("Pakka").method("ota").returning(String.class).takingNoParams().invokeOn(pakka);
            otettu3 = Reflex.reflect("Pakka").method("ota").returning(String.class).takingNoParams().invokeOn(pakka);
        } catch (Throwable t) {
            fail("Virhe ohjelmaa suorittaessa. Kokeile ohjelmaasi seuraavalla koodilla:\n" + koodi);
        }
        
        assertTrue("Kun pakkaan lisätään merkkijonot \"" + lisattava1 + "\", \"" + lisattava2 + "\", ja \"" + lisattava3 + "\", tulee ota-metodien kutsut\nsaada merkkijonot \"" + lisattava3 + "\", \"" + lisattava2 + "\", ja \"" + lisattava1 + "\".\nKokeile ohjelmaasi seuraavalla koodilla: " + koodi, lisattava1.equals(otettu3) && lisattava2.equals(otettu2) && lisattava3.equals(otettu1));
        koodi += "\nSystem.out.println(p.onTyhja())";
        boolean onTyhja = true;
        try {
            onTyhja = Reflex.reflect("Pakka").method("onTyhja").returning(boolean.class).takingNoParams().invokeOn(pakka);
        } catch (Throwable t) {
            fail("Ohjelmassa tapahtui virhe kun seuraava koodi suoritettiin:\n" + koodi);
        } 
        
        assertTrue("Kun pakasta on otettu kaikki merkkijonot, tulee sen olla tyhjä. Kokeile ohjelmaasi seuraavalla koodilla:\n" + koodi, onTyhja);
    }

}
