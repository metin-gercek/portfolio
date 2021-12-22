
import fi.helsinki.cs.tmc.edutestutils.Points;
import org.junit.Test;
import org.junit.Rule;
import org.powermock.modules.junit4.rule.PowerMockRule;

import org.powermock.core.classloader.annotations.PrepareForTest;
import static org.junit.Assert.*;
import static org.powermock.api.easymock.PowerMock.*;

@Points("04-02")
@PrepareForTest({EnsimmainenTilisiirtosi.class, Tili.class})
public class EnsimmainenTilisiirtosiTest {

    @Rule
    public PowerMockRule p = new PowerMockRule();

    @Test
    public void testaa() throws Exception {
        Tili matinTili = createMock(Tili.class);
        Tili omaTili = createMock(Tili.class);

        expectNew(Tili.class, "Matin tili", 1000.0).andReturn(matinTili);
        expectNew(Tili.class, "Oma tili", 0.0).andReturn(omaTili);

        matinTili.otto(100.0);
        omaTili.pano(100.0);

        replay(matinTili, Tili.class);
        replay(omaTili, Tili.class);

        try {
            EnsimmainenTilisiirtosi.main(new String[0]);
            verify(matinTili, Tili.class);
            verify(omaTili, Tili.class);

        } catch (Throwable t) {
            String virhe = t.getMessage();
            if (virhe.contains("Matin tili")) {
                fail("luo tili parametreilla \"Matin tili\", 1000.0");
            } else if (virhe.contains("Oma tili")) {
                fail("luo tili parametreilla \"Oma tili\", 0.0");
            } else if (virhe.contains("otto")) {
                fail("luo tili parametreilla \"Matin tili\", 1000.0 ja ota tililtä kertaalleen 100.0");
            } else if (virhe.contains("pano")) {
                fail("luo tili parametreilla  \"Oma tili\", 0.0 ja laita tilille kertaalleen 100.0");
            }
            fail("odottamaton tilanne:\n" + virhe);
        }
    }

    @Test
    public void testaaToString() throws Exception {
        MockInOut mio = new MockInOut("");

        EnsimmainenTilisiirtosi.main(new String[0]);

        String out = mio.getOutput();
        assertTrue("ohjelman tulee tulostaa siirron jälkeen Matin tilin tiedot", out.contains("900.0"));
        assertTrue("ohjelman tulee tulostaa siirron jälkeen oman tilin tiedot", out.contains("100.0"));
        mio.close();

    }
}