package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

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
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");		

		driver.switchTo().frame("iframeResult");
		/*((JavascriptExecutor) driver).executeScript("myFunction()");*/
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("myFunction()");
		
		//Highlight an web element through javascript 
		js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.id("mySubmit")));
				
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of frames in side frame - iframeResult: "+frames.size());
		for (WebElement webElement : frames) {
			System.out.println("frame id: "+webElement.getAttribute("id"));
		}		
		
		driver.switchTo().defaultContent();
		
		List<WebElement> frames1 = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of frames at default content: "+frames1.size());
		for (WebElement webElement : frames1) {
			System.out.println("frame id: "+webElement.getAttribute("id"));
		}
		
	}
}