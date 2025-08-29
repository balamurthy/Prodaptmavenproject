package extentReportTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.TestListener;
@Listeners(TestListener.class)
public class ExtentTC1 {

    @Test
    public void TC1Step1() {
        Assert.assertTrue(true);
    }

    @Test
    public void TC1Step2() {
        Assert.assertTrue(false);
    }
}
