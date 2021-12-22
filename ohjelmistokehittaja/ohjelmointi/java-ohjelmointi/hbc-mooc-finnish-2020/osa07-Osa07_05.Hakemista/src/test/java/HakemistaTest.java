
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.junit.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HakemistaTest {

    @Test
    @Points("07-05.1")
    public void perakkaishakuLoytaaKirjan() throws Throwable {
        ArrayList<Kirja> kirjat = luoKirjoja(5);
        for (int i = 0; i < kirjat.size(); i++) {
            int indeksi = Paaohjelma.perakkaishaku(kirjat, kirjat.get(i).getId());

            assertTrue("Peräkkäishaku ei löytänyt haettua kirjaa vaikka kirja oli listassa. Kokeile hakea indeksiä " + i + " seuraavilla kirjoilla:\n" + kirjat.toString(), i == indeksi);
        }
    }

    @Test
    @Points("07-05.1")
    public void perakkaishakuLoytaaKirjanIso() throws Throwable {
        ArrayList<Kirja> kirjat = luoKirjoja(100);
        for (int i = 0; i < kirjat.size(); i++) {
            int indeksi = Paaohjelma.perakkaishaku(kirjat, kirjat.get(i).getId());

            assertTrue("Peräkkäishaku ei löytänyt haettua kirjaa vaikka kirja oli listassa. Kokeile hakua isolla määrällä kirjoja.", i == indeksi);
        }
    }

    @Test
    @Points("07-05.1")
    public void olematontaKirjaaEiLoydeta() throws Throwable {
        ArrayList<Kirja> kirjat = luoKirjoja(100);
        Set<Integer> idt = kirjat.stream().map(k -> k.getId()).collect(Collectors.toSet());

        for (int i = 0; i < 100; i++) {
            if (idt.contains(i)) {
                continue;
            }

            int indeksi = Paaohjelma.perakkaishaku(kirjat, i);

            assertTrue("Mikäli kirjaa ei löydy, peräkkäishaun tulee palauttaa arvo -1. Nyt peräkkäishaku palautti arvon " + indeksi + " olemattomalle kirjalle.", indeksi == -1);
        }
    }

    @Test
    @Points("07-05.1")
    public void perakkaishakuLoytaaKirjanEiJarjestyksessaOlevastaListasta() throws Throwable {
        ArrayList<Kirja> kirjat = luoKirjoja(100);
        Collections.shuffle(kirjat);
        for (int i = 0; i < kirjat.size(); i++) {
            int indeksi = Paaohjelma.perakkaishaku(kirjat, kirjat.get(i).getId());

            assertTrue("Kun kirjat eivät olleet järjestyksessä, peräkkäishaku ei löytänyt haettua kirjaa vaikka kirja oli listassa. Kokeile hakua isolla määrällä kirjoja.", i == indeksi);
        }
    }

    @Test
    @Points("07-05.2")
    public void binaarihakuLoytaaKirjanYhdenKokoisestaListasta() throws Throwable {
        ArrayList<Kirja> kirjat = luoKirjoja(1);
        int haettavaId = kirjat.get(0).getId();
        int indeksi = Paaohjelma.binaarihaku(kirjat, haettavaId);
        assertTrue("Binäärihaku ei löytänyt kirjaa yhden kirjan kokoisesta listasta vaikka kirja oli listassa. Kokeile binäärihaun toimintaa seuraavalla kirjalla:\n" + kirjat.toString(), indeksi == 0);
    }

    @Test
    @Points("07-05.2")
    public void binaarihakuLoytaaKirjanKahdenKokoisestaListasta() throws Throwable {
        ArrayList<Kirja> kirjat = luoKirjoja(2);
        Collections.sort(kirjat, (k1, k2) -> k1.getId() - k2.getId());

        for (int i = 0; i < kirjat.size(); i++) {
            int indeksi = Paaohjelma.binaarihaku(kirjat, kirjat.get(i).getId());
            assertTrue("Binäärihaku ei löytänyt kirjaa kahden kirjan kokoisesta listasta vaikka kirja oli listassa. Kokeile binäärihaun toimintaa seuraavilla kirjoilla:\n" + kirjat.toString(), indeksi == i);
        }
    }

    @Test
    @Points("07-05.2")
    public void binaarihakuLoytaaKirjanKolmenKokoisestaListasta() throws Throwable {
        ArrayList<Kirja> kirjat = luoKirjoja(3);
        Collections.sort(kirjat, (k1, k2) -> k1.getId() - k2.getId());

        for (int i = 0; i < kirjat.size(); i++) {
            int indeksi = Paaohjelma.binaarihaku(kirjat, kirjat.get(i).getId());
            assertTrue("Binäärihaku ei löytänyt kirjaa kolmen kirjan kokoisesta listasta vaikka kirja oli listassa. Kokeile binäärihaun toimintaa seuraavilla kirjoilla:\n" + kirjat.toString(), indeksi == i);
        }
    }

    @Test
    @Points("07-05.2")
    public void binaarihakuLoytaaKirjanViidenKokoisestaListasta() throws Throwable {
        ArrayList<Kirja> kirjat = luoKirjoja(5);
        Collections.sort(kirjat, (k1, k2) -> k1.getId() - k2.getId());

        for (int i = 0; i < kirjat.size(); i++) {
            int indeksi = Paaohjelma.binaarihaku(kirjat, kirjat.get(i).getId());
            assertTrue("Binäärihaku ei löytänyt kirjaa viiden kirjan kokoisesta listasta vaikka kirja oli listassa. Kokeile binäärihaun toimintaa seuraavanlaisilla kirjoilla:\n" + kirjat.toString(), indeksi == i);
        }
    }

    @Test
    @Points("07-05.2")
    public void binaarihakuLoytaaKirjanSadanKokoisestaListasta() throws Throwable {
        ArrayList<Kirja> kirjat = luoKirjoja(100);
        Collections.sort(kirjat, (k1, k2) -> k1.getId() - k2.getId());

        for (int i = 0; i < kirjat.size(); i++) {
            int indeksi = Paaohjelma.binaarihaku(kirjat, kirjat.get(i).getId());
            assertTrue("Binäärihaku ei löytänyt kirjaa sadan kirjan kokoisesta listasta vaikka kirja oli listassa. Kokeile binäärihakua isommalla kirjamäärällä.", indeksi == i);
        }
    }

    @Test
    @Points("07-05.2")
    public void binaarihakuEiLoydaKirjojaJarjestamattomastaListasta() throws Throwable {
        ArrayList<Kirja> kirjat = luoKirjoja(100);
        Collections.shuffle(kirjat);

        int loydettyja = 0;
        for (int i = 0; i < kirjat.size(); i++) {
            int indeksi = Paaohjelma.binaarihaku(kirjat, kirjat.get(i).getId());

            if (indeksi == i) {
                loydettyja++;
            }
        }

        assertFalse("Binäärihaun ei tule toimia listalla, jota ei ole järjestetty. Nyt binäärihaku toimi järjestämättömällä listalla.", loydettyja > 25);
    }

    @Test
    @Points("07-05.2")
    public void binaarihakuOnNopeampiKuinPerakkaishaku() throws Throwable {
        ArrayList<Kirja> kirjat = luoKirjoja(10000);
        Collections.sort(kirjat, (k1, k2) -> k1.getId() - k2.getId());

        int haettava = 10000001;
        long bhakuStart = System.nanoTime();
        int binaarihakuId = Paaohjelma.binaarihaku(kirjat, haettava);
        long bhakuEnd = System.nanoTime();
        assertTrue("Kun binäärihaku ei löydä haettavaa, tulee metodin palauttaa arvo -1.", binaarihakuId == -1);
        long phakuStart = System.nanoTime();
        int perakkaishakuId = Paaohjelma.perakkaishaku(kirjat, haettava);
        long phakuEnd = System.nanoTime();
        assertTrue("Kun peräkkäishaku ei löydä haettavaa, tulee metodin palauttaa arvo -1.", perakkaishakuId == -1);

        long bhakuAika = bhakuEnd - bhakuStart;
        long phakuAika = phakuEnd - phakuStart;

        assertTrue("Kun haettavia kirjoja on 10000 ja haettavaa kirjaa ei löydy, binäärihaun pitäisi olla merkittävästi nopeampi kuin peräkkäishaku. Nyt ei ollut.", bhakuAika * 2 < phakuAika);
    }

    private static ArrayList<Kirja> luoKirjoja(int montako) {

        Set<Integer> idt = new TreeSet<>();
        Random rnd = new Random();
        while (idt.size() < montako) {
            idt.add(rnd.nextInt(1000000));
        }

        ArrayList<Kirja> kirjat = new ArrayList<>();
        for (Integer id : idt) {
            kirjat.add(new Kirja(id, "nimi " + id));
        }

        return kirjat;
    }
}
