package biblioteka.testng;

import biblioteka.Autor;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;


public class AutorTest {

    Autor a;

    @BeforeMethod(alwaysRun = true)
    void setUp() {
        a = new Autor();
    }

    @AfterMethod(alwaysRun = true)
    void tearDown() {
        a = null;
    }

    @Test(groups = "konstruktor")
    void testAutorDefaultniKonstruktor() {
        assertNotNull(a);
        assertNull(a.getIme());
        assertNull(a.getPrezime());
    }

    @Test(groups = "konstruktor")
    void testAutorParametrizovaniKonstruktor() {
        a = new Autor("Pera", "Peric");

        assertNotNull(a);
        assertEquals(a.getIme(), "Pera");
        assertEquals(a.getPrezime(), "Peric");
    }

    @Test
    void testSetIme() {
        a.setIme("Mika");

        assertEquals( a.getIme(), "Mika");
    }

    @Test(expectedExceptions = NullPointerException.class)
    void testSetImeNull() {
        a.setIme(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Ime ne sme biti prazno")
    void testSetImePrazanString() {
        a.setIme("");
    }


    @Test
    void testSetPrezime() {
        a.setPrezime("Mikic");

        assertEquals(a.getPrezime(), "Mikic");
    }

    @Test(expectedExceptions = NullPointerException.class, expectedExceptionsMessageRegExp = "Prezime ne sme biti null")
    void testSetPrezimeNull() {
        a.setPrezime(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Prezime ne sme biti prazno")
    void testSetPrezimePrazanString() {
        a.setPrezime("");
    }

    @Test
    void testToString() {
        a.setIme("Zika");
        a.setPrezime("Zikic");

        String s = a.toString();

        assertTrue(s.contains("Zika"));
        assertTrue(s.contains("Zikic"));
    }

    //ostavljen da pada zbog provere soft asserta
    @Test
    void testToStringSoftAssert() {
        SoftAssert softAssert = new SoftAssert();
        a.setIme("Zika");
        a.setPrezime("Zikic");

        String s = a.toString();

        softAssert.assertTrue(s.contains("Pera"));
        softAssert.assertTrue(s.contains("Peric"));
        softAssert.assertAll();
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

    @Test(dataProvider = "authorData")
    void testEqualsObject(String ime1, String prezime1, String ime2, String prezime2, boolean ocekivaniRez) {
        a.setIme(ime1);
        a.setPrezime(prezime1);

        Autor a2 = new Autor(ime2, prezime2);

        assertEquals(ocekivaniRez, a.equals(a2));
    }

    @DataProvider
    Object[][] authorData() {
        return new Object[][]{
                {"Laza", "Lazic", "Laza", "Lazic", true},
                {"Laza", "Lazic", "Mika", "Lazic", false},
                {"Laza", "Lazic", "Laza", "Mikic", false},
                {"Laza", "Lazic", "Mika", "Mikic", false}
        };
    }
}