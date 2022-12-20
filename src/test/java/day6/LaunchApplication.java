package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchApplication {
	
	public static WebDriver chromeBrowser;
	
	@Test (priority = 1)
	 public static void launchBrowser() {
		 
		// System.getProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		 System.getProperty("webdriver.chrome.driver", "C:\\Users\\valli\\NumpyNinja\\Hello-World\\src\\test\\resources\\drivers\\chromedriver.exe");
		 chromeBrowser = new  ChromeDriver(); // Open the browser
	} 
	
	@Test  (priority = 2, dependsOnMethods = {"launchBrowser"})
     public  static void launchURL() {
		
    	 chromeBrowser.get("https://www.numpyninja.com/contact"); // Launch the URL
	}
	
	@Test (priority = 3)
	public static void enterNames() {
		chromeBrowser.findElement(By.name("first-name")).sendKeys("valli");
		chromeBrowser.findElement(By.name("last-name")).sendKeys("kamarsu");
		chromeBrowser.findElement(By.name("email")).sendKeys("valli.kamarsu@gmail.com");
		
		
	}
	
	@Test (priority = 4)	
	public static void clickButton() {
		chromeBrowser.findElement(By.className("_1Qjd7")).click();
	}

}
