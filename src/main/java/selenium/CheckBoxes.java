package selenium;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxes {

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
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");		
		
		WebElement block = driver.findElement(By.xpath("//tr/td/div[4]"));
		checkAllCheckBoxesInBlock(block);					
	}
	
	public static void checkAllCheckBoxesInBlock(WebElement block){
		List<WebElement> checkBoxes = block.findElements(By.name("sports"));
		System.out.println("Total checkboxes: "+checkBoxes.size());
		for (WebElement checkbox : checkBoxes) {
			checkbox.click();
		}	
	}
	
	public static void checkCheckbox(){
		for (int i = 1; i <= 4; i++) {
			driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
		}
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
