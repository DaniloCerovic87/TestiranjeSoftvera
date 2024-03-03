package biblioteka.testng.interfejs;

import biblioteka.Knjiga;
import biblioteka.interfejs.BibliotekaInterfejs;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public abstract class BibliotekaInterfejsTest {

    protected BibliotekaInterfejs b;
    protected Knjiga k1;
    protected Knjiga k2;
    protected Knjiga k3;

    @Test
    void testDodajKnjigu() {
        b.dodajKnjigu(k1);

        List<Knjiga> knjige = b.vratiSveKnjige();

        assertEquals(knjige.size(), 1);
        assertTrue(knjige.contains(k1));
    }

    @Test
    void testDodajKnjiguViseKnjiga() {
        b.dodajKnjigu(k1);
        b.dodajKnjigu(k2);
        b.dodajKnjigu(k3);

        List<Knjiga> knjige = b.vratiSveKnjige();

        assertEquals(knjige.size(), 3);
        assertTrue(knjige.contains(k1));
        assertTrue(knjige.contains(k2));
        assertTrue(knjige.contains(k3));
    }

    @Test(expectedExceptions = NullPointerException.class)
    void testDodajKnjiguNull() {
        b.dodajKnjigu(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void testdDodajKnjiguDuplikat() {
        b.dodajKnjigu(k1);
        b.dodajKnjigu(k1);
    }

    @Test
    void testObrisiKnjigu() {
        b.dodajKnjigu(k1);
        b.dodajKnjigu(k2);
        b.dodajKnjigu(k3);

        b.obrisiKnjigu(k2);

        List<Knjiga> knjige = b.vratiSveKnjige();

        assertEquals(knjige.size(), 2);
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

        assertEquals(knjige.size(), 3);
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

        assertEquals(knjige.size(), 3);
        assertTrue(knjige.contains(k1));
        assertTrue(knjige.contains(k2));
        assertTrue(knjige.contains(k3));
    }

    @Test
    void testVratiSveKnjige() {
        List<Knjiga> knjige = b.vratiSveKnjige();

        assertNotNull(knjige);
        assertEquals(knjige.size(), 0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Morate uneti bar neki kriterijum za pretragu")
    void testPronadjiKnjiguNemaKriterijuma() {
        b.pronadjiKnjigu(null, -1, null, null);
    }

    @Test
    void testPronadjiKnjigu() {
        b.dodajKnjigu(k1);
        b.dodajKnjigu(k2);
        b.dodajKnjigu(k3);

        List<Knjiga> rezultat = b.pronadjiKnjigu(null, -1, "PRST", null);
        assertEquals(rezultat.size(), 1);
        assertTrue(rezultat.contains(k3));
    }

    @Test
    void testPronadjiKnjiguViseKnjiga() {
        b.dodajKnjigu(k1);
        b.dodajKnjigu(k2);
        b.dodajKnjigu(k3);

        List<Knjiga> rezultat = b.pronadjiKnjigu(null, -1, "knjiga", null);
        assertEquals(rezultat.size(), 2);
        assertTrue(rezultat.contains(k1));
        assertTrue(rezultat.contains(k2));
    }

}