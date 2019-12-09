package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics1 {

	@AfterTest
	public void closeDBConnection(){
		System.out.println("Close DB connection");
	}
	
	@BeforeTest
	public void createDBConn(){
		System.out.println("Create DB connection...");
	}
	
	@AfterMethod
	public void closeBrowser(){
		System.out.println("Close browser...");
	}
	
	@BeforeMethod
	public void launchBrowser(){
		System.out.println("Launching browser");
	}
	
	@Test(priority = 2)
	public void testOne(){
		System.out.println("Executing Test 1");
	}
	
	@Test(priority = 1)
	public void testTwo(){
		System.out.println("Executing Test 2");
	}
	
}
