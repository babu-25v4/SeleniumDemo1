package selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseOverAction {

	public static WebDriver driver;
	public static String browser = "chrome";
	public static String projectPath = System.getProperty("user.dir");
	public static final String chromeDriverPath = projectPath+"\\drivers\\chromedriver.exe";
	public static final String firefoxDriverPath = projectPath+"\\drivers\\firefox.exe";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath); 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.google.com");		
		
		driver.findElement(By.name("q")).sendKeys("way2automation");
		driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div/div[2]/div[2]/div[2]/center/input[1]")).click();
		driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div/div/div[1]/a")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='navbar-collapse-1']/ul/li[7]/a")));
		
		WebElement resources = driver.findElement(By.xpath("//*[@id='navbar-collapse-1']/ul/li[7]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(resources).perform();
		driver.findElement(By.xpath("//*[@id='navbar-collapse-1']/ul/li[7]/ul/li[2]/a")).click();
		
		
	}

}
