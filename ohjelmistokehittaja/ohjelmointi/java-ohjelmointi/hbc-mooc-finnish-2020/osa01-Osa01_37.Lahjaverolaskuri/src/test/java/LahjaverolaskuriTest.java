
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import org.junit.*;
import static org.junit.Assert.*;

@Points("01-37")
public class LahjaverolaskuriTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void test1() {
        laskeeOikein(1200, -1);
    }

    @Test
    public void test2() {
        laskeeOikein(6000, 180);
    }

    @Test
    public void test3() {
        laskeeOikein(30000, 2200);
    }

    @Test
    public void test4() {
        laskeeOikein(55000, 4700);
    }

    @Test
    public void test5() {
        laskeeOikein(199000, 21980);
    }

    @Test
    public void test6() {
        laskeeOikein(201000, 22250);
    }

    @Test
    public void test7() {
        laskeeOikein(1100000, 159100);
    }

    @Test
    public void test8() {
        laskeeOikein(10000000, 1672100);
    }

    private void laskeeOikein(int lahja, double vero) {
        int oldOut = io.getSysOut().length();
        io.setSysIn(lahja + "\n");
        callMain(Lahjaverolaskuri.class);
        String out = io.getSysOut().substring(oldOut);

        assertTrue("et tulosta mitään!", out.length() > 0);

        if (vero < 0) {
            assertTrue("Syötteellä " + lahja + " tulostit \"" + out + "\". Odotettiin \"Ei veroa!\"", out.toLowerCase().contains("ei"));
        } else {
            assertFalse("Syötteellä " + lahja + " tulostit \"" + out + "\". Ei odotettu merkkijonoa \"ei\".", out.toLowerCase().contains("ei"));
            assertTrue("Syötteellä " + lahja + " tulostit \"" + out + "\". Veroksi odotettiin " + vero, out.toLowerCase().contains("" + vero));
        }
    }

    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(kl);
            String[] t = null;
            String x[] = new String[0];
            Method m = ReflectionUtils.requireMethod(kl, "main", x.getClass());
            ReflectionUtils.invokeMethod(Void.TYPE, m, null, (Object) x);
        } catch (Throwable e) {
            fail(kl + "-luokan public static void main(String[] args) -metodi on hävinnyt!");
        }
    }

}
