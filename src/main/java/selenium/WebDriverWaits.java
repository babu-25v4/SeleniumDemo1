package selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaits {

	public static WebDriver driver;
	public static String browser = "chrome";
	public static String projectPath = System.getProperty("user.dir");
	public static final String chromeDriverPath = projectPath+"\\drivers\\chromedriver.exe";
	public static final String firefoxDriverPath = projectPath+"\\drivers\\firefox.exe";
	
	public static void main(String[] args) {
		getDriver();
//		implicitWait();
		driver.get("https://accounts.google.com/signin/v2/identifier?hl=en&continue=https%3A%2F%2Fmail.google.com%2Fmail&service=mail&flowName=GlifWebSignIn&flowEntry=AddSession");
		
		driver.findElement(By.name("identifier")).sendKeys("babu25v4");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		fluentWait("password",20, 2);
		driver.findElement(By.name("password")).sendKeys("hello");
			
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		explicitWaitForElementPresence("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/span/div[1]/div[2]/div[2]/span", 5);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/span/div[1]/div[2]/div[2]/span")).getText());

	}
	
	public static void  implicitWait(){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public static void explicitWaitForElementPresence(String locatorXpath, int waitTimeInSeconds){
		WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locatorXpath)));
	}
	
	public static void fluentWait(String locatorXpath, int waitForSeconds, int pollingSeconds){	
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(waitForSeconds))
				.pollingEvery(Duration.ofSeconds(pollingSeconds))
				.withMessage("User deficed timeout after 30 seconds")
				.ignoring(NoSuchElementException.class)
				.ignoring(ElementNotVisibleException.class);
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(locatorXpath)));
	}
	
	public static WebDriver getDriver(){
		if(browser.equalsIgnoreCase("chrome")){
//			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", chromeDriverPath); 
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.firefox.driver", firefoxDriverPath); 
			driver = new FirefoxDriver();
		}
		return driver;
	}
	
	

}
