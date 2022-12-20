package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorld { 

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\valli\\NumpyNinja\\Hello-World\\src\\test\\resources\\drivers\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://amazon.com");
		
	}
}
