package testNGTestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameterExample {
	//Parameters from Testng.xml file
	@Parameters({ "browser" })
		  @Test (groups={"smoketest"})
		  public void f(String b){
		
			  System.out.println("Browser name is : " + b);
  }
}
