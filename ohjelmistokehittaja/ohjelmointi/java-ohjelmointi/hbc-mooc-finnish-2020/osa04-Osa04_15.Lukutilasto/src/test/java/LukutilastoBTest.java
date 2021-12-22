
import fi.helsinki.cs.tmc.edutestutils.MockInOut;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;
import static org.powermock.api.easymock.PowerMock.*;

@PrepareForTest({Paaohjelma.class, Lukutilasto.class})
public class LukutilastoBTest {

    Class laskuriLuokka;

    @Rule
    public PowerMockRule p = new PowerMockRule();

    @Points("04-15.4")
    @Test
    public void kaytetaanOlioa() throws Throwable {
        MockInOut mio = new MockInOut("2\n-1\n");

        Lukutilasto summa = createMock(Lukutilasto.class);
        Lukutilasto parilliset = createMock(Lukutilasto.class);
        Lukutilasto parittomat = createMock(Lukutilasto.class);

        //summa.lisaaLuku(2);
        lisaaLukuMock(summa, 2);
        //summa.summa();
        summaMock(summa);
        expectLastCall().andReturn(2);

        // saa summata
        haeLukujenMaara(summa);
        expectLastCall().andReturn(1).anyTimes();

        // saa laskea keskiarvon
        keskiarvo(summa);
        expectLastCall().andReturn(2).anyTimes();

        //parilliset.lisaaLuku(2);
        lisaaLukuMock(parilliset, 2);
        //parilliset.summa();
        summaMock(parilliset);
        expectLastCall().andReturn(2);

        //parittomat.summa();
        summaMock(parittomat);
        expectLastCall().andReturn(0);

        expectNew(Lukutilasto.class).andReturn(summa);
        expectNew(Lukutilasto.class).andReturn(parilliset);
        expectNew(Lukutilasto.class).andReturn(parittomat);

        replay(summa, Lukutilasto.class);
        replay(parilliset, Lukutilasto.class);
        replay(parittomat, Lukutilasto.class);

        try {
            Paaohjelma.main(new String[0]);
            verifyAll();
        } catch (Exception e) {
            fail("Ohjelman tulee lopettaa syötteiden lukeminen kun -1 on syötetty");
        } catch (Throwable t) {
            fail("Ohjelmasi tulee käyttää Lukutilasto-tyyppistä muuttujaa kaikkien lukujen, parillisten lukujen ja parittomien lukujen summan laskemiseen!\n"
                    + "Ohjelman on luotava oliot seuraavassa järjestyksessä: \n"
                    + "  ensin kaikkien summan laskeva olio, \n"
                    + "  sitten parillisten summan laskeva olio \n"
                    + "  ja lopuksi parittomien summan laskeva olio.\n"
                    + "HUOM: älä lisää muuta kuin käyttäjän syöttämiä lukuja Lukutilasto-olioihin\n"
                    + "      lopetusmerkkinä käytettyä lukua -1 ei tule lisätä lukutilastoihin!\n"
                    + "virhe tapahtui käyttäjän syötteellä 2 -1\n"
                    + "lisätietoa virheestä: " + t);
        }
    }

    private void lisaaLukuMock(Object olio, int luku) throws Throwable {
        Method metodi = ReflectionUtils.requireMethod(olio.getClass(), "lisaaLuku", int.class);
        ReflectionUtils.invokeMethod(void.class, metodi, olio, luku);
    }

    private void lisaaLuku(Object olio, int luku) throws Throwable {
        Method metodi = ReflectionUtils.requireMethod(olio.getClass(), "lisaaLuku", int.class);
        ReflectionUtils.invokeMethod(void.class, metodi, olio, luku);
    }

    private double keskiarvo(Object olio) throws Throwable {
        Method metodi = ReflectionUtils.requireMethod(olio.getClass(), "keskiarvo");
        return ReflectionUtils.invokeMethod(double.class, metodi, olio);
    }

    private int haeLukujenMaara(Object olio) throws Throwable {
        Method metodi = ReflectionUtils.requireMethod(olio.getClass(), "haeLukujenMaara");
        return ReflectionUtils.invokeMethod(int.class, metodi, olio);
    }

    private int summa(Object olio) throws Throwable {
        Method metodi = ReflectionUtils.requireMethod(olio.getClass(), "summa");
        return ReflectionUtils.invokeMethod(int.class, metodi, olio);
    }

    private int summaMock(Object olio) throws Throwable {
        Method metodi = ReflectionUtils.requireMethod(olio.getClass(), "summa");
        return ReflectionUtils.invokeMethod(int.class, metodi, olio);
    }
}