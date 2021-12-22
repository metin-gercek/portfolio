
import fi.helsinki.cs.tmc.edutestutils.Points;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.Rule;
import org.powermock.modules.junit4.rule.PowerMockRule;

import org.powermock.core.classloader.annotations.PrepareForTest;
import static org.junit.Assert.*;
import static org.powermock.api.easymock.PowerMock.*;

@Points("04-01")
@PrepareForTest({EnsimmainenTilisi.class, Tili.class})
public class EnsimmainenTilisiTest {

    @Rule
    public PowerMockRule p = new PowerMockRule();

    @Test
    public void testaa() throws Exception {
        Tili tiliMock = createMock(Tili.class);

        expectNew(Tili.class, EasyMock.anyObject(String.class), EasyMock.eq(100.0)).andReturn(tiliMock);

        tiliMock.pano(20.0);
        replay(tiliMock, Tili.class);

        try {
            EnsimmainenTilisi.main(new String[0]);
            verify(tiliMock, Tili.class);

        } catch (Throwable t) {
            String virhe = t.getMessage();
            if (virhe.contains("pano")) {
                fail("luo tili ja kutsu tilille metodia pano parametrilla 20");
            } else if (virhe.contains("constructor")) {
                fail("laita tilin luomisessa konstruktorin parametriksi 100.0");
            } else if (virhe.contains("saldo")) {
                fail("Ohjelman tulee tulostaa tili kutsumalla System.out.println(tili); tili on tässä tilimuuttujan nimi. " + virhe);
            }
            fail("odottamaton tilanne:\n" + virhe);
        }
    }

    @Test
    public void testaaToString() throws Exception {
        MockInOut mio = new MockInOut("");

        EnsimmainenTilisi.main(new String[0]);

        String out = mio.getOutput();
        assertTrue("ohjelman tulee tulostaa tili, eli kutsua System.out.println(tili); tili on tässä tilimuuttujan nimi", out.contains("120.0"));
        mio.close();

    }
}
