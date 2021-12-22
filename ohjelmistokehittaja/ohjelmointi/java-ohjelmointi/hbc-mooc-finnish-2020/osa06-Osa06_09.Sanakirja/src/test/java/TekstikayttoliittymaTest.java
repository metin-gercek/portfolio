
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class TekstikayttoliittymaTest<_Sanakirja> {

    private Class tekstikayttoliittymaClass;
    private Constructor tekstikayttoliittymaConstructor;
    private Method kaynnistaMethod;

    String klassName = "Tekstikayttoliittyma";
    Reflex.ClassRef<Object> klass;

    @Rule
    public MockStdio io = new MockStdio();

    @Before
    public void setUp() {
        klass = Reflex.reflect(klassName);
        try {
            tekstikayttoliittymaClass = ReflectionUtils.findClass("Tekstikayttoliittyma");
            tekstikayttoliittymaConstructor = ReflectionUtils.requireConstructor(tekstikayttoliittymaClass, Scanner.class, Sanakirja.class);
            kaynnistaMethod = ReflectionUtils.requireMethod(tekstikayttoliittymaClass, "kaynnista");
        } catch (Throwable t) {
        }
    }

    @Test
    @Points("06-09.1")
    public void luokkaJulkinen() {
        assertTrue("Luokan " + klassName + " pitää olla julkinen, eli se tulee määritellä\npublic class " + klassName + " {...\n}", klass.isPublic());
    }

    @Test
    @Points("06-09.1")
    public void eiYlimaaraisiaMuuttujia() {
        saniteettitarkastus(klassName, 2, "Scanner- ja Sanakirja-tyyppiset oliomuuttujat");
    }

    @Test
    @Points("06-09.1")
    public void konstruktori() throws Throwable {
        Reflex.ClassRef<_Sanakirja> _SanakirjaRef = Reflex.reflect("Sanakirja");
        _Sanakirja sk = _SanakirjaRef.constructor().takingNoParams().invoke();

        Reflex.MethodRef2<Object, Object, Scanner, _Sanakirja> ctor = klass.constructor().
                taking(Scanner.class, _SanakirjaRef.cls()).withNiceError();
        assertTrue("Määrittele luokalle " + klassName + " julkinen konstruktori: public " + klassName + "(Scanner lukija, Sanakirja sanakirja)", ctor.isPublic());
        String v = "virheen aiheutti koodi new Tekstikayttoliittyma(new Scanner(System.in), new Sanakirja());";
        ctor.withNiceError(v).invoke(new Scanner(System.in), sk);
    }

    public Object luo() throws Throwable {
        Reflex.ClassRef<_Sanakirja> _SanakirjaRef = Reflex.reflect("Sanakirja");
        _Sanakirja sk = _SanakirjaRef.constructor().takingNoParams().invoke();

        Reflex.MethodRef2<Object, Object, Scanner, _Sanakirja> ctor = klass.constructor().
                taking(Scanner.class, _SanakirjaRef.cls()).withNiceError();
        return ctor.withNiceError().invoke(new Scanner("lopeta"), sk);
    }

    public Object luo(Scanner skanneri) throws Throwable {
        Reflex.ClassRef<_Sanakirja> _SanakirjaRef = Reflex.reflect("Sanakirja");
        _Sanakirja sk = _SanakirjaRef.constructor().takingNoParams().invoke();

        Reflex.MethodRef2<Object, Object, Scanner, _Sanakirja> ctor = klass.constructor().
                taking(Scanner.class, _SanakirjaRef.cls()).withNiceError();
        return ctor.withNiceError().invoke(skanneri, sk);
    }

    @Test
    @Points("06-09.1")
    public void kaynnistaMetodi() throws Throwable {
        String metodi = "kaynnista";

        Object olio = luo();

        assertTrue("tee luokalle " + klassName + " metodi public void " + metodi + "() ",
                klass.method(olio, metodi)
                        .returningVoid().takingNoParams().isPublic());

        String v = "\nVirheen aiheuttanut koodi\n "
                + "Tekstikayttoliittyma t = new Tekstikayttoliittyma(new Scanner(System.in), new Sanakirja());\n"
                + "t.kaynnista();";

        klass.method(olio, metodi)
                .returningVoid().takingNoParams().withNiceError(v).invoke();
    }

    @Test(timeout = 200)
    @Points("06-09.1")
    public void tekstikayttoliittymanLopetaKomentoToimii() {
        Scanner lukija = new Scanner("lopeta\n");
        Object tekstikayttoliittyma = luoTekstikayttoliittymaScannerillaJaSanoilla(lukija, "a", "b");
        try {
            kaynnistaMethod.invoke(tekstikayttoliittyma);
        } catch (Throwable t) {
            fail("Varmista että tekstikäyttöliittymästä poistutaan kun käyttäjä syöttää komennon lopeta. Käytäthän konstrktorissa parametrina saatua Scanneria?");
        }
    }

    @Test(timeout = 200)
    @Points("06-09.1")
    public void tekstikayttoliittymanLopetaKomentoToimiiVaikkaSyotetaanMuuta() {
        Scanner lukija = new Scanner("apu\nporkkana\nlopeta\n");
        Object tekstikayttoliittyma = luoTekstikayttoliittymaScannerillaJaSanoilla(lukija, "a", "b");
        try {
            kaynnistaMethod.invoke(tekstikayttoliittyma);
        } catch (Throwable t) {
            fail("Varmista että tekstikäyttöliittymästä poistutaan kun käyttäjä syöttää komennon lopeta.");
        }
    }

    @Test(timeout = 200)
    @Points("06-09.2")
    public void lisaaKomentoToimii() {
        Scanner lukija = new Scanner("lisaa\nporkkana\ncarrot\nlopeta\n");
        Sanakirja sanakirja = luoSanakirjaSanoilla();
        Object tekstikayttoliittyma = luoTekstikayttoliittyma(lukija, sanakirja);

        try {
            kaynnistaMethod.invoke(tekstikayttoliittyma);
        } catch (Throwable t) {
            fail("Varmista että tekstikäyttöliittymästä poistutaan kun käyttäjä syöttää komennon lopeta.");
        }

        if (!sisaltaaSanaparin(sanakirja, "porkkana", "carrot")) {
            fail("Varmista että komento \"lisaa\" lisää sanakirjaan uuden sanaparin.");
        }
    }

    @Test(timeout = 200)
    @Points("06-09.2")
    public void lisaaKomentoToimiiUseammallaSanaparilla() {
        Scanner lukija = new Scanner("lisaa\nporkkana\ncarrot\nlisaa\navain\nkey\nlopeta\n");
        Sanakirja sanakirja = luoSanakirjaSanoilla();
        Object tekstikayttoliittyma = luoTekstikayttoliittyma(lukija, sanakirja);

        try {
            kaynnistaMethod.invoke(tekstikayttoliittyma);
        } catch (Throwable t) {
            fail("Varmista että tekstikäyttöliittymästä poistutaan kun käyttäjä syöttää komennon lopeta.");
        }

        if (!sisaltaaSanaparin(sanakirja, "porkkana", "carrot")) {
            fail("Varmista että komento \"lisaa\" lisää sanakirjaan uuden sanaparin.");
        }

        if (!sisaltaaSanaparin(sanakirja, "avain", "key")) {
            fail("Varmista että komento \"lisaa\" lisää sanakirjaan uuden sanaparin.");
        }
    }

    @Test(timeout = 200)
    @Points("06-09.3")
    public void haeKomentoToimiiYhdellaSanaparilla() {
        Scanner lukija = new Scanner("hae\nporkkana\nlopeta\n");
        Object sanakirja = luoSanakirjaSanoilla("porkkana", "carrot");
        Object tekstikayttoliittyma = luoTekstikayttoliittyma(lukija, sanakirja);

        try {
            kaynnistaMethod.invoke(tekstikayttoliittyma);
        } catch (Throwable t) {
            fail("Varmista että tekstikäyttöliittymästä poistutaan kun käyttäjä syöttää komennon lopeta.");
        }

        String output = io.getSysOut();
        if (!output.contains("carrot")) {
            fail("Varmista että komento hae palauttaa halutun merkkijonon.");
        }
    }

    @Test(timeout = 200)
    @Points("06-09.3")
    public void haeKomentoToimiiUseammallaSanaparilla() {
        Scanner lukija = new Scanner("hae\nyksi\nlopeta\n");
        Object sanakirja = luoSanakirjaSanoilla("porkkana", "carrot", "yksi", "one");
        Object tekstikayttoliittyma = luoTekstikayttoliittyma(lukija, sanakirja);

        try {
            kaynnistaMethod.invoke(tekstikayttoliittyma);
        } catch (Throwable t) {
            fail("Varmista että tekstikäyttöliittymästä poistutaan kun käyttäjä syöttää komennon lopeta.");
        }

        String output = io.getSysOut();
        if (!output.contains("one")) {
            fail("Varmista että komento hae palauttaa halutun merkkijonon.");
        }

        if (output.contains("porkkana") || output.contains("carrot")) {
            fail("Kun sanakirjassa on sanaparit porkkana=carrot ja yksi=one ja ohjelmassa haetaan sanaa yksi, ei merkkijonojen porkkana tai carrot tule esiintyä tulostuksessa.");
        }
    }

    @Test(timeout = 200)
    @Points("06-09.4")
    public void haeKomentoEiTulostaNullia() {
        Scanner lukija = new Scanner("hae\nkaksi\nlopeta\n");
        Object sanakirja = luoSanakirjaSanoilla("porkkana", "carrot", "yksi", "one");
        Object tekstikayttoliittyma = luoTekstikayttoliittyma(lukija, sanakirja);

        try {
            kaynnistaMethod.invoke(tekstikayttoliittyma);
        } catch (Throwable t) {
            fail("Varmista että tekstikäyttöliittymästä poistutaan kun käyttäjä syöttää komennon lopeta.");
        }

        String output = io.getSysOut();
        if (!output.contains("Sanaa kaksi ei")) {
            fail("Mikäli haettavaa merkkijonoa ei löydy, tulee tulostuksessa kertoa siitä. Varmista, että tulostus on tehtävänannossa halutun muotoinen.");
        }
        
        if (output.contains("null")) {
            fail("Tulostuksessa ei tule esiintyä merkkijonoa null.");
        }
    }

    /*
     *
     */
    private Sanakirja luoSanakirjaSanoilla(String... sanatJaKaannokset) {
        Sanakirja sanakirja = new Sanakirja();
        for (int i = 0; i < sanatJaKaannokset.length; i += 2) {
            sanakirja.lisaa(sanatJaKaannokset[i], sanatJaKaannokset[i + 1]);
        }
        return sanakirja;
    }

    private Object luoTekstikayttoliittymaScannerillaJaSanoilla(Scanner lukija, String... sanatJaKaannokset) {
        Object sanakirja = luoSanakirjaSanoilla(sanatJaKaannokset);

        try {
            return ReflectionUtils.invokeConstructor(tekstikayttoliittymaConstructor, lukija, sanakirja);

        } catch (Throwable ex) {
            return null;
        }
    }

    private Object luoTekstikayttoliittyma(Scanner lukija, Object sanakirja) {
        try {
            return ReflectionUtils.invokeConstructor(tekstikayttoliittymaConstructor, lukija, sanakirja);
        } catch (Throwable ex) {
            return null;
        }
    }

    private boolean sisaltaaSanaparin(Sanakirja sanakirja, String sana, String kaannos) {
        if (sanakirja.kaanna(sana) == null) {
            return false;
        }

        if (sanakirja.kaanna(sana).equals(kaannos)) {
            return true;
        }

        return false;
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
