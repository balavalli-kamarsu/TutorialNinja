package selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class JuiceShopRegisterPF {
	
	public static WebDriver driver = new EdgeDriver();
	String URL = "https://juice-shop.herokuapp.com/#/register";
	
	@FindBy (xpath = "//button//span[text()='Dismiss']") WebElement dismissBtn;
	@FindBy (id = "emailControl") WebElement emailID;
	@FindBy (id = "passwordControl") WebElement passwordTxt;
	@FindBy (id = "repeatPasswordControl") WebElement confirmPassword;
	@FindBy (xpath = "//div[@id='mat-select-value-1']/span") WebElement secQnBox;
	@FindBy (xpath = "//span[text() = 'Your eldest siblings middle name?']") WebElement secQn;
	@FindBy (id = "securityAnswerControl") WebElement secQnAns;
	

	
	@Test
	public void register() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(URL);
		
		PageFactory.initElements(driver, this);
		
		dismissBtn.click();
		emailID.sendKeys("valli@kamarsu.com");
		passwordTxt.sendKeys("valli.1234");
		confirmPassword.sendKeys("valli.1234");
		secQnBox.click();
		secQn.click();		
		secQnAns.sendKeys("valli");
	}

}
