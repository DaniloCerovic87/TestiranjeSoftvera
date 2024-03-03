package biblioteka.junit;

import org.junit.platform.suite.api.*;

@Suite
@SelectClasses(
        {AutorTest.class}
)
@IncludeTags("AutorSeter")
public class JUnitTestingMethods1 {
}
