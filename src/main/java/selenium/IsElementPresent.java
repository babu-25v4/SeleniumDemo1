package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsElementPresent {
	public static WebDriver driver;
	public static String browser = "chrome";
	public static String projectPath = System.getProperty("user.dir");
	public static final String chromeDriverPath = projectPath+"\\drivers\\chromedriver.exe";
	public static final String firefoxDriverPath = projectPath+"\\drivers\\firefox.exe";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath); 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.wikipedia.org/");
		
		System.out.println("Is Element Present: "+isElementPresent("//*[@id='www-wikipedia-org']/h1abs"));
			
		
	}
		
	public static boolean isElementPresent(String xpath){
		try{
			/*driver.findElement(By.xpath(xpath));
			return true;*/
			int size = driver.findElements(By.xpath(xpath)).size();
			if(size >0 ){
				return true;
			}else{
				return false;
			}
		}catch (NoSuchElementException e) {
			return false;
		}catch (Exception e) {
			return false;
		}
	}
	
}
