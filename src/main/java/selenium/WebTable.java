package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

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
		driver.get("https://money.rediff.com/gainers");		

		webTableDataFetch();
	}

	public static void webTableDataFetch(){
		List<WebElement> rowCount = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		List<WebElement> colCount = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td"));
		System.out.println("Row count: "+rowCount.size()+", Col count: "+colCount.size());

		for (int i = 1; i < rowCount.size(); i++) {
			for (int j = 1; j < colCount.size(); j++) {
				String cell = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print("Row- "+i+": "+cell);
			}
			System.out.println();
		}		
	}

}
