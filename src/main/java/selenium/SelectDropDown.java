package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static WebDriver driver;
	public static String browser = "chrome";
	public static String projectPath = System.getProperty("user.dir");
	public static final String chromeDriverPath = projectPath+"\\drivers\\chromedriver.exe";
	public static final String firefoxDriverPath = projectPath+"\\drivers\\firefox.exe";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath); 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		selectByValue();
		selectAllOptions();


	}

	public static void selectByValue(){
		driver.get("https://www.wikipedia.org/");

		WebElement dropDownList = driver.findElement(By.id("searchLanguage"));
		Select dropDown = new Select(dropDownList);
		dropDown.selectByValue("hi");
		dropDown.selectByValue("de");
	}
	
	public static void selectAllOptions(){
		driver.get("https://www.wikipedia.org/");

		WebElement dropDownList = driver.findElement(By.id("searchLanguage"));
		Select dropDown = new Select(dropDownList);
		
		List<WebElement> values = driver.findElements(By.tagName("option"));
		System.out.println("List size: "+values.size());
		
		for (int i = 0; i < values.size(); i++) {
			System.out.println("language: "+values.get(i).getAttribute("lang")+", Value: "+values.get(i).getText());
//			System.out.println("Value: "+values.get(i).getText());
		}
		
		
		
		
	}

}
