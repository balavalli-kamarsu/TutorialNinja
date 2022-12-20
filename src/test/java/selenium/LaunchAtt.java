package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchAtt {
	
	public static WebDriver chromeBrowser;
	
	@Test	(priority = 1)
	public  void launchBrowser() {		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\valli\\NumpyNinja\\Hello-World\\src\\test\\resources\\drivers\\chromedriver.exe");
		chromeBrowser = new ChromeDriver();		
	}

	@Test (priority = 2, dependsOnMethods = {"launchBrowser"})
	public  void launchUrl() {		
		chromeBrowser.get("https://www.numpyninja.com/contact");		
	}
	
	@Test  (priority = 3)
	public  void enterNames() {
		
		chromeBrowser.findElement(By.name("first-name")).sendKeys("valli");
		chromeBrowser.findElement(By.name("last-name")).sendKeys("kamarsu");
		chromeBrowser.findElement(By.name("email")).sendKeys("valli.kamarsu@gmail.com");
	}
	
	@Test (priority = 4)
	public void click() {
		chromeBrowser.findElement(By.className("_1fbEI")).click();
	}

}
