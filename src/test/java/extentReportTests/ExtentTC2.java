package extentReportTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.TestListener;
@Listeners(TestListener.class)
public class ExtentTC2 {

    @Test
    public void TC2Step1() {
        Assert.assertTrue(true);
    }

    @Test
    public void TC2Step2() {
        Assert.assertTrue(false);
    }
}
