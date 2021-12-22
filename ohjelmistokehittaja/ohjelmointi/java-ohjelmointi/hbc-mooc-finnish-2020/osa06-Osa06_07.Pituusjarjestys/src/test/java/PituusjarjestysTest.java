
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

public class PituusjarjestysTest {

    @Test
    @Points("06-07.1")
    public void onLuokkaHuone() throws Throwable {
        Reflex.reflect("Huone").requirePublic();
        Reflex.reflect("Huone").ctor().takingNoParams().requirePublic();
    }

    @Test
    @Points("06-07.1")
    public void huoneellaOliomuuttujanaArrayList() throws Throwable {
        Reflex.reflect("Huone").requirePublic();
        Class clazz = Reflex.reflect("Huone").cls();

        assertEquals("Luokalla Huone tulee olla vain yksi oliomuuttuja. Nyt niitä oli: " + clazz.getDeclaredFields().length, 1, clazz.getDeclaredFields().length);
        Field f = clazz.getDeclaredFields()[0];
        assertEquals("Luokalla Huone tulee olla oliomuuttujana ArrayList-tyyppinen olio. Nyt oliomuuttujan tyyppi oli: ", ArrayList.class, f.getType());
    }

    @Test
    @Points("06-07.1")
    public void huoneellaMetodiLisaa() throws Throwable {
        Reflex.reflect("Huone").method("lisaa").returningVoid().taking(Henkilo.class).requirePublic();
    }

    @Test
    @Points("06-07.1")
    public void huoneellaMetodiOnTyhja() throws Throwable {
        Reflex.reflect("Huone").method("onTyhja").returning(boolean.class).takingNoParams().requirePublic();
    }

    @Test
    @Points("06-07.1")
    public void huoneellaMetodiGetHenkilot() throws Throwable {
        Reflex.reflect("Huone").method("getHenkilot").returning(ArrayList.class).takingNoParams().requirePublic();
    }

    @Test
    @Points("06-07.1")
    public void test1() throws Throwable {
        Object huone = Reflex.reflect("Huone").ctor().takingNoParams().invoke();
        assertTrue("Juuri luodun huoneen pitäisi olla tyhjä. Kokeile koodia:\nHuone h = new Huone();\nSystem.out.println(h.onTyhja());", Reflex.reflect("Huone").method("onTyhja").returning(boolean.class).takingNoParams().invokeOn(huone));
        Henkilo hlo = new Henkilo("ada", 168);
        try {
            Reflex.reflect("Huone").method("lisaa").returningVoid().taking(Henkilo.class).invokeOn(huone, hlo);
        } catch (Throwable t) {
            fail("Virhe kun lisättiin henkilöä huoneeseen. Kokeile koodia:\nHuone h = new Huone();\nSystem.out.println(h.onTyhja());\nHenkilo hlo = new Henkilo(\"ada\", 168);\nh.lisaa(hlo);");
        }
        assertFalse("Kun huoneeseen on lisätty yksi henkilö, ei huoneen pitäisi olla tyhjä. Kokeile koodia:\nHuone h = new Huone();\nSystem.out.println(h.onTyhja());\nHenkilo hlo = new Henkilo(\"ada\", 168);\nh.lisaa(hlo);\nSystem.out.println(h.onTyhja());", Reflex.reflect("Huone").method("onTyhja").returning(boolean.class).takingNoParams().invokeOn(huone));

        ArrayList<Henkilo> henkilot = null;
        try {
            henkilot = Reflex.reflect("Huone").method("getHenkilot").returning(ArrayList.class).takingNoParams().invokeOn(huone);
        } catch (Throwable t) {
            fail("Virhe kun kutsuttiin getHenkilot-metodia. Kokeile koodia:\nHuone h = new Huone();\nSystem.out.println(h.onTyhja());\nHenkilo hlo = new Henkilo(\"ada\", 168);\nh.lisaa(hlo);\nSystem.out.println(h.onTyhja());\nArrayList<Henkilo> henkilot = h.getHenkilot();");
        }

        assertNotNull("Metodin getHenkilot palauttaman viitteen ei tule koskaan olla null. Kokeile koodia:\nHuone h = new Huone();\nSystem.out.println(h.onTyhja());\nHenkilo hlo = new Henkilo(\"ada\", 168);\nh.lisaa(hlo);\nSystem.out.println(h.onTyhja());\nArrayList<Henkilo> henkilot = h.getHenkilot();", henkilot);
        assertEquals("Kun huoneeseen on lisätty yksi henkilö, tulee metodin getHenkilot palauttamassa listassa olla yksi henkilö. Kokeile koodia:\nHuone h = new Huone();\nSystem.out.println(h.onTyhja());\nHenkilo hlo = new Henkilo(\"ada\", 168);\nh.lisaa(hlo);\nSystem.out.println(h.onTyhja());\nArrayList<Henkilo> henkilot = h.getHenkilot();\nSystem.out.println(henkilot);", 1, henkilot.size());

        Henkilo listasta = henkilot.get(0);
        assertEquals("Metodin getHenkilot palauttaman henkilön pitäisi olla sama kuin listalle lisätyn henkilön. Kokeile koodia:Kokeile koodia:\nHuone h = new Huone();\nSystem.out.println(h.onTyhja());\nHenkilo hlo = new Henkilo(\"ada\", 168);\nh.lisaa(hlo);\nSystem.out.println(h.onTyhja());\nArrayList<Henkilo> henkilot = h.getHenkilot();\nSystem.out.println(henkilot);", hlo.getNimi(), listasta.getNimi());
        assertEquals("Metodin getHenkilot palauttaman henkilön pitäisi olla sama kuin listalle lisätyn henkilön. Kokeile koodia:Kokeile koodia:\nHuone h = new Huone();\nSystem.out.println(h.onTyhja());\nHenkilo hlo = new Henkilo(\"ada\", 168);\nh.lisaa(hlo);\nSystem.out.println(h.onTyhja());\nArrayList<Henkilo> henkilot = h.getHenkilot();\nSystem.out.println(henkilot);", hlo.getPituus(), listasta.getPituus());
    }

    @Test
    @Points("06-07.2")
    public void onMetodiLyhin() throws Throwable {
        Reflex.reflect("Huone").method("lyhin").returning(Henkilo.class).takingNoParams().requirePublic();
    }

    @Test
    @Points("06-07.2")
    public void metodiLyhinPalauttaaNullViitteenKunHuoneTyhja() throws Throwable {
        Object huone = Reflex.reflect("Huone").ctor().takingNoParams().invoke();
        Henkilo h;
        try {
            h = Reflex.reflect("Huone").method("lyhin").returning(Henkilo.class).takingNoParams().invokeOn(huone);
        } catch (Throwable t) {
            fail("Virhe kun kutsuttiin lyhin-metodia. Kokeile koodia:\nHuone h = new Huone();\nh.lyhin();");
            return;
        }

        assertNull("Tyhjälle huoneelle kutsutun lyhin-metodin tulee palauttaa null-viite. Kokeile koodia:\nHuone h = new Huone();\nSystem.out.println(h.lyhin());", h);
    }

    @Test
    @Points("06-07.2")
    public void metodiLyhinPalauttaaLyhimman1() throws Throwable {
        Reflex.reflect("Huone").method("lyhin").returning(Henkilo.class).takingNoParams().requirePublic();
        Object huone = Reflex.reflect("Huone").ctor().takingNoParams().invoke();

        Henkilo eka = new Henkilo("eka", 1);
        Henkilo toka = new Henkilo("toka", 2);
        Henkilo kolmas = new Henkilo("kolmas", 3);

        String koodi = "\nHuone h = new Huone();\n"
                + "Henkilo eka = new Henkilo(\"eka\", 1);\n"
                + "Henkilo toka = new Henkilo(\"toka\", 2);\n"
                + "Henkilo kolmas = new Henkilo(\"kolmas\", 3);\n\nh.lisaa(eka);\nh.lisaa(toka);\nh.lisaa(kolmas);";

        try {
            Reflex.reflect("Huone").method("lisaa").returningVoid().taking(Henkilo.class).invokeOn(huone, eka);
            Reflex.reflect("Huone").method("lisaa").returningVoid().taking(Henkilo.class).invokeOn(huone, toka);
            Reflex.reflect("Huone").method("lisaa").returningVoid().taking(Henkilo.class).invokeOn(huone, kolmas);
        } catch (Throwable t) {
            fail("Virhe kun lisättiin henkilöä huoneeseen. Kokeile koodia:" + koodi);
        }

        koodi += "\n\nHenkilo lyhin = h.lyhin();\nSystem.out.println(lyhin);";

        Henkilo lyhin;
        try {
            lyhin = Reflex.reflect("Huone").method("lyhin").returning(Henkilo.class).takingNoParams().invokeOn(huone);
        } catch (Throwable t) {
            fail("Virhe kun kutsuttiin lyhin-metodia. Kokeile koodia:" + koodi);
            return;
        }

        assertNotNull("Kun huone ei ole tyhjä, ei huoneen lyhin-metodin tule palauttaa null-viitettä. Kokeile koodia:" + koodi, lyhin);
        assertEquals("Metodin lyhin pitäisi palauttaa lyhin huoneeseen lisätty henkilö. Kokeile koodia:" + koodi, eka, lyhin);
    }

    @Test
    @Points("06-07.2")
    public void metodiLyhinPalauttaaLyhimman2() throws Throwable {
        Reflex.reflect("Huone").method("lyhin").returning(Henkilo.class).takingNoParams().requirePublic();
        Object huone = Reflex.reflect("Huone").ctor().takingNoParams().invoke();

        Henkilo eka = new Henkilo("eka", 3);
        Henkilo toka = new Henkilo("toka", 2);
        Henkilo kolmas = new Henkilo("kolmas", 1);

        String koodi = "\nHuone h = new Huone();\n"
                + "Henkilo eka = new Henkilo(\"eka\", 3);\n"
                + "Henkilo toka = new Henkilo(\"toka\", 2);\n"
                + "Henkilo kolmas = new Henkilo(\"kolmas\", 1);\n\nh.lisaa(eka);\nh.lisaa(toka);\nh.lisaa(kolmas);";

        try {
            Reflex.reflect("Huone").method("lisaa").returningVoid().taking(Henkilo.class).invokeOn(huone, eka);
            Reflex.reflect("Huone").method("lisaa").returningVoid().taking(Henkilo.class).invokeOn(huone, toka);
            Reflex.reflect("Huone").method("lisaa").returningVoid().taking(Henkilo.class).invokeOn(huone, kolmas);
        } catch (Throwable t) {
            fail("Virhe kun lisättiin henkilöä huoneeseen. Kokeile koodia:" + koodi);
        }

        koodi += "\n\nHenkilo lyhin = h.lyhin();\nSystem.out.println(lyhin);";

        Henkilo lyhin;
        try {
            lyhin = Reflex.reflect("Huone").method("lyhin").returning(Henkilo.class).takingNoParams().invokeOn(huone);
        } catch (Throwable t) {
            fail("Virhe kun kutsuttiin lyhin-metodia. Kokeile koodia:" + koodi);
            return;
        }

        assertNotNull("Kun huone ei ole tyhjä, ei huoneen lyhin-metodin tule palauttaa null-viitettä. Kokeile koodia:" + koodi, lyhin);
        assertEquals("Metodin lyhin pitäisi palauttaa lyhin huoneeseen lisätty henkilö. Kokeile koodia:" + koodi, kolmas, lyhin);
    }

    @Test
    @Points("06-07.3")
    public void onMetodiOta() throws Throwable {
        Reflex.reflect("Huone").method("ota").returning(Henkilo.class).takingNoParams().requirePublic();
    }

    @Test
    @Points("06-07.3")
    public void metodiOtaPalauttaaNullViitteenKunHuoneTyhja() throws Throwable {
        Object huone = Reflex.reflect("Huone").ctor().takingNoParams().invoke();
        Henkilo h;
        try {
            h = Reflex.reflect("Huone").method("ota").returning(Henkilo.class).takingNoParams().invokeOn(huone);
        } catch (Throwable t) {
            fail("Virhe kun kutsuttiin ota-metodia. Kokeile koodia:\nHuone h = new Huone();\nh.ota();");
            return;
        }

        assertNull("Tyhjälle huoneelle kutsutun ota-metodin tulee palauttaa null-viite. Kokeile koodia:\nHuone h = new Huone();\nSystem.out.println(h.ota());", h);
    }

    @Test
    @Points("06-07.3")
    public void metodiOtaPalauttaaLyhimman1() throws Throwable {
        Reflex.reflect("Huone").method("ota").returning(Henkilo.class).takingNoParams().requirePublic();
        Object huone = Reflex.reflect("Huone").ctor().takingNoParams().invoke();

        Henkilo eka = new Henkilo("eka", 2);
        Henkilo toka = new Henkilo("toka", 1);
        Henkilo kolmas = new Henkilo("kolmas", 3);

        String koodi = "\nHuone h = new Huone();\n"
                + "Henkilo eka = new Henkilo(\"eka\", 2);\n"
                + "Henkilo toka = new Henkilo(\"toka\", 1);\n"
                + "Henkilo kolmas = new Henkilo(\"kolmas\", 3);\n\nh.lisaa(eka);\nh.lisaa(toka);\nh.lisaa(kolmas);";

        try {
            Reflex.reflect("Huone").method("lisaa").returningVoid().taking(Henkilo.class).invokeOn(huone, eka);
            Reflex.reflect("Huone").method("lisaa").returningVoid().taking(Henkilo.class).invokeOn(huone, toka);
            Reflex.reflect("Huone").method("lisaa").returningVoid().taking(Henkilo.class).invokeOn(huone, kolmas);
        } catch (Throwable t) {
            fail("Virhe kun lisättiin henkilöä huoneeseen. Kokeile koodia:" + koodi);
        }

        koodi += "\n\nHenkilo lyhin = h.ota();\nSystem.out.println(lyhin);";

        Henkilo lyhin;
        try {
            lyhin = Reflex.reflect("Huone").method("ota").returning(Henkilo.class).takingNoParams().invokeOn(huone);
        } catch (Throwable t) {
            fail("Virhe kun kutsuttiin ota-metodia. Kokeile koodia:" + koodi);
            return;
        }

        assertNotNull("Kun huone ei ole tyhjä, ei huoneen ota-metodin tule palauttaa null-viitettä. Kokeile koodia:" + koodi, lyhin);
        assertEquals("Metodin ota pitäisi palauttaa lyhin huoneeseen lisätty henkilö. Kokeile koodia:" + koodi, toka, lyhin);

    }

    @Test
    @Points("06-07.3")
    public void metodiOtaPalauttaaLyhimman2() throws Throwable {
        Reflex.reflect("Huone").method("ota").returning(Henkilo.class).takingNoParams().requirePublic();
        Object huone = Reflex.reflect("Huone").ctor().takingNoParams().invoke();

        Henkilo eka = new Henkilo("eka", 3);
        Henkilo toka = new Henkilo("toka", 2);
        Henkilo kolmas = new Henkilo("kolmas", 1);

        String koodi = "\nHuone h = new Huone();\n"
                + "Henkilo eka = new Henkilo(\"eka\", 3);\n"
                + "Henkilo toka = new Henkilo(\"toka\", 2);\n"
                + "Henkilo kolmas = new Henkilo(\"kolmas\", 1);\n\nh.lisaa(eka);\nh.lisaa(toka);\nh.lisaa(kolmas);";

        try {
            Reflex.reflect("Huone").method("lisaa").returningVoid().taking(Henkilo.class).invokeOn(huone, eka);
            Reflex.reflect("Huone").method("lisaa").returningVoid().taking(Henkilo.class).invokeOn(huone, toka);
            Reflex.reflect("Huone").method("lisaa").returningVoid().taking(Henkilo.class).invokeOn(huone, kolmas);
        } catch (Throwable t) {
            fail("Virhe kun lisättiin henkilöä huoneeseen. Kokeile koodia:" + koodi);
        }

        koodi += "\n\nHenkilo lyhin = h.ota();\nSystem.out.println(lyhin);";

        Henkilo lyhin;
        try {
            lyhin = Reflex.reflect("Huone").method("ota").returning(Henkilo.class).takingNoParams().invokeOn(huone);
        } catch (Throwable t) {
            fail("Virhe kun kutsuttiin ota-metodia. Kokeile koodia:" + koodi);
            return;
        }

        assertNotNull("Kun huone ei ole tyhjä, ei huoneen ota-metodin tule palauttaa null-viitettä. Kokeile koodia:" + koodi, lyhin);
        assertEquals("Metodin ota pitäisi palauttaa lyhin huoneeseen lisätty henkilö. Kokeile koodia:" + koodi, kolmas, lyhin);
    }

    @Test
    @Points("06-07.3")
    public void metodiOtaPoistaaHuoneestaLyhimman() throws Throwable {
        Reflex.reflect("Huone").method("ota").returning(Henkilo.class).takingNoParams().requirePublic();
        Object huone = Reflex.reflect("Huone").ctor().takingNoParams().invoke();

        Henkilo eka = new Henkilo("eka", 1);

        String koodi = "\nHuone h = new Huone();\n"
                + "Henkilo eka = new Henkilo(\"eka\", 1);\n"
                + "\nh.lisaa(eka);";

        try {
            Reflex.reflect("Huone").method("lisaa").returningVoid().taking(Henkilo.class).invokeOn(huone, eka);
        } catch (Throwable t) {
            fail("Virhe kun lisättiin henkilöä huoneeseen. Kokeile koodia:" + koodi);
        }

        koodi += "\nSystem.out.println(h.onTyhja());";
        assertFalse("Kun huoneeseen on lisätty yksi henkilö, ei sen pitäisi olla tyhjä. Kokeile koodia:" + koodi, Reflex.reflect("Huone").method("onTyhja").returning(boolean.class).takingNoParams().invokeOn(huone));

        koodi += "\n\nHenkilo lyhin = h.ota();\nSystem.out.println(lyhin);";

        Henkilo lyhin;
        try {
            lyhin = Reflex.reflect("Huone").method("ota").returning(Henkilo.class).takingNoParams().invokeOn(huone);
        } catch (Throwable t) {
            fail("Virhe kun kutsuttiin ota-metodia. Kokeile koodia:" + koodi);
            return;
        }

        assertNotNull("Kun huone ei ole tyhjä, ei huoneen ota-metodin tule palauttaa null-viitettä. Kokeile koodia:" + koodi, lyhin);
        assertEquals("Huoneesta ei palautettu oikeaa henkilöä. Kokeile koodia:" + koodi, eka, lyhin);

        koodi += "\nSystem.out.println(h.onTyhja());";

        assertTrue("Kun huoneeseen ensin lisättiin yksi henkilö, joka sen jälkeen otettiin ota-metodilla, tulee huoneen olla tyhjä. Kokeile koodia:" + koodi, Reflex.reflect("Huone").method("onTyhja").returning(boolean.class).takingNoParams().invokeOn(huone));
    }

    @Test
    @Points("06-07.3")
    public void metodillaOtaSaaHenkilotPituusJarjestyksessa() throws Throwable {
        Reflex.reflect("Huone").method("ota").returning(Henkilo.class).takingNoParams().requirePublic();
        Object huone = Reflex.reflect("Huone").ctor().takingNoParams().invoke();
        
        String koodi = "\nHuone h = new Huone();\n"
                + "Henkilo eka = new Henkilo(\"eka\", 62);\n"
                + "Henkilo toka = new Henkilo(\"toka\", 59);\n"
                + "Henkilo kolmas = new Henkilo(\"kolmas\", 104);\n"
                + "Henkilo neljas = new Henkilo(\"neljas\", 61);\n"
                + "\nh.lisaa(eka);"
                + "\nh.lisaa(toka);"
                + "\nh.lisaa(kolmas);"
                + "\nh.lisaa(neljas);\n"
                + "\nwhile(!h.onTyhja()) {\n"
                + "    System.out.println(h.ota());\n"
                + "}";

        Henkilo eka = new Henkilo("eka", 62);
        Henkilo toka = new Henkilo("toka", 59);
        Henkilo kolmas = new Henkilo("kolmas", 104);
        Henkilo neljas = new Henkilo("neljas", 61);
        
        try {
            Reflex.reflect("Huone").method("lisaa").returningVoid().taking(Henkilo.class).invokeOn(huone, eka);
            Reflex.reflect("Huone").method("lisaa").returningVoid().taking(Henkilo.class).invokeOn(huone, toka);
            Reflex.reflect("Huone").method("lisaa").returningVoid().taking(Henkilo.class).invokeOn(huone, kolmas);
            Reflex.reflect("Huone").method("lisaa").returningVoid().taking(Henkilo.class).invokeOn(huone, neljas);
        } catch (Throwable t) {
            fail("Ohjelma ei toiminut odotetulla tavalla. Kokeile koodia:" + koodi);
        }
        
        List<Henkilo> odotettu = new ArrayList<>(Arrays.asList(toka, neljas, eka, kolmas));
        
        try {
            while(!Reflex.reflect("Huone").method("onTyhja").returning(boolean.class).takingNoParams().invokeOn(huone)) {
                Henkilo lyhin = Reflex.reflect("Huone").method("ota").returning(Henkilo.class).takingNoParams().invokeOn(huone);
                assertEquals("Ohjelma ei toiminut odotetulla tavalla. Kokeile koodia:" + koodi, lyhin, odotettu.get(0));
                odotettu.remove(0);
            }
        } catch (Throwable t) {
            fail("Ohjelma ei toiminut odotetulla tavalla. Kokeile koodia:" + koodi);
        }

        assertTrue("Ohjelma ei toiminut odotetulla tavalla. Kokeile koodia:" + koodi, odotettu.isEmpty());
    }

}
