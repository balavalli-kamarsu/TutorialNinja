package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class JuiceShopRegister {
	
	public static WebDriver driver = new EdgeDriver();
	String URL = "https://juice-shop.herokuapp.com/#/register";
	
	// Page Object Model.
	By dismissBtn = By.xpath("//button//span[text()='Dismiss']");
	By emailID = By.id("emailControl");
	By passwordTxt = By.id("passwordControl");
	By confirmPassword = By.id("repeatPasswordControl");
	By secQnBox = By.xpath("//div[@id='mat-select-value-1']/span");
	By secQn = By.xpath("//span[text() = 'Your eldest siblings middle name?']");
	By secQnAns = By.id("securityAnswerControl");
	
	@Test
	public void register() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(URL);
		
		driver.findElement(dismissBtn).click();
		driver.findElement(emailID).sendKeys("valli@kamarsu.com");
		driver.findElement(passwordTxt).sendKeys("valli.1234");
		driver.findElement(confirmPassword).sendKeys("valli.1234");
		driver.findElement(secQnBox).click();
		driver.findElement(secQn).click();		
		driver.findElement(secQnAns).sendKeys("valli");
	}

}
