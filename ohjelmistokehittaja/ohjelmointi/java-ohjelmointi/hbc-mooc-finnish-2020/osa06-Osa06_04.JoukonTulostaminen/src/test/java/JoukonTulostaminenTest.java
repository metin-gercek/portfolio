
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.UUID;
import org.junit.*;
import static org.junit.Assert.*;

public class JoukonTulostaminenTest {

    @Rule
    public MockStdio io = new MockStdio();
    
    @Test
    @Points("06-04")
    public void toStringEiTulostaMitaan() throws Throwable {
        String out = io.getSysOut();
        
        Joukko j = new Joukko("test");
        j.toString();
        j.lisaa("eka");
        j.toString();
        j.lisaa("toka");
        j.toString();
        j.lisaa("kolmas");
        j.toString();
        
        assertEquals("Metodin toString ei tule tulostaa mitään. Sen tulee palauttaa oliota kuvaava merkkijono.", out, io.getSysOut());
    }
    
    @Test
    @Points("06-04")
    public void tyhjaJoukko() throws Throwable {
        Joukko j = new Joukko("test");
        assertEquals("Kun koodi oli:\nJoukko j = new Joukko(\"test\");\nSystem.out.println(j);\nOdotettiin tulostusta: \"Joukko test on tyhjä.\".\nNyt tulostus oli: \"" + j.toString() + "\".", "Joukko test on tyhjä.", j.toString());

        j = new Joukko("joukko");
        assertEquals("Kun koodi oli:\nJoukko j = new Joukko(\"joukko\");\nSystem.out.println(j);\nOdotettiin tulostusta: \"Joukko joukko on tyhjä.\".\nNyt tulostus oli: \"" + j.toString() + "\".", "Joukko joukko on tyhjä.", j.toString());
    }
    
    @Test
    @Points("06-04")
    public void yhdenAlkionJoukko() throws Throwable {
        String out = io.getSysOut();
        
        Joukko j = new Joukko("test");
        j.lisaa("eka");
        assertEquals("Kun koodi oli:\nJoukko j = new Joukko(\"test\");\nj.lisaa(\"eka\");\nSystem.out.println(j);\nOdotettiin tulostusta:\nJoukossa test on 1 alkio:\neka\n\nNyt tulostus oli:\n" + j.toString() + "", "Joukossa test on 1 alkio:\neka", j.toString().trim());

        j = new Joukko("joukko");
        j.lisaa("alkio");
        assertEquals("Kun koodi oli:\nJoukko j = new Joukko(\"joukko\");\nj.lisaa(\"alkio\");\nSystem.out.println(j);\nOdotettiin tulostusta:\nJoukossa joukko on 1 alkio:\nalkio\n\nNyt tulostus oli:\n" + j.toString() + "", "Joukossa joukko on 1 alkio:\nalkio", j.toString());
    }
    
    @Test
    @Points("06-04")
    public void kahdenTaiUseammanAlkionJoukko() throws Throwable {
        String out = io.getSysOut();
        
        String joukonNimi = "joukko-" + UUID.randomUUID().toString().substring(0, 3);
        String ekaAlkio = "alkio-" + UUID.randomUUID().toString().substring(0, 3);
        String tokaAlkio = "alkio-" + UUID.randomUUID().toString().substring(0, 3);
        
        Joukko j = new Joukko(joukonNimi);
        j.lisaa(ekaAlkio);
        j.lisaa(tokaAlkio);
        assertEquals("Kun koodi oli:\nJoukko j = new Joukko(\"" + joukonNimi + "\");\nj.lisaa(\"" + ekaAlkio + "\");\nj.lisaa(\"" + ekaAlkio + "\");\nSystem.out.println(j);\nOdotettiin tulostusta:\nJoukossa " + joukonNimi +" on 2 alkiota:\n" + ekaAlkio + "\n" + tokaAlkio + "\n\nNyt tulostus oli:\n" + j.toString() + "", "Joukossa " + joukonNimi +" on 2 alkiota:\n" + ekaAlkio + "\n" + tokaAlkio, j.toString().trim());
    }

}
