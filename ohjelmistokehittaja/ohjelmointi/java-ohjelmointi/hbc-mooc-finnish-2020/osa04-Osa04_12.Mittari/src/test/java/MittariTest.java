
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.lang.reflect.Field;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

@Points("04-12")
public class MittariTest {

    Reflex.ClassRef<Object> klass;
    String klassName = "Mittari";

    @Before
    public void haeLuokka() {
        klass = Reflex.reflect(klassName);
    }

    @Test
    public void luokkaJulkinen() {
        assertTrue("Luokan " + klassName + " pitää olla julkinen, eli se tulee määritellä\npublic class " + klassName + " {...\n}", klass.isPublic());
    }

    @Test
    public void testaaKonstruktori() throws Throwable {
        Reflex.MethodRef0<Object, Object> cc = klass.constructor().takingNoParams().withNiceError();
        assertTrue("Määrittele luokalle " + klassName + " julkinen konstruktori: public " + klassName + "()", cc.isPublic());
        cc.invoke();
    }

    @Test
    public void eiYlimaaraisiaMuuttujia() {
        saniteettitarkastus();
    }

    @Test
    public void testaaLisaa() throws Throwable {
        Reflex.ClassRef<Object> klass = Reflex.reflect(klassName);
        Object instance = klass.constructor().takingNoParams().invoke();

        try {
            klass.method(instance, "lisaa")
                    .returningVoid()
                    .takingNoParams().invoke();
        } catch (AssertionError ae) {
            fail("Virhe: " + ae + "\n eli tee luokalle " + klassName + " metodi public void lisaa()");
        }

        assertTrue("Metodin lisaa tulee olla public eli määritelty public void lisaa()", klass.method(instance, "lisaa")
                .returningVoid()
                .takingNoParams().isPublic());
    }

    @Test
    public void testaaVahenna() throws Throwable {
        Reflex.ClassRef<Object> klass = Reflex.reflect(klassName);
        Object instance = klass.constructor().takingNoParams().invoke();

        try {
            klass.method(instance, "vahenna")
                    .returningVoid()
                    .takingNoParams().invoke();
        } catch (AssertionError ae) {
            fail("Virhe: " + ae + "\n eli tee luokalle " + klassName + " metodi public void vahenna()");
        }

        assertTrue("Metodin vahenna tulee olla public eli määritelty public void vahenna()", klass.method(instance, "vahenna")
                .returningVoid()
                .takingNoParams().isPublic());
    }

    @Test
    public void testaaMitta() throws Throwable {
        Reflex.ClassRef<Object> klass = Reflex.reflect(klassName);
        Object instance = klass.constructor().takingNoParams().invoke();

        try {
            klass.method(instance, "mitta")
                    .returning(int.class)
                    .takingNoParams().invoke();
        } catch (AssertionError ae) {
            fail("Virhe: " + ae + "\n eli tee luokalle " + klassName + " metodi public int mitta()");
        }

        assertTrue("Metodin mitta tulee olla public eli määritelty public int mitta()", klass.method(instance, "mitta")
                .returning(int.class)
                .takingNoParams().isPublic());

        int m = klass.method(instance, "mitta")
                .returning(int.class)
                .takingNoParams().invokeOn(instance);

        assertTrue("Mitan tulee olla aluksi 0. Kokeile:\nMittari m = new Mittari();\nSystem.out.println(m.mitta());\nNyt tulostus oli " + m, m == 0);
    }

    @Test
    public void testaaAlaraja() throws Throwable {
        Reflex.ClassRef<Object> klass = Reflex.reflect(klassName);
        Object instance = klass.constructor().takingNoParams().invoke();

        try {
            klass.method(instance, "mitta")
                    .returning(int.class)
                    .takingNoParams().invoke();
        } catch (AssertionError ae) {
            fail("Virhe: " + ae + "\n eli tee luokalle " + klassName + " metodi public int mitta()");
        }

        assertTrue("Metodin mitta tulee olla public eli määritelty public int mitta()", klass.method(instance, "mitta")
                .returning(int.class)
                .takingNoParams().isPublic());

        for (int i = 0; i < 10; i++) {
            try {
                klass.method(instance, "vahenna")
                        .returningVoid()
                        .takingNoParams()
                        .invokeOn(instance);
            } catch (Throwable t) {
                fail("Virhe kutsuttaessa metodia vahenna(). Virhe: " + t.getMessage());
            }
        }

        int m = klass.method(instance, "mitta")
                .returning(int.class)
                .takingNoParams().invokeOn(instance);

        assertFalse("Metodin vahenna() kutsumisen ei tule vähentää mittaa negatiiviseksi. Kokeile:\nMittari m = new Mittari();\n//kutsu metodia vahenna 10 kertaa\nSystem.out.println(m.mitta());\nTulostus oli " + m, m < 0);
        assertFalse("Metodin vahenna() kutsumisen ei tule kasvattaa mittaa. Kokeile:\nMittari m = new Mittari();\n//kutsu metodia vahenna 10 kertaa\nSystem.out.println(m.mitta());\nTulostus oli " + m, m > 0);
    }

    @Test
    public void testaaYlaraja() throws Throwable {
        Reflex.ClassRef<Object> klass = Reflex.reflect(klassName);
        Object instance = klass.constructor().takingNoParams().invoke();

        try {
            klass.method(instance, "mitta")
                    .returning(int.class)
                    .takingNoParams().invoke();
        } catch (AssertionError ae) {
            fail("Virhe: " + ae + "\n eli tee luokalle " + klassName + " metodi public int mitta()");
        }

        assertTrue("Metodin mitta tulee olla public eli määritelty public int mitta()", klass.method(instance, "mitta")
                .returning(int.class)
                .takingNoParams().isPublic());

        for (int i = 0; i < 10; i++) {
            try {
                klass.method(instance, "lisaa")
                        .returningVoid()
                        .takingNoParams()
                        .invokeOn(instance);
            } catch (Throwable t) {
                fail("Virhe kutsuttaessa metodia lisaa(). Virhe: " + t.getMessage());
            }
        }

        int m = klass.method(instance, "mitta")
                .returning(int.class)
                .takingNoParams().invokeOn(instance);

        assertFalse("Metodin lisaa() kutsumisen ei tule kasvattaa mittaa yli viiden. Kokeile:\nMittari m = new Mittari();\n//kutsu metodia lisaa 10 kertaa\nSystem.out.println(m.mitta());\nTulostus oli " + m, m > 5);
        assertFalse("Metodin lisaa() kutsumisen ei tule vähentää mittaa. Kokeile:\nMittari m = new Mittari();\n//kutsu metodia lisaa 10 kertaa\nSystem.out.println(m.mitta());\nTulostus oli " + m, m < 5);
    }

    @Test
    public void testaaTaynna() throws Throwable {
        Reflex.ClassRef<Object> klass = Reflex.reflect(klassName);
        Object instance = klass.constructor().takingNoParams().invoke();

        try {
            klass.method(instance, "taynna")
                    .returning(boolean.class)
                    .takingNoParams().invokeOn(instance);
        } catch (AssertionError ae) {
            fail("Virhe: " + ae + "\n eli tee luokalle " + klassName + " metodi public boolean taynna()");
        }

        assertTrue("Metodin taynna tulee olla public eli määritelty public boolean taynna()", klass.method(instance, "taynna")
                .returning(boolean.class)
                .takingNoParams().isPublic());
    }

    @Test
    public void testaaAskeleittainenKasvatus() throws Throwable {
        Reflex.ClassRef<Object> klass = Reflex.reflect(klassName);
        Object instance = klass.constructor().takingNoParams().invoke();

        try {
            klass.method(instance, "mitta")
                    .returning(int.class)
                    .takingNoParams().invoke();
        } catch (AssertionError ae) {
            fail("Virhe: " + ae + "\n eli tee luokalle " + klassName + " metodi public int mitta()");
        }

        assertTrue("Metodin mitta tulee olla public eli määritelty public int mitta()", klass.method(instance, "mitta")
                .returning(int.class)
                .takingNoParams().isPublic());

        for (int i = 1; i <= 5; i++) {
            try {
                klass.method(instance, "lisaa")
                        .returningVoid()
                        .takingNoParams()
                        .invokeOn(instance);
            } catch (Throwable t) {
                fail("Virhe kutsuttaessa metodia lisaa(). Virhe: " + t.getMessage());
            }

            int m = klass.method(instance, "mitta")
                    .returning(int.class)
                    .takingNoParams().invokeOn(instance);

            assertTrue("Kun metodia lisaa() on kutsuttu " + i + " kertaa, mitan pitäisi olla " + i + ". Nyt mitta oli " + m, m == i);
        }
    }

    @Test
    public void testaaTaynna2() throws Throwable {
        Reflex.ClassRef<Object> klass = Reflex.reflect(klassName);
        Object instance = klass.constructor().takingNoParams().invoke();

        try {
            klass.method(instance, "mitta")
                    .returning(int.class)
                    .takingNoParams().invoke();
        } catch (AssertionError ae) {
            fail("Virhe: " + ae + "\n eli tee luokalle " + klassName + " metodi public int mitta()");
        }

        assertTrue("Metodin mitta tulee olla public eli määritelty public int mitta()", klass.method(instance, "mitta")
                .returning(int.class)
                .takingNoParams().isPublic());

        for (int i = 1; i <= 5; i++) {
            try {
                klass.method(instance, "lisaa")
                        .returningVoid()
                        .takingNoParams()
                        .invokeOn(instance);
            } catch (Throwable t) {
                fail("Virhe kutsuttaessa metodia lisaa(). Virhe: " + t.getMessage());
            }

            int m = klass.method(instance, "mitta")
                    .returning(int.class)
                    .takingNoParams().invokeOn(instance);

            assertTrue("Kun metodia lisaa() on kutsuttu " + i + " kertaa, mitan pitäisi olla " + i + ". Nyt mitta oli " + m, m == i);

            boolean taynna = klass.method(instance, "taynna")
                    .returning(boolean.class)
                    .takingNoParams().invokeOn(instance);

            if (i < 5) {
                assertFalse("Kun lisaa-metodia on kutsuttu" + i + " kertaa, ei metodin taynna tule palauttaa arvoa true.", taynna);
            } else {
                assertTrue("Kun lisaa-metodia on kutsuttu" + i + " kertaa, tulee metodin taynna palauttaa arvo true.", taynna);
            }
        }
    }

    private void saniteettitarkastus() throws SecurityException {
        Field[] kentat = ReflectionUtils.findClass(klassName).getDeclaredFields();

        for (Field field : kentat) {
            assertFalse("et tarvitse \"stattisia muuttujia\", poista " + kentta(field.toString()), field.toString().contains("static") && !field.toString().contains("final"));
            assertTrue("luokan kaikkien oliomuuttujien näkyvyyden tulee olla private, muuta " + kentta(field.toString()), field.toString().contains("private"));
        }

        if (kentat.length > 1) {
            int var = 0;
            for (Field field : kentat) {
                if (!field.toString().contains("final")) {
                    var++;
                }
            }
            assertTrue("et tarvitse " + klassName + "-luokalle kuin oliomuuttujan mitta. Poista ylimääräiset muuttujat", var < 2);
        }
    }

    private String kentta(String toString) {
        return toString.replace(klassName + ".", "");
    }
}
