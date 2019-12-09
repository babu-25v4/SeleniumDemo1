package selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;

public class WindowAndTabHandles {

	public static WebDriver driver;
	public static String browser = "chrome";
	public static String projectPath = System.getProperty("user.dir");
	public static final String chromeDriverPath = projectPath+"\\drivers\\chromedriver.exe";
	public static final String firefoxDriverPath = projectPath+"\\drivers\\firefox.exe";

	public static String firstWin, secondWin, thirdWin;
	public static Iterator<String> wins;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath); 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.hdfcbank.com");	
		System.out.println("-------------Generating Window id from first window --------------");
		System.out.println("1st win: "+driver.getTitle());
		
		//1st window
		driver.findElement(By.id("loginsubmit")).click();
			
		//2nd window
		System.out.println("-------------Generating Window id from Seconds window --------------");
		Set<String> windows = driver.getWindowHandles();
		/*for (Object object : windows) {
			System.out.println("windows: "+ object.toString());
		}*/
		wins = windows.iterator();
		firstWin = wins.next();
		secondWin = wins.next();
								
		driver.switchTo().window(secondWin);
		System.out.println("2nd win: "+secondWin+", - "+driver.getTitle());
		driver.manage().window().maximize();			
		driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div[1]/div/a")).click();
		driver.findElement(By.xpath("//*[@id='customertab1']/div[1]/div[1]/p[2]/strong/a/span")).click();
		
		//3rd window
		System.out.println("-------------Generating Window id from Third window --------------");
		windows = driver.getWindowHandles();
		wins = windows.iterator();
		firstWin = wins.next();
		secondWin = wins.next();
		thirdWin = wins.next();
				
		driver.switchTo().window(thirdWin);
		System.out.println("3rd win: "+thirdWin+", - "+driver.getTitle());
		
		System.out.println("Is Displayed: "+driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).isDisplayed());
		driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("12345678");
		driver.findElement(By.xpath("//a/img[@alt='continue' and @src='/gif/continue_new1.gif?v=1']")).click();
		
		driver.close();
		driver.switchTo().window(secondWin);
		driver.close();
		driver.switchTo().window(firstWin);
		driver.close();
		System.out.println("------------Done------------");
		
	}
	
}
