package qa.guru;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleTest {

    @Test
    void assertTest() {
        Assertions.assertTrue(2 > 3);
    }

    @Test
    void assertTest2() {
        Assertions.assertTrue(2 < 3);
    }
}
