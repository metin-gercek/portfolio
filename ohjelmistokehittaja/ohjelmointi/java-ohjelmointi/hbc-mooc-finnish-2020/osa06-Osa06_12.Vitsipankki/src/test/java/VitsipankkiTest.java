
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.lang.reflect.Field;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class VitsipankkiTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test(timeout = 100)
    @Points("06-12.1")
    public void onLuokkaVitsipankki() {
        Reflex.reflect("Vitsipankki").requirePublic();
    }

    @Test(timeout = 100)
    @Points("06-12.1")
    public void luokallaVitsipankkiParametritonKonstruktori() {
        Reflex.reflect("Vitsipankki").ctor().takingNoParams().requirePublic();
    }

    @Test(timeout = 100)
    @Points("06-12.1")
    public void luokallaVitsipankkiVainYksiOliomuuttuja() {
        saniteettitarkastus("Vitsipankki", 1, "yhden oliomuuttujan");
    }

    @Test(timeout = 100)
    @Points("06-12.1")
    public void luokallaVitsipankkiMetodit() {
        Reflex.reflect("Vitsipankki").method("lisaaVitsi").returningVoid().taking(String.class).requirePublic();
        Reflex.reflect("Vitsipankki").method("tulostaVitsit").returningVoid().takingNoParams().requirePublic();
        Reflex.reflect("Vitsipankki").method("arvoVitsi").returning(String.class).takingNoParams().requirePublic();
    }

    @Test(timeout = 100)
    @Points("06-12.1")
    public void eiVitsejaJaArvotaan() throws Throwable {
        String koodi = "Vitsipankki pankki = new Vitsipankki();\n"
                + "System.out.println(pankki.arvoVitsi());";

        Object vitsit = Reflex.reflect("Vitsipankki").ctor().takingNoParams().withNiceError("Virhe vitsipankkia luodessa. Kokeile koodia:\n" + koodi).invoke();
        String vitsi = Reflex.reflect("Vitsipankki").method("arvoVitsi").returning(String.class).takingNoParams().withNiceError("Virhe vitsiä arvottaessa. Kokeile koodia:\n" + koodi).invokeOn(vitsit);
        assertEquals("Kun vitsipankissa ei ole yhtäkään vitsiä, metodin arvoVitsi tulisi palauttaa merkkijono \"Vitsit vähissä.\"\nKokeile koodia:\n" + koodi, "Vitsit vähissä.", vitsi);
    }

    @Test(timeout = 100)
    @Points("06-12.1")
    public void vitsiJaArvotaan() throws Throwable {
        String koodi = "Vitsipankki pankki = new Vitsipankki();\n"
                + "pankki.lisaaVitsi(\"Mikä on punaista ja tuoksuu siniselle maalille? - Punainen maali.\");\n"
                + "System.out.println(pankki.arvoVitsi());";

        Object vitsit = Reflex.reflect("Vitsipankki").ctor().takingNoParams().withNiceError("Virhe vitsipankkia luodessa. Kokeile koodia:\n" + koodi).invoke();
        Reflex.reflect("Vitsipankki").method("lisaaVitsi").returningVoid().taking(String.class).withNiceError("Virhe vitsiä lisättäessä. Kokeile koodia:\n" + koodi).invokeOn(vitsit, "Mikä on punaista ja tuoksuu siniselle maalille? - Punainen maali.");
        String vitsi = Reflex.reflect("Vitsipankki").method("arvoVitsi").returning(String.class).takingNoParams().withNiceError("Virhe vitsiä arvottaessa. Kokeile koodia:\n" + koodi).invokeOn(vitsit);
        assertEquals("Kun vitsipankissa on vitsejä, metodin arvoVitsi tulisi palauttaa joku vitseistä.\"\nKokeile koodia:\n" + koodi, "Mikä on punaista ja tuoksuu siniselle maalille? - Punainen maali.", vitsi);
    }

    @Test(timeout = 100)
    @Points("06-12.1")
    public void useampiVitsiArvotaan() throws Throwable {
        String koodi = "Vitsipankki pankki = new Vitsipankki();\n"
                + "pankki.lisaaVitsi(\"Mikä on punaista ja tuoksuu siniselle maalille? - Punainen maali.\");\n"
                + "pankki.lisaaVitsi(\"Mikä on sinistä ja tuoksuu punaiselle maalille? - Sininen maali.\");\n"
                + "System.out.println(pankki.arvoVitsi());";

        Object vitsit = Reflex.reflect("Vitsipankki").ctor().takingNoParams().withNiceError("Virhe vitsipankkia luodessa. Kokeile koodia:\n" + koodi).invoke();
        Reflex.reflect("Vitsipankki").method("lisaaVitsi").returningVoid().taking(String.class).withNiceError("Virhe vitsiä lisättäessä. Kokeile koodia:\n" + koodi).invokeOn(vitsit, "Mikä on punaista ja tuoksuu siniselle maalille? - Punainen maali.");
        Reflex.reflect("Vitsipankki").method("lisaaVitsi").returningVoid().taking(String.class).withNiceError("Virhe vitsiä lisättäessä. Kokeile koodia:\n" + koodi).invokeOn(vitsit, "Mikä on sinistä ja tuoksuu punaiselle maalille? - Sininen maali.");

        Map<String, Integer> lkmt = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            String vitsi = Reflex.reflect("Vitsipankki").method("arvoVitsi").returning(String.class).takingNoParams().withNiceError("Virhe vitsiä arvottaessa. Kokeile koodia:\n" + koodi).invokeOn(vitsit);
            lkmt.put(vitsi, lkmt.getOrDefault(vitsi, 0) + 1);
        }

        assertTrue("Kun vitsipankissa on useampi vitsi, jokaisen vitsin pitäisi tulla vitsipankista yhtä suurella todennäköisyydellä. Tarkista vitsin arpomislogiikka.\nKokeile koodia:\n" + koodi, lkmt.getOrDefault("Mikä on sinistä ja tuoksuu punaiselle maalille? - Sininen maali.", 0) >= 25);
        assertTrue("Kun vitsipankissa on useampi vitsi, jokaisen vitsin pitäisi tulla vitsipankista yhtä suurella todennäköisyydellä. Tarkista vitsin arpomislogiikka.\nKokeile koodia:\n" + koodi, lkmt.getOrDefault("Mikä on punaista ja tuoksuu siniselle maalille? - Punainen maali.", 0) >= 25);
    }

    @Test(timeout = 100)
    @Points("06-12.1")
    public void vitsienTulostus() throws Throwable {
        String koodi = "Vitsipankki pankki = new Vitsipankki();\n"
                + "pankki.lisaaVitsi(\"Why do we tell actors to break a leg? - Because every play has a cast.\");\n"
                + "pankki.lisaaVitsi(\"Have you heard about the new restaurant called Karma? It has no menu -- you get what you deserve.\");\n"
                + "pankki.tulostaVitsit();";

        Object vitsit = Reflex.reflect("Vitsipankki").ctor().takingNoParams().withNiceError("Virhe vitsipankkia luodessa. Kokeile koodia:\n" + koodi).invoke();
        Reflex.reflect("Vitsipankki").method("lisaaVitsi").returningVoid().taking(String.class).withNiceError("Virhe vitsiä lisättäessä. Kokeile koodia:\n" + koodi).invokeOn(vitsit, "Why do we tell actors to break a leg? - Because every play has a cast.");
        Reflex.reflect("Vitsipankki").method("lisaaVitsi").returningVoid().taking(String.class).withNiceError("Virhe vitsiä lisättäessä. Kokeile koodia:\n" + koodi).invokeOn(vitsit, "Have you heard about the new restaurant called Karma? It has no menu -- you get what you deserve.");
        Reflex.reflect("Vitsipankki").method("tulostaVitsit").returningVoid().takingNoParams().withNiceError("Virhe vitsejä tulostettaessa. Kokeile koodia:\n" + koodi).invokeOn(vitsit);

        assertEquals("Kun vitsit tulostetaan, kunkin vitsin tulee esiintyä tulostuksessa tasan kerran. Kokeile koodia:\n" + koodi, 1, lkmTulostuksesta("Why do we tell actors to break a leg? - Because every play has a cast."));
        assertEquals("Kun vitsit tulostetaan, kunkin vitsin tulee esiintyä tulostuksessa tasan kerran. Kokeile koodia:\n" + koodi, 1, lkmTulostuksesta("Have you heard about the new restaurant called Karma? It has no menu -- you get what you deserve."));
    }

    @Test(timeout = 100)
    @Points("06-12.2")
    public void onLuokkaKayttoliittyma() {
        Reflex.reflect("Kayttoliittyma").requirePublic();
    }

    @Test(timeout = 100)
    @Points("06-12.2")
    public void luokallaKayttoliittymaKaksiParametrinenKonstruktori() {
        Reflex.reflect("Kayttoliittyma").ctor().taking(Reflex.reflect("Vitsipankki").cls(), Scanner.class).requirePublic();
    }

    @Test(timeout = 100)
    @Points("06-12.2")
    public void luokallaKayttoliittymaMetodiKaynnista() {
        Reflex.reflect("Kayttoliittyma").method("kaynnista").returningVoid().takingNoParams().requirePublic();
    }

    @Test(timeout = 100)
    @Points("06-12.2")
    public void luokallaKayttoliittymaKaksiOliomuuttujaa() {
        saniteettitarkastus("Kayttoliittyma", 2, "oliomuuttujat Scanner ja Vitsipankki");
    }

    @Test(timeout = 100)
    @Points("06-12.2")
    public void testaaLopetus() throws Throwable {
        String koodi = "Vitsipankki vitsit = new Vitsipankki();\n"
                + "Scanner lukija = new Scanner(System.in);\n"
                + "\n"
                + "Kayttoliittyma liittyma = new Kayttoliittyma(vitsit, lukija);\n"
                + "liittyma.kaynnista();";

        String komennot = "X\n";

        Object vitsit = Reflex.reflect("Vitsipankki").ctor().takingNoParams().withNiceError("Virhe vitsipankin luomisessa. Kokeile koodia:\n" + koodi).invoke();
        Scanner lukija = new Scanner(komennot);
        Object kali = Reflex.reflect("Kayttoliittyma").ctor().taking(Reflex.reflect("Vitsipankki").cls(), Scanner.class).withNiceError("Virhe kayttoliittyman luomisessa. Kokeile koodia:\n" + koodi).invoke(vitsit, lukija);

        Reflex.reflect("Kayttoliittyma").method("kaynnista").returningVoid().takingNoParams().withNiceError("Virhe käyttöliittymän käynnistämisessä. Kokeile koodia:\n" + koodi + "\nSyötteellä:\n" + komennot).invokeOn(kali);
    }

    @Test(timeout = 100)
    @Points("06-12.2")
    public void testaaLisaysJaLopetus() throws Throwable {
        String koodi = "Vitsipankki vitsit = new Vitsipankki();\n"
                + "Scanner lukija = new Scanner(System.in);\n"
                + "\n"
                + "Kayttoliittyma liittyma = new Kayttoliittyma(vitsit, lukija);\n"
                + "liittyma.kaynnista();";

        String komennot = "1\nOpe, keksin uuden sanan! .. Noh, mikä se on ?.. Plagiarismi!\nX\n";
        Scanner lukija = new Scanner(komennot);

        Object vitsit = Reflex.reflect("Vitsipankki").ctor().takingNoParams().withNiceError("Virhe vitsipankin luomisessa. Kokeile koodia:\n" + koodi).invoke();
        Object kali = Reflex.reflect("Kayttoliittyma").ctor().taking(Reflex.reflect("Vitsipankki").cls(), Scanner.class).withNiceError("Virhe kayttoliittyman luomisessa. Kokeile koodia:\n" + koodi).invoke(vitsit, lukija);

        Reflex.reflect("Kayttoliittyma").method("kaynnista").returningVoid().takingNoParams().withNiceError("Virhe käyttöliittymän käynnistämisessä. Kokeile koodia:\n" + koodi + "\nSyötteellä:\n" + komennot).invokeOn(kali);

        koodi += "\nvitsit.tulostaVitsit();";
        Reflex.reflect("Vitsipankki").method("tulostaVitsit").returningVoid().takingNoParams().withNiceError("Virhe vitsejä tulostettaessa. Kokeile koodia:\n" + koodi + "\nSyötteellä:\n" + komennot).invokeOn(vitsit);

        assertEquals("Kun vitsit tulostetaan, kunkin vitsin tulee esiintyä tulostuksessa tasan kerran. Kokeile koodia:\n" + koodi, 1, lkmTulostuksesta("Ope, keksin uuden sanan! .. Noh, mikä se on ?.. Plagiarismi!"));
    }

    @Test(timeout = 100)
    @Points("06-12.2")
    public void testaaTulostus() throws Throwable {
        String koodi = "Vitsipankki vitsit = new Vitsipankki();\n"
                + "vitsit.lisaaVitsi(\"Vitsi vitsi 1\");\n"
                + "vitsit.lisaaVitsi(\"Vitsi vitsi 2\");\n"
                + "Scanner lukija = new Scanner(System.in);\n"
                + "\n"
                + "Kayttoliittyma liittyma = new Kayttoliittyma(vitsit, lukija);\n"
                + "liittyma.kaynnista();";

        String komennot = "3\nX\n";
        Scanner lukija = new Scanner(komennot);

        Object vitsit = Reflex.reflect("Vitsipankki").ctor().takingNoParams().withNiceError("Virhe vitsipankin luomisessa. Kokeile koodia:\n" + koodi).invoke();
        Reflex.reflect("Vitsipankki").method("lisaaVitsi").returningVoid().taking(String.class).withNiceError("Virhe vitsin lisäämisessä vitsipankkiin. Kokeile koodia:\n" + koodi).invokeOn(vitsit, "Vitsi vitsi 1");
        Reflex.reflect("Vitsipankki").method("lisaaVitsi").returningVoid().taking(String.class).withNiceError("Virhe vitsin lisäämisessä vitsipankkiin. Kokeile koodia:\n" + koodi).invokeOn(vitsit, "Vitsi vitsi 2");
        
        Object kali = Reflex.reflect("Kayttoliittyma").ctor().taking(Reflex.reflect("Vitsipankki").cls(), Scanner.class).withNiceError("Virhe kayttoliittyman luomisessa. Kokeile koodia:\n" + koodi).invoke(vitsit, lukija);

        Reflex.reflect("Kayttoliittyma").method("kaynnista").returningVoid().takingNoParams().withNiceError("Virhe käyttöliittymän käynnistämisessä. Kokeile koodia:\n" + koodi + "\nSyötteellä:\n" + komennot).invokeOn(kali);

        assertEquals("Kun vitsit tulostetaan, kunkin vitsin tulee esiintyä tulostuksessa tasan kerran. Kokeile koodia:\n" + koodi + "\nSyötteellä:\n" + komennot, 1, lkmTulostuksesta("Vitsi vitsi 1"));
        assertEquals("Kun vitsit tulostetaan, kunkin vitsin tulee esiintyä tulostuksessa tasan kerran. Kokeile koodia:\n" + koodi + "\nSyötteellä:\n" + komennot, 1, lkmTulostuksesta("Vitsi vitsi 2"));
    }

    @Test(timeout = 100)
    @Points("06-12.2")
    public void testaaArpominen() throws Throwable {
        String koodi = "Vitsipankki vitsit = new Vitsipankki();\n"
                + "vitsit.lisaaVitsi(\"Vitsi vitsi 1\");\n"
                + "vitsit.lisaaVitsi(\"Vitsi vitsi 2\");\n"
                + "vitsit.lisaaVitsi(\"Vitsi vitsi 3\");\n"
                + "Scanner lukija = new Scanner(System.in);\n"
                + "\n"
                + "Kayttoliittyma liittyma = new Kayttoliittyma(vitsit, lukija);\n"
                + "liittyma.kaynnista();";

        String komennot = "2\nX\n";
        Scanner lukija = new Scanner(komennot);

        Object vitsit = Reflex.reflect("Vitsipankki").ctor().takingNoParams().withNiceError("Virhe vitsipankin luomisessa. Kokeile koodia:\n" + koodi).invoke();
        Reflex.reflect("Vitsipankki").method("lisaaVitsi").returningVoid().taking(String.class).withNiceError("Virhe vitsin lisäämisessä vitsipankkiin. Kokeile koodia:\n" + koodi).invokeOn(vitsit, "Vitsi vitsi 1");
        Reflex.reflect("Vitsipankki").method("lisaaVitsi").returningVoid().taking(String.class).withNiceError("Virhe vitsin lisäämisessä vitsipankkiin. Kokeile koodia:\n" + koodi).invokeOn(vitsit, "Vitsi vitsi 2");
        Reflex.reflect("Vitsipankki").method("lisaaVitsi").returningVoid().taking(String.class).withNiceError("Virhe vitsin lisäämisessä vitsipankkiin. Kokeile koodia:\n" + koodi).invokeOn(vitsit, "Vitsi vitsi 3");
        
        Object kali = Reflex.reflect("Kayttoliittyma").ctor().taking(Reflex.reflect("Vitsipankki").cls(), Scanner.class).withNiceError("Virhe kayttoliittyman luomisessa. Kokeile koodia:\n" + koodi).invoke(vitsit, lukija);

        Reflex.reflect("Kayttoliittyma").method("kaynnista").returningVoid().takingNoParams().withNiceError("Virhe käyttöliittymän käynnistämisessä. Kokeile koodia:\n" + koodi + "\nSyötteellä:\n" + komennot).invokeOn(kali);

        assertEquals("Kun käyttöliittymässä arvotaan yksi vitsi, tulee ohjelman tulostaa tasan yksi vitsi. Kokeile koodia:\n" + koodi + "\nSyötteellä:\n" + komennot, 1, lkmTulostuksesta("Vitsi vitsi 1") + lkmTulostuksesta("Vitsi vitsi 2") + lkmTulostuksesta("Vitsi vitsi 3"));
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

    private int lkmTulostuksesta(String vitsi) {
        String out = io.getSysOut();
        int lkm = 0;
        while (out.contains(vitsi)) {
            out = out.replace(vitsi, "");
            lkm++;
        }

        return lkm;
    }

}
