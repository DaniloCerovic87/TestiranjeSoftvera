package biblioteka.junit;

import biblioteka.Autor;
import biblioteka.Knjiga;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KnjigaTest {

    Knjiga k;

    @BeforeEach
    void setUp() {
        k = new Knjiga();
    }

    @AfterEach
    void tearDown() {
        k = null;
    }

    @Test
    @Tag("KnjigaKonstruktor")
    void testKnjigaDefaultniKonstruktor() {
        assertNotNull(k);
        assertNull(k.getNaslov());
        assertEquals(0, k.getIsbn());
        assertNull(k.getAutori());
        assertNull(k.getIzdavac());
        assertEquals(0, k.getIzdanje());
    }

    @Test
    @Tag("KnjigaKonstruktor")
    void testKnjigaParametrizovaniKonstruktor() {
        Autor autor = new Autor("Pera", "Peric");
        List<Autor> autori = List.of(autor);
        k = new Knjiga("Gospodar prstenova", 54321, autori, "PUBLIK PRAKTIKUM", 6);

        assertNotNull(k);
        assertEquals("Gospodar prstenova", k.getNaslov());
        assertEquals(54321, k.getIsbn());
        assertEquals(autori.size(), k.getAutori().size());
        assertEquals(autor, k.getAutori().iterator().next());
        assertEquals("PUBLIK PRAKTIKUM", k.getIzdavac());
        assertEquals(6, k.getIzdanje());
    }

    @Test
    void testSetNaslov() {
        k.setNaslov("Tom Sojer");

        assertEquals("Tom Sojer", k.getNaslov());
    }

    @Test
    void testSetNaslovNull() {
        NullPointerException e = assertThrows(NullPointerException.class, () -> k.setNaslov(null));

        assertEquals("Naslov ne sme biti null", e.getMessage());
    }

    @Test
    void testSetNaslovPrazanString() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> k.setNaslov(""));

        assertEquals("Naslov ne sme biti prazan", e.getMessage());
    }

    @Test
    void testSetIsbn() {
        k.setIsbn(1234);

        assertEquals(1234, k.getIsbn());
    }

    @Test
    void testSetIsbnNula() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> k.setIsbn(0));

        assertEquals("ISBN ne sme biti nula niti manji", e.getMessage());
    }


    @Test
    void testSetIsbnMinusJedan() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> k.setIsbn(-1));

        assertEquals("ISBN ne sme biti nula niti manji", e.getMessage());
    }

    @Test
    void testSetAutori() {
        Autor autor = new Autor("Mika", "Mikic");
        List<Autor> autori = List.of(autor);
        k.setAutori(autori);

        assertEquals(autori.size(), k.getAutori().size());
        assertEquals(autor, k.getAutori().iterator().next());
    }

    @Test
    void testSetIzdavac() {
        k.setIzdavac("Nova knjiga");

        assertEquals("Nova knjiga", k.getIzdavac());
    }

    @Test
    void testSetIzdavacNull() {
        NullPointerException e = assertThrows(NullPointerException.class, () -> k.setIzdavac(null));

        assertEquals("Izdavac ne sme biti null", e.getMessage());
    }

    @Test
    void testSetIzdavacPrazanString() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> k.setIzdavac(""));

        assertEquals("Izdavac ne sme biti prazan", e.getMessage());
    }

    @Test
    void testSetIzdanje() {
        k.setIzdanje(3);

        assertEquals(3, k.getIzdanje());
    }

    @Test
    void testSetIzdanjeNula() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> k.setIzdanje(0));

        assertEquals("Izdanje mora biti 1 ili vece", e.getMessage());
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

    @ParameterizedTest
    @CsvSource({
            "1234, 1234, true",
            "1234, 5678, false"
    })
    void testEqualsObject(long isbn1, long isbn2, boolean ocekivaniRez) {
        k.setIsbn(isbn1);

        Knjiga k2 = new Knjiga();
        k2.setIsbn(isbn2);

        assertEquals(ocekivaniRez, k.equals(k2));
    }
}
