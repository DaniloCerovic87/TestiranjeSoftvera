package biblioteka.testng;

import biblioteka.Biblioteka;
import biblioteka.Knjiga;
import biblioteka.testng.interfejs.BibliotekaInterfejsTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BibliotekaTest extends BibliotekaInterfejsTest {

    @BeforeMethod(alwaysRun = true)
    void setUp() {
        b = new Biblioteka();

        k1 = new Knjiga();
        k1.setIsbn(1234);
        k1.setNaslov("Knjiga 1");

        k2 = new Knjiga();
        k2.setIsbn(8768);
        k2.setNaslov("Knjiga 2");

        k3 = new Knjiga();
        k3.setIsbn(9999);
        k3.setNaslov("Gospodar prstenova");
    }

    @AfterMethod(alwaysRun = true)
    void tearDown() {
        b = null;
        k1 = null;
        k2 = null;
        k3 = null;
    }

}