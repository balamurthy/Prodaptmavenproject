package chainTestReportTestCases;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;

@Listeners(ChainTestListener.class)


public class ChainTestTC1 {

    @Test
    public void ChainTestTC1Step1() {
        Assert.assertTrue(true);
    }

    @Test
    public void ChainTestTC1Step2() {
        Assert.assertTrue(true);
    }
}
