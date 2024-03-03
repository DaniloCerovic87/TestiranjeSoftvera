package biblioteka.junit.interfejs;

import biblioteka.Knjiga;
import biblioteka.interfejs.BibliotekaInterfejs;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public abstract class BibliotekaInterfejsTest {

    protected BibliotekaInterfejs b;
    protected Knjiga k1;
    protected Knjiga k2;
    protected Knjiga k3;

    @Test
    void testDodajKnjigu() {
        b.dodajKnjigu(k1);

        List<Knjiga> knjige = b.vratiSveKnjige();

        assertEquals(1, knjige.size());
        assertTrue(knjige.contains(k1));
    }

    @Test
    void testDodajKnjiguViseKnjiga() {
        b.dodajKnjigu(k1);
        b.dodajKnjigu(k2);
        b.dodajKnjigu(k3);

        List<Knjiga> knjige = b.vratiSveKnjige();

        assertEquals(3, knjige.size());
        assertTrue(knjige.contains(k1));
        assertTrue(knjige.contains(k2));
        assertTrue(knjige.contains(k3));
    }

    @Test
    void testDodajKnjiguNull() {
        assertThrows(NullPointerException.class, () -> b.dodajKnjigu(null));
    }

    @Test
    void testdDodajKnjiguDuplikat() {
        b.dodajKnjigu(k1);

        assertThrows(IllegalArgumentException.class, () -> b.dodajKnjigu(k1));
    }

    @Test
    void testObrisiKnjigu() {
        b.dodajKnjigu(k1);
        b.dodajKnjigu(k2);
        b.dodajKnjigu(k3);

        b.obrisiKnjigu(k2);

        List<Knjiga> knjige = b.vratiSveKnjige();

        assertEquals(2, knjige.size());
        assertTrue(knjige.contains(k1));
        assertTrue(knjige.contains(k3));
        assertFalse(knjige.contains(k2));
    }

    @Test
    void testObrisiKnjiguNePostoji() {
        b.dodajKnjigu(k1);
        b.dodajKnjigu(k2);
        b.dodajKnjigu(k3);

        Knjiga k4 = new Knjiga();
        k4.setIsbn(7777);

        b.obrisiKnjigu(k4);

        List<Knjiga> knjige = b.vratiSveKnjige();

        assertEquals(3, knjige.size());
        assertTrue(knjige.contains(k1));
        assertTrue(knjige.contains(k2));
        assertTrue(knjige.contains(k3));
    }

    @Test
    void testObrisiKnjiguNull() {
        b.dodajKnjigu(k1);
        b.dodajKnjigu(k2);
        b.dodajKnjigu(k3);

        b.obrisiKnjigu(null);

        List<Knjiga> knjige = b.vratiSveKnjige();

        assertEquals(3, knjige.size());
        assertTrue(knjige.contains(k1));
        assertTrue(knjige.contains(k2));
        assertTrue(knjige.contains(k3));
    }

    @Test
    void testVratiSveKnjige() {
        List<Knjiga> knjige = b.vratiSveKnjige();

        assertNotNull(knjige);
        assertEquals(0, knjige.size());
    }

    @Test
    void testPronadjiKnjiguNemaKriterijuma() {
        assertThrows(IllegalArgumentException.class, () -> b.pronadjiKnjigu(null, -1, null, null));
    }

    @Test
    void testPronadjiKnjigu() {
        b.dodajKnjigu(k1);
        b.dodajKnjigu(k2);
        b.dodajKnjigu(k3);

        List<Knjiga> rezultat = b.pronadjiKnjigu(null, -1, "PRST", null);
        assertEquals(1, rezultat.size());
        assertTrue(rezultat.contains(k3));
    }

    @Test
    void testPronadjiKnjiguViseKnjiga() {
        b.dodajKnjigu(k1);
        b.dodajKnjigu(k2);
        b.dodajKnjigu(k3);

        List<Knjiga> rezultat = b.pronadjiKnjigu(null, -1, "knjiga", null);
        assertEquals(2, rezultat.size());
        assertTrue(rezultat.contains(k1));
        assertTrue(rezultat.contains(k2));
    }

}