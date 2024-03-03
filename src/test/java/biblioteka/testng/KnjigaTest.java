package biblioteka.testng;

import biblioteka.Autor;
import biblioteka.Knjiga;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.List;

import static org.testng.Assert.*;


public class KnjigaTest {

    Knjiga k;

    @BeforeMethod(alwaysRun = true)
    void setUp() {
        k = new Knjiga();
    }

    @AfterMethod(alwaysRun = true)
    void tearDown() {
        k = null;
    }

    @Test(groups = "konstruktor")
    void testKnjigaDefaultniKonstruktor() {
        assertNotNull(k);
        assertNull(k.getNaslov());
        assertEquals(k.getIsbn(), 0);
        assertNull(k.getAutori());
        assertNull(k.getIzdavac());
        assertEquals(k.getIzdanje(), 0);
    }

    @Test(groups = "konstruktor")
    void testKnjigaParametrizovaniKonstruktor() {
        Autor autor = new Autor("Pera", "Peric");
        List<Autor> autori = List.of(autor);
        k = new Knjiga("Gospodar prstenova", 54321, autori, "PUBLIK PRAKTIKUM", 6);

        assertNotNull(k);
        assertEquals(k.getNaslov(), "Gospodar prstenova");
        assertEquals(k.getIsbn(), 54321);
        assertEquals(k.getAutori().size(), autori.size());
        assertEquals(k.getAutori().iterator().next(), autor );
        assertEquals(k.getIzdavac(), "PUBLIK PRAKTIKUM");
        assertEquals(k.getIzdanje(), 6 );
    }

    @Test
    void testSetNaslov() {
        k.setNaslov("Tom Sojer");

        assertEquals( k.getNaslov(), "Tom Sojer");
    }

    @Test(expectedExceptions = NullPointerException.class, expectedExceptionsMessageRegExp = "Naslov ne sme biti null")
    void testSetNaslovNull() {
        k.setNaslov(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Naslov ne sme biti prazan")
    void testSetNaslovPrazanString() {
        k.setNaslov("");
    }

    @Test
    void testSetIsbn() {
        k.setIsbn(1234);

        assertEquals( k.getIsbn(), 1234);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "ISBN ne sme biti nula niti manji")
    void testSetIsbnNula() {
        k.setIsbn(0);
    }


    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "ISBN ne sme biti nula niti manji")
    void testSetIsbnMinusJedan() {
        k.setIsbn(-1);
    }

    @Test
    void testSetAutori() {
        Autor autor = new Autor("Mika", "Mikic");
        List<Autor> autori = List.of(autor);
        k.setAutori(autori);

        assertEquals(k.getAutori().size(), autori.size());
        assertEquals(k.getAutori().iterator().next(), autor);
    }

    @Test
    void testSetIzdavac() {
        k.setIzdavac("Nova knjiga");

        assertEquals( k.getIzdavac(), "Nova knjiga");
    }

    @Test(expectedExceptions = NullPointerException.class, expectedExceptionsMessageRegExp = "Izdavac ne sme biti null")
    void testSetIzdavacNull() {
        k.setIzdavac(null);
    }


    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Izdavac ne sme biti prazan")
    void testSetIzdavacPrazanString() {
        k.setIzdavac("");
    }

    @Test
    void testSetIzdanje() {
        k.setIzdanje(3);

        assertEquals(k.getIzdanje(), 3);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Izdanje mora biti 1 ili vece")
    void testSetIzdanjeNulaTestNg() {
        k.setIzdanje(0);
    }

    @Test
    void testToString() {
        Autor autor = new Autor("Zika", "Zikic");
        k.setNaslov("Hobit");
        k.setIsbn(6789);
        k.setAutori(List.of(autor));
        k.setIzdavac("Decje novine");
        k.setIzdanje(2);

        String s = k.toString();

        assertTrue(s.contains("Hobit"));
        assertTrue(s.contains("6789"));
        assertTrue(s.contains("[ime=Zika, prezime=Zikic]"));
        assertTrue(s.contains("Decje novine"));
        assertTrue(s.contains("2"));
    }

    @Test
    void testEqualsObjectIstiObjekat() {
        assertTrue(k.equals(k));
    }

    @Test
    void testEqualsObjectNull() {
        assertFalse(k.equals(null));
    }

    @Test
    void testEqualsObjectDrugaKlasa() {
        assertFalse(k.equals(new Exception()));
    }

    @Test(dataProvider = "isbnData")
    void testEqualsObject(long isbn1, long isbn2, boolean ocekivaniRez) {
        k.setIsbn(isbn1);

        Knjiga k2 = new Knjiga();
        k2.setIsbn(isbn2);

        assertEquals(k.equals(k2), ocekivaniRez);
    }

    @DataProvider(name = "isbnData")
    Object[][] isbnData() {
        return new Object[][]{
                {1234, 1234, true},
                {1234, 5678, false}
        };
    }

}
