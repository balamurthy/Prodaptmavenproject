package testNGTestCases;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class loginwith {
  @Test(dataProvider = "dp")
  public void dologin(String un, String pw) {
  
	  System.out.println("User name is : " + un + " Password is : " + pw);
	  
  
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
      new Object[] { "abcd", "bjjjj" },
    };
  }
}
