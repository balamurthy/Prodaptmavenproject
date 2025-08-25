package testNGTestCases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrderDemoTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println(">> BeforeSuite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("   >> BeforeTest");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("      >> BeforeMethod");
    }

    @Test(priority = 2)
    public void testA() {
        System.out.println("         Executing Test A (priority=2)");
    }

    @Test(priority = 1)
    public void testB() {
        System.out.println("         Executing Test B (priority=1)");
    }

    @Test(dependsOnMethods = "testB")
    public void testC() {
        System.out.println("         Executing Test C (depends on B)");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("      >> AfterMethod");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("   >> AfterTest");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(">> AfterSuite");
    }
}
