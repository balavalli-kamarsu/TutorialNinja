package day7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestBrowsers {
	
	public static WebDriver driver;
	
	@Test
	public static void testChromeBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\valli\\NumpyNinja\\Hello-World\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice/");
		
		System.out.println("Current title of the page:"+driver.getTitle());
		System.out.println("Current URL of the page:"+driver.getCurrentUrl());
		
		driver.navigate().to("https://selenium.dev");
		
		System.out.println("Current title of the page:"+driver.getTitle());
		System.out.println("Current URL of the page:"+driver.getCurrentUrl());
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		driver.manage().window().maximize();
		driver.manage().window().minimize();
	}
	
	@Test
	public static void testEdgeBrowser() {
		driver = new EdgeDriver();
		driver.get("https://cosmocode.io/automation-practice/");
		
		System.out.println("Current title of the page:"+driver.getTitle());
		System.out.println("Current URL of the page:"+driver.getCurrentUrl());
		
		driver.navigate().to("https://selenium.dev");
		
		System.out.println("Current title of the page:"+driver.getTitle());
		System.out.println("Current URL of the page:"+driver.getCurrentUrl());
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		driver.manage().window().maximize();
		driver.manage().window().minimize();
	}

	/*
	 * public static void main(String[] args) { testChromeBrowser();
	 * testEdgeBrowser(); }
	 */
}
