package mail.gmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static final String chromeDriverPath = projectPath+"\\drivers\\chromedriver.exe";

	@BeforeSuite
	public void setUp(){

		if(driver==null){
			System.setProperty("webdriver.chrome.driver", chromeDriverPath); 
			driver = new ChromeDriver();
			driver.get("http://gmail.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		}
	}

	@AfterSuite
	public void tearDown(){
		driver.quit();
	}

}
