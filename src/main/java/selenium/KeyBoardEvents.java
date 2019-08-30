package selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardEvents {

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
		driver.get("https://accounts.google.com/signin/v2/identifier?hl=en&continue=https%3A%2F%2Fmail.google.com%2Fmail&service=mail&flowName=GlifWebSignIn&flowEntry=AddSession");		

		driver.findElement(By.name("identifier")).sendKeys("way2automation");
		System.out.println("-------1---------");
//		driver.findElement(By.xpath("//*[@id='yDmH0d']/div[1]/div[2]")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]")).click();
		System.out.println("-------2---------");
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		driver.findElement(By.name("identifier")).click();
		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
		/*action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.chord(Keys.CONTROL,"a")).build().perform();
		action.sendKeys(Keys.chord(Keys.CONTROL,"c")).build().perform();
		
		driver.findElement(By.name("identifier")).click();
		action.sendKeys(Keys.chord(Keys.CONTROL,"v")).build().perform();		
*/
	}
	
}
