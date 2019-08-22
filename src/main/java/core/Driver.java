package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	private static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static final String chromeDriverPath = projectPath+"\\drivers\\chromedriver.exe";
	
	private Driver(){
		
	}	
	
	static{
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
	}
	
	public static WebDriver getDriver(){		
		if(driver == null){
			driver = new ChromeDriver();
		}
		return driver;
	}
		
}
