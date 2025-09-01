package seleniumTests;

import org.testng.annotations.Test;

import utilities.TestDataLoader;

public class testLoginWithDPDL {

	
	// Using DataProvider from TestDataLoaderDP class
@Test(dataProvider = "loginData", dataProviderClass = TestDataLoader.class)
public void loginTest(String username, String password) {
    System.out.println("Login with: " + username + " / " + password);
    // WebDriver steps
}

}

