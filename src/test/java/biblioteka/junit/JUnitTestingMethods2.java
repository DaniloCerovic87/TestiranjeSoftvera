package biblioteka.junit;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses(
        KnjigaTest.class
)
@ExcludeTags("KnjigaKonstruktor")
public class JUnitTestingMethods2 {
}
