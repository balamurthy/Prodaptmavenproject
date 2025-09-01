package seleniumTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {

    @Test
    public void testSoftAssertions() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals("Selenium", "TestNG", "Strings are not equal");
        softAssert.assertTrue(2 > 1, "Condition should be true");
        softAssert.assertNotNull(null, "Object should not be null");

        System.out.println("This line will execute even if above asserts fail.");

        softAssert.assertAll(); // Collates all failures
    }
}