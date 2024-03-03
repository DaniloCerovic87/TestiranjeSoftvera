package biblioteka.junit;

import biblioteka.Biblioteka;
import biblioteka.Knjiga;
import biblioteka.junit.interfejs.BibliotekaInterfejsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class BibliotekaTest extends BibliotekaInterfejsTest {

    @BeforeEach
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

    @AfterEach
    void tearDown() {
        b = null;
        k1 = null;
        k2 = null;
        k3 = null;
    }

}