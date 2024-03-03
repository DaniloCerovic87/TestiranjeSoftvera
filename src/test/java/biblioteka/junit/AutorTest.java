package biblioteka.junit;

import biblioteka.Autor;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AutorTest {

    Autor a;

    @BeforeEach
    void setUp() {
        a = new Autor();
    }

    @AfterEach
    void tearDown() {
        a = null;
    }

    @Test
    void testAutorParametrizovaniKostruktor() {
        a = new Autor("Pera", "Peric");

        assertNotNull(a);
        assertEquals("Pera", a.getIme());
        assertEquals("Peric", a.getPrezime());
    }

    @Test
    void testAutorDefaultniKonstruktor() {
        assertNotNull(a);
        assertNull(a.getIme());
        assertNull(a.getPrezime());
    }

    @Test
    @Order(4)
    @Tag("AutorSeter")
    void testSetIme() {
        a.setIme("Mika");

        assertEquals("Mika", a.getIme());
    }

    @Test
    @Order(3)
    void testSetImeNull() {
        NullPointerException e = assertThrows(NullPointerException.class, () -> a.setIme(null));

        assertEquals("Ime ne sme biti null", e.getMessage());
    }

    @Test
    @Order(2)
    void testSetImePrazanString() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> a.setIme(""));

        assertEquals("Ime ne sme biti prazno", e.getMessage());
    }


    @Test
    @Order(1)
    @Tag("AutorSeter")
    void testSetPrezime() {
        a.setPrezime("Mikic");

        assertEquals("Mikic", a.getPrezime());
    }

    @Test
    void testSetPrezimeNull() {
        NullPointerException e = assertThrows(NullPointerException.class, () -> a.setPrezime(null));

        assertEquals("Prezime ne sme biti null", e.getMessage());
    }

    @Test
    void testSetPrezimePrazanString() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> a.setPrezime(""));

        assertEquals("Prezime ne sme biti prazno", e.getMessage());
    }

    @Test
    void testToString() {
        a.setIme("Zika");
        a.setPrezime("Zikic");

        String s = a.toString();

        assertTrue(s.contains("Zika"));
        assertTrue(s.contains("Zikic"));
    }

    @Test
    void testEqualsObjectIstiObjekat() {
        assertTrue(a.equals(a));
    }

    @Test
    void testEqualsObjectNull() {
        assertFalse(a.equals(null));
    }

    @Test
    void testEqualsObjectDrugaKlasa() {
        assertFalse(a.equals(new Exception()));
    }

    @ParameterizedTest
    @MethodSource("authorMethodSource")
    void testEqualsObject(String ime1, String prezime1, String ime2, String prezime2, boolean ocekivaniRez) {
        a.setIme(ime1);
        a.setPrezime(prezime1);

        Autor a2 = new Autor(ime2, prezime2);

        assertEquals(ocekivaniRez, a.equals(a2));
    }

    static Stream<Arguments> authorMethodSource() {
        return Stream.of(
                Arguments.of("Laza", "Lazic", "Laza", "Lazic", true),
                Arguments.of("Laza", "Lazic", "Mika", "Lazic", false),
                Arguments.of("Laza", "Lazic", "Laza", "Mikic", false),
                Arguments.of("Laza", "Lazic", "Mika", "Mikic", false)
        );
    }
}