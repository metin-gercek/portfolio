
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.lang.reflect.Field;
import java.util.Scanner;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;

public class TehtavalistaTest {

    Reflex.ClassRef<Object> klass;

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    @Points("06-10.1")
    public void onLuokkaTehtavalista() {
        Reflex.reflect("Tehtavalista").requirePublic();
    }

    @Test
    @Points("06-10.1")
    public void luokallaTehtavalistaParametritonKonstruktori() {
        Reflex.reflect("Tehtavalista").ctor().takingNoParams().requirePublic();
    }

    @Test
    @Points("06-10.1")
    public void luokallaTehtavalistaVainYksiOliomuuttuja() {
        saniteettitarkastus("Tehtavalista", 1, "yhden oliomuuttujan");
    }

    @Test
    @Points("06-10.1")
    public void tehtavalistallaHalututMetodit() {
        Reflex.reflect("Tehtavalista").method("lisaa").returningVoid().taking(String.class).requirePublic();
        Reflex.reflect("Tehtavalista").method("tulosta").returningVoid().takingNoParams().requirePublic();
        Reflex.reflect("Tehtavalista").method("poista").returningVoid().taking(int.class).requirePublic();
    }

    @Test
    @Points("06-10.1")
    public void tehtavalistanMetoditToimivatOikein() throws Throwable {
        String koodi = "Tehtavalista lista = new Tehtavalista();\n"
                + "lista.lisaa(\"lue kurssimateriaalia\");\n"
                + "lista.lisaa(\"katso uusin fool us\");\n"
                + "lista.lisaa(\"ota rennosti\");\n"
                + "lista.tulosta();\n"
                + "lista.poista(2);\n"
                + "lista.tulosta();\n"
                + "lista.lisaa(\"osta rusinoita\");\n"
                + "lista.tulosta();\n"
                + "lista.poista(1);\n"
                + "lista.poista(1);\n"
                + "lista.tulosta();";

        Object lista = Reflex.reflect("Tehtavalista").ctor().takingNoParams().withNiceError("Virhe listan luomisessa. Kokeile koodia:\n" + koodi).invoke();
        Reflex.reflect("Tehtavalista").method("lisaa").returningVoid().taking(String.class).withNiceError("Virhe lisäämisessä. Kokeile koodia:\n" + koodi).invokeOn(lista, "lue kurssimateriaalia");
        Reflex.reflect("Tehtavalista").method("lisaa").returningVoid().taking(String.class).withNiceError("Virhe lisäämisessä. Kokeile koodia:\n" + koodi).invokeOn(lista, "katso uusin fool us");
        Reflex.reflect("Tehtavalista").method("lisaa").returningVoid().taking(String.class).withNiceError("Virhe lisäämisessä. Kokeile koodia:\n" + koodi).invokeOn(lista, "ota rennosti");

        Reflex.reflect("Tehtavalista").method("tulosta").returningVoid().takingNoParams().withNiceError("Virhe tulostamisessa. Kokeile koodia:\n" + koodi).invokeOn(lista);

        String out = io.getSysOut();
        tulostuksessaOn(out, "1: lue kurssimateriaalia", koodi);
        tulostuksessaOn(out, "2: katso uusin fool us", koodi);
        tulostuksessaOn(out, "3: ota rennosti", koodi);

        assertFalse("Käytä vain ohjelman tulostuksia. Nyt ohjelma tulosti merkkijonon\n2: ota rennosti\nKohdassa, missä sitä ei odotettu.", out.contains("2: ota rennosti"));

        Reflex.reflect("Tehtavalista").method("poista").returningVoid().taking(int.class).withNiceError("Virhe poistamisessa. Kokeile koodia:\n" + koodi).invokeOn(lista, 2);

        Reflex.reflect("Tehtavalista").method("tulosta").returningVoid().takingNoParams().withNiceError("Virhe tulostamisessa. Kokeile koodia:\n" + koodi).invokeOn(lista);

        String out2 = io.getSysOut().replace(out, "");

        tulostuksessaOn(out2, "1: lue kurssimateriaalia", koodi);
        tulostuksessaOn(out2, "2: ota rennosti", koodi);
        assertFalse("Käytä vain ohjelman tulostuksia. Nyt ohjelma tulosti merkkijonon\n3: osta rusinoita\nKohdassa, missä sitä ei odotettu.", out2.contains("3: osta rusinoita"));

        Reflex.reflect("Tehtavalista").method("lisaa").returningVoid().taking(String.class).withNiceError("Virhe lisäämisessä. Kokeile koodia:\n" + koodi).invokeOn(lista, "osta rusinoita");
        Reflex.reflect("Tehtavalista").method("tulosta").returningVoid().takingNoParams().withNiceError("Virhe tulostamisessa. Kokeile koodia:\n" + koodi).invokeOn(lista);

        String out3 = io.getSysOut().replace(out, "");
        out3 = out3.replace(out2, "");

        tulostuksessaOn(out3, "3: osta rusinoita", koodi);
        assertFalse("Käytä vain ohjelman tulostuksia. Nyt ohjelma tulosti merkkijonon\n1: osta rusinoita\nKohdassa, missä sitä ei odotettu.", out3.contains("1: osta rusinoita"));
        assertFalse("Käytä vain ohjelman tulostuksia. Nyt ohjelma tulosti merkkijonon\n2: osta rusinoita\nKohdassa, missä sitä ei odotettu.", out3.contains("2: osta rusinoita"));

        Reflex.reflect("Tehtavalista").method("poista").returningVoid().taking(int.class).withNiceError("Virhe poistamisessa. Kokeile koodia:\n" + koodi).invokeOn(lista, 1);
        Reflex.reflect("Tehtavalista").method("poista").returningVoid().taking(int.class).withNiceError("Virhe poistamisessa. Kokeile koodia:\n" + koodi).invokeOn(lista, 1);

        Reflex.reflect("Tehtavalista").method("tulosta").returningVoid().takingNoParams().withNiceError("Virhe tulostamisessa. Kokeile koodia:\n" + koodi).invokeOn(lista);
        String out4 = io.getSysOut().replace(out, "");
        out4 = out4.replace(out2, "");
        out4 = out4.replace(out3, "");

        tulostuksessaOn(out4, "1: osta rusinoita", koodi);
        assertFalse("Käytä vain ohjelman tulostuksia. Nyt ohjelma tulosti merkkijonon\n2: osta rusinoita\nKohdassa, missä sitä ei odotettu.", out4.contains("2: osta rusinoita"));
        assertFalse("Käytä vain ohjelman tulostuksia. Nyt ohjelma tulosti merkkijonon\n3: osta rusinoita\nKohdassa, missä sitä ei odotettu.", out4.contains("3: osta rusinoita"));
    }

    @Test
    @Points("06-10.2")
    public void onLuokkaKayttoliittyma() {
        Reflex.reflect("Kayttoliittyma").requirePublic();
    }

    @Test
    @Points("06-10.2")
    public void luokallaKayttoliittymaKaksiParametrinenKonstruktori() {
        Reflex.reflect("Kayttoliittyma").ctor().taking(Reflex.reflect("Tehtavalista").cls(), Scanner.class).requirePublic();
    }

    @Test
    @Points("06-10.2")
    public void luokallaKayttoliittymaMetodiKaynnista() {
        Reflex.reflect("Kayttoliittyma").method("kaynnista").returningVoid().takingNoParams().requirePublic();
    }

    @Test
    @Points("06-10.2")
    public void luokallaKayttoliittymaKaksiOliomuuttujaa() {
        saniteettitarkastus("Kayttoliittyma", 2, "oliomuuttujat Scanner ja Tehtavalista");
    }

    @Test
    @Points("06-10.2")
    public void testaaLopetus() throws Throwable {
        String koodi = "Tehtavalista lista = new Tehtavalista();\n"
                + "Scanner lukija = new Scanner(System.in);\n"
                + "\n"
                + "Kayttoliittyma liittyma = new Kayttoliittyma(lista, lukija);\n"
                + "liittyma.kaynnista();";

        String komennot = "lopeta\n";

        Object lista = Reflex.reflect("Tehtavalista").ctor().takingNoParams().withNiceError("Virhe listan luomisessa. Kokeile koodia:\n" + koodi).invoke();
        Scanner lukija = new Scanner(komennot);
        Object kali = Reflex.reflect("Kayttoliittyma").ctor().taking(Reflex.reflect("Tehtavalista").cls(), Scanner.class).withNiceError("Virhe kayttoliittyman luomisessa. Kokeile koodia:\n" + koodi).invoke(lista, lukija);

        Reflex.reflect("Kayttoliittyma").method("kaynnista").returningVoid().takingNoParams().withNiceError("Virhe käyttöliittymän käynnistämisessä. Kokeile koodia:\n" + koodi + "\nSyötteellä:\n" + komennot).invokeOn(kali);
    }

    @Test
    @Points("06-10.2")
    public void testaaKomentoLisaa() throws Throwable {
        String koodi = "Tehtavalista lista = new Tehtavalista();\n"
                + "Scanner lukija = new Scanner(System.in);\n"
                + "\n"
                + "Kayttoliittyma liittyma = new Kayttoliittyma(lista, lukija);\n"
                + "liittyma.kaynnista();";

        String komennot = "lisaa\nkatso kurssit\nlisaa\nilmoittaudu kursseille\nlopeta\n";

        Object lista = Reflex.reflect("Tehtavalista").ctor().takingNoParams().withNiceError("Virhe listan luomisessa. Kokeile koodia:\n" + koodi).invoke();
        Scanner lukija = new Scanner(komennot);
        Object kali = Reflex.reflect("Kayttoliittyma").ctor().taking(Reflex.reflect("Tehtavalista").cls(), Scanner.class).withNiceError("Virhe kayttoliittyman luomisessa. Kokeile koodia:\n" + koodi).invoke(lista, lukija);

        Reflex.reflect("Kayttoliittyma").method("kaynnista").returningVoid().takingNoParams().withNiceError("Virhe käyttöliittymän käynnistämisessä. Kokeile koodia:\n" + koodi + "\nSyötteellä:\n" + komennot).invokeOn(kali);

        String out = io.getSysOut();
        assertFalse("Kun komennot ovat:\n" + komennot + "\nJa suoritettu koodi on:\n" + koodi + "\nEi ohjelman tule tulostaa lisättyjä tehtäviä.", out.contains("katso kurssit") || out.contains("ilmoittaudu kursseille"));

        koodi += "\nlista.tulosta();";

        Reflex.reflect("Tehtavalista").method("tulosta").returningVoid().takingNoParams().withNiceError("Virhe tulostamisessa. Kokeile syötteellä:\n" + komennot + "\n\nkoodia:\n" + koodi).invokeOn(lista);

        out = io.getSysOut().replace("out", "");

        tulostuksessaOn(out, "1: katso kurssit", koodi + "\nja komentoja:\n" + komennot);
        tulostuksessaOn(out, "2: ilmoittaudu kursseille", koodi + "\nja komentoja:\n" + komennot);
    }

    @Test
    @Points("06-10.2")
    public void testaaKomentoListaa() throws Throwable {
        String koodi = "Tehtavalista lista = new Tehtavalista();\n"
                + "lista.lisaa(\"eka\");\n"
                + "lista.lisaa(\"toka\");\n"
                + "Scanner lukija = new Scanner(System.in);\n"
                + "\n"
                + "Kayttoliittyma liittyma = new Kayttoliittyma(lista, lukija);\n"
                + "liittyma.kaynnista();";

        String komennot = "listaa\nlopeta\n";

        Object lista = Reflex.reflect("Tehtavalista").ctor().takingNoParams().withNiceError("Virhe listan luomisessa. Kokeile koodia:\n" + koodi).invoke();
        Reflex.reflect("Tehtavalista").method("lisaa").returningVoid().taking(String.class).withNiceError("Virhe listalle lisäämisessä. Kokeile koodia:\n" + koodi).invokeOn(lista, "eka");
        Reflex.reflect("Tehtavalista").method("lisaa").returningVoid().taking(String.class).withNiceError("Virhe listalle lisäämisessä. Kokeile koodia:\n" + koodi).invokeOn(lista, "toka");

        Scanner lukija = new Scanner(komennot);
        Object kali = Reflex.reflect("Kayttoliittyma").ctor().taking(Reflex.reflect("Tehtavalista").cls(), Scanner.class).withNiceError("Virhe kayttoliittyman luomisessa. Kokeile koodia:\n" + koodi).invoke(lista, lukija);

        Reflex.reflect("Kayttoliittyma").method("kaynnista").returningVoid().takingNoParams().withNiceError("Virhe käyttöliittymän käynnistämisessä. Kokeile koodia:\n" + koodi + "\nSyötteellä:\n" + komennot).invokeOn(kali);

        String out = io.getSysOut();

        tulostuksessaOn(out, "1: eka", koodi + "\nja komennot ovat:\n" + komennot);
        tulostuksessaOn(out, "2: toka", koodi + "\nja komennot ovat:\n" + komennot);
    }

    @Test
    @Points("06-10.2")
    public void testaaKomentoPoista() throws Throwable {
        String koodi = "Tehtavalista lista = new Tehtavalista();\n"
                + "lista.lisaa(\"yksi\");\n"
                + "lista.lisaa(\"kaksi\");\n"
                + "lista.lisaa(\"kolme\");\n"
                + "Scanner lukija = new Scanner(System.in);\n"
                + "\n"
                + "Kayttoliittyma liittyma = new Kayttoliittyma(lista, lukija);\n"
                + "liittyma.kaynnista();";

        String komennot = "poista\n2\nlopeta\n";

        Object lista = Reflex.reflect("Tehtavalista").ctor().takingNoParams().withNiceError("Virhe listan luomisessa. Kokeile koodia:\n" + koodi).invoke();
        Reflex.reflect("Tehtavalista").method("lisaa").returningVoid().taking(String.class).withNiceError("Virhe listalle lisäämisessä. Kokeile koodia:\n" + koodi).invokeOn(lista, "yksi");
        Reflex.reflect("Tehtavalista").method("lisaa").returningVoid().taking(String.class).withNiceError("Virhe listalle lisäämisessä. Kokeile koodia:\n" + koodi).invokeOn(lista, "kaksi");
        Reflex.reflect("Tehtavalista").method("lisaa").returningVoid().taking(String.class).withNiceError("Virhe listalle lisäämisessä. Kokeile koodia:\n" + koodi).invokeOn(lista, "kolme");

        Scanner lukija = new Scanner(komennot);
        Object kali = Reflex.reflect("Kayttoliittyma").ctor().taking(Reflex.reflect("Tehtavalista").cls(), Scanner.class).withNiceError("Virhe kayttoliittyman luomisessa. Kokeile koodia:\n" + koodi).invoke(lista, lukija);

        Reflex.reflect("Kayttoliittyma").method("kaynnista").returningVoid().takingNoParams().withNiceError("Virhe käyttöliittymän käynnistämisessä. Kokeile koodia:\n" + koodi + "\nSyötteellä:\n" + komennot).invokeOn(kali);

        koodi += "\nlista.tulosta();";

        Reflex.reflect("Tehtavalista").method("tulosta").returningVoid().takingNoParams().withNiceError("Virhe tulostamisessa. Kokeile syötteellä:\n" + komennot + "\n\nkoodia:\n" + koodi).invokeOn(lista);

        String out = io.getSysOut();

        tulostuksessaOn(out, "1: yksi", koodi + "\nja komennot ovat:\n" + komennot);
        tulostuksessaOn(out, "2: kolme", koodi + "\nja komennot ovat:\n" + komennot);
    }
    
    @Test
    @Points("06-10.2")
    public void testaaKomentoPoista2() throws Throwable {
        String koodi = "Tehtavalista lista = new Tehtavalista();\n"
                + "lista.lisaa(\"yksi\");\n"
                + "lista.lisaa(\"kaksi\");\n"
                + "lista.lisaa(\"kolme\");\n"
                + "Scanner lukija = new Scanner(System.in);\n"
                + "\n"
                + "Kayttoliittyma liittyma = new Kayttoliittyma(lista, lukija);\n"
                + "liittyma.kaynnista();";

        String komennot = "poista\n1\nlopeta\n";

        Object lista = Reflex.reflect("Tehtavalista").ctor().takingNoParams().withNiceError("Virhe listan luomisessa. Kokeile koodia:\n" + koodi).invoke();
        Reflex.reflect("Tehtavalista").method("lisaa").returningVoid().taking(String.class).withNiceError("Virhe listalle lisäämisessä. Kokeile koodia:\n" + koodi).invokeOn(lista, "yksi");
        Reflex.reflect("Tehtavalista").method("lisaa").returningVoid().taking(String.class).withNiceError("Virhe listalle lisäämisessä. Kokeile koodia:\n" + koodi).invokeOn(lista, "kaksi");
        Reflex.reflect("Tehtavalista").method("lisaa").returningVoid().taking(String.class).withNiceError("Virhe listalle lisäämisessä. Kokeile koodia:\n" + koodi).invokeOn(lista, "kolme");

        Scanner lukija = new Scanner(komennot);
        Object kali = Reflex.reflect("Kayttoliittyma").ctor().taking(Reflex.reflect("Tehtavalista").cls(), Scanner.class).withNiceError("Virhe kayttoliittyman luomisessa. Kokeile koodia:\n" + koodi).invoke(lista, lukija);

        Reflex.reflect("Kayttoliittyma").method("kaynnista").returningVoid().takingNoParams().withNiceError("Virhe käyttöliittymän käynnistämisessä. Kokeile koodia:\n" + koodi + "\nSyötteellä:\n" + komennot).invokeOn(kali);

        koodi += "\nlista.tulosta();";

        Reflex.reflect("Tehtavalista").method("tulosta").returningVoid().takingNoParams().withNiceError("Virhe tulostamisessa. Kokeile syötteellä:\n" + komennot + "\n\nkoodia:\n" + koodi).invokeOn(lista);

        String out = io.getSysOut();

        tulostuksessaOn(out, "1: kaksi", koodi + "\nja komennot ovat:\n" + komennot);
        tulostuksessaOn(out, "2: kolme", koodi + "\nja komennot ovat:\n" + komennot);
    }

    private void tulostuksessaOn(String tulostus, String merkkijono, String koodi) {
        assertTrue("Odotettiin, että tulostuksessa olisi merkkijono:\n"
                + merkkijono + "\n"
                + "Kokeile koodia: " + koodi, tulostus.contains(merkkijono));
    }

    private void saniteettitarkastus(String klassName, int n, String m) throws SecurityException {
        Field[] kentat = ReflectionUtils.findClass(klassName).getDeclaredFields();

        for (Field field : kentat) {
            assertFalse("et tarvitse \"stattisia muuttujia\", poista luokalta " + klassName + " muuttuja " + kentta(field.toString(), klassName), field.toString().contains("static") && !field.toString().contains("final"));
            assertTrue("luokan kaikkien oliomuuttujien näkyvyyden tulee olla private, muuta luokalta " + klassName + " löytyi: " + kentta(field.toString(), klassName), field.toString().contains("private"));
        }

        if (kentat.length > 1) {
            int var = 0;
            for (Field field : kentat) {
                if (!field.toString().contains("final")) {
                    var++;
                }
            }
            assertTrue("et tarvitse " + klassName + "-luokalle kuin " + m + ", poista ylimääräiset", var <= n);
        }
    }

    private String kentta(String toString, String klassName) {
        return toString.replace(klassName + ".", "").replace("java.lang.", "").replace("java.util.", "");
    }
}
