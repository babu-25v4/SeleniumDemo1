package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAllLinksOfPage {

	public static WebDriver driver;
	public static String browser = "chrome";
	public static String projectPath = System.getProperty("user.dir");
	public static final String chromeDriverPath = projectPath+"\\drivers\\chromedriver.exe";
	public static final String firefoxDriverPath = projectPath+"\\drivers\\firefox.exe";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath); 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.wikipedia.org/");
		
		getAllPageLinks();
		findAllLinksInBlock();
	}
	
	public static void getAllPageLinks(){
		List<WebElement> pageLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total links: "+pageLinks.size());
		for (int i = 0; i < pageLinks.size(); i++) {
			System.out.println("Link: "+pageLinks.get(i).getText()+", Title: "+pageLinks.get(i).getAttribute("title")+", URL: "+pageLinks.get(i).getAttribute("href"));
		}
	}
	
	public static void findAllLinksInBlock(){		
		WebElement block = driver.findElement(By.xpath("//*[@id='www-wikipedia-org']/div[6]/div[3]"));
		List<WebElement> list = block.findElements(By.tagName("a"));
		System.out.println("Block Size: "+list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Block: "+list.get(i).getText());
		}		
	}
	
	
}
