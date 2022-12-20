package assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TutorialsNinja {
	
	public  WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\valli\\NumpyNinja\\Hello-World\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
//		driver = new EdgeDriver();
		driver.get("http://tutorialsninja.com/demo/index.php ");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test (priority =1)
	public void currencyEuroTest() throws InterruptedException {	
		
		// Go to the currency in the top left corner and select Euro
		driver.findElement(By.xpath("//span[text() = 'Currency']")).click();
		Thread.sleep(500);
		
		driver.findElement(By.name("EUR")).click();
		Thread.sleep(500);
	}
	
	@Test  (priority =2)
	public  void searchCameraTest() throws InterruptedException {
		
		// Go to search box in the application and search for canon EOS 5 D camera
		WebElement search = driver.findElement(By.name("search"));
		Thread.sleep(500);
		
		search.sendKeys("canon EOS 5D");
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//a[text()='Canon EOS 5D']/../../..//span[text()='Add to Cart']")).click();
     	Thread.sleep(500);
     	
     	driver.findElement(By.id("button-cart")).click();
     	WebElement errorMsg = driver.findElement(By.xpath("//div[text()='Select required!']"));
       	System.out.println("Error Message:"+errorMsg.getText());		
	}	

	@Test (priority = 3)
	public void selectIphone() throws InterruptedException {
		// Go back to Home screen.
		driver.findElement(By.linkText("Your Store")).click();
		Thread.sleep(1000);
		
		// Click on iPhone.
		driver.findElement(By.linkText("iPhone")).click();
		Thread.sleep(1000);
		
		// Change quantity to two
		WebElement quantity = driver.findElement(By.id("input-quantity"));
		quantity.clear();
		quantity.sendKeys("2");
		Thread.sleep(1000);
		
		//Add to cart
		driver.findElement(By.xpath("//button[@id='button-cart']")).click();
		Thread.sleep(1000);
		
		//5.	Print the success message in the console
		WebElement successAlert = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-dismissible")));
		String message = successAlert.getText();
		System.out.println(message);
	}	

	@Test (priority = 4)
	public void viewCartTest() throws InterruptedException {
		
		//click on cart icon
		driver.findElement(By.xpath("//button//span[@id='cart-total']")).click();
		Thread.sleep(1000);
		
		// click on view cart
		driver.findElement(By.linkText("View Cart")).click();
	}
	
	@Test (priority = 5)
	public void updateQuantityTest() throws InterruptedException {
		
		//Change the quantity of iPhone  to 3
		driver.findElement(By.xpath("//a[text()='iPhone']/../..//input")).clear();
		driver.findElement(By.xpath("//a[text()='iPhone']/../..//input")).sendKeys("3");
		
		// Click update Button.
		driver.findElement(By.xpath("//button[@data-original-title='Update']")).click();
		Thread.sleep(1000);
	}
		
	@Test (priority = 6)
	public void printTaxTest() throws InterruptedException {
		
		// Print Eco tax 
		String ecoTax = driver.findElement(By.xpath("//strong[text()='Eco Tax (-2.00):']/../..//td[2]")).getText();
		System.out.println("ECO Tax is :" +ecoTax);
		
		// Print VAT amount
		String vatAmount = driver.findElement(By.xpath("//strong[text()='VAT (20%):']/../..//td[2]")).getText();		
		System.out.println("VAT amount is:"+vatAmount);
		Thread.sleep(1000);
		
		//Click Checkout button.
		driver.findElement(By.linkText("Checkout")).click();
	}
	
	@Test (priority = 7)
	public void errorMsgRemove() throws InterruptedException {
		
		// Print error message.
		WebElement message = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		System.out.println("Error message after checking out:" +message.getText());
		
		// Remove the product from the cart.
		driver.findElement(By.xpath("//button[@data-original-title='Remove']")).click();
		Thread.sleep(1000);
	}
	
	@Test (priority = 8)
	public void macBookTest() throws InterruptedException {
		
		// Go back to Home screen.
		driver.findElement(By.linkText("Continue")).click();
		//driver.findElement(By.linkText("Your Store")).click();
		Thread.sleep(1000);
		
		// Click on Macbook.
		driver.findElement(By.xpath("//a[text()='MacBook']")).click();
		//driver.findElement(By.linkText("MacBook")).click();
		Thread.sleep(1000);
		
		// Check quantity of the product MacBook is 1.
		String quantity = driver.findElement(By.id("input-quantity")).getAttribute("value");
		
		if(quantity == "1") {			
		}
		
		//Add to cart
		driver.findElement(By.id("button-cart")).click();
		Thread.sleep(1000);
			
		//Print the success message in the console
		WebElement successAlert = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-dismissible")));
		String message = successAlert.getText();
		System.out.println(message);			
	}
	
	@Test (priority = 9)
	public void enterCouponCodeTest() throws InterruptedException {
		
		//click on Shopping Cart. 
		driver.findElement(By.linkText("Shopping Cart")).click();
		Thread.sleep(1000);
		
		// Enter coupon code.
		driver.findElement(By.xpath("//a[@class='accordion-toggle']")).click();
		Thread.sleep(1000);
		
		String couponCode = "ABCD123";
		driver.findElement(By.id("input-coupon")).sendKeys(couponCode);
		driver.findElement(By.id("button-coupon")).click();
		Thread.sleep(1000);
		
		// Print error message.
		WebElement message = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		System.out.println("Error message after checking out:" +message.getText());
	}

	@Test (priority = 10)
	public void enterGiftCertTest() throws InterruptedException {
		
		// Enter coupon code.
		driver.findElement(By.xpath("//a[text()='Use Gift Certificate ']")).click();
		Thread.sleep(1000);
				
		String giftCertificate = "AXDFGH123";
		driver.findElement(By.id("input-voucher")).sendKeys(giftCertificate);
		driver.findElement(By.id("button-voucher")).click();
		Thread.sleep(1000);
				
		// Print error message.
		WebElement successAlert = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-dismissible")));
		String message = successAlert.getText();
		System.out.println(message);
		
	}

	@Test (priority = 11)
	public void clearValuesCheckoutTest() throws InterruptedException {
		
		// Clear coupon code value and gift certificate value
		Thread.sleep(2000);
		driver.findElement(By.id("input-voucher")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Coupon Code')]/i")).click();
		
	     new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.name("coupon")));
        driver.findElement(By.name("coupon")).clear();
		Thread.sleep(2000);
		
		//Click Checkout button.
		driver.findElement(By.linkText("Checkout")).click();
		Thread.sleep(3000);		
	}

	@Test(priority = 12)
	public void registerDetailsTest( ) throws InterruptedException {
		
		//Click on Register account and continue
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value = 'register']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("button-account")).click();
		Thread.sleep(1000);
		
		// enter values
		driver.findElement(By.id("input-payment-firstname")).sendKeys("Valli");
		driver.findElement(By.id("input-payment-lastname")).sendKeys("Kamarsu");
		driver.findElement(By.id("input-payment-email")).sendKeys("vk12347587345676789@gmail.com");
		driver.findElement(By.id("input-payment-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-payment-password")).sendKeys("abc123");
		driver.findElement(By.id("input-payment-confirm")).sendKeys("abc123");
		driver.findElement(By.id("input-payment-address-1")).sendKeys("5 Diggins court");
		driver.findElement(By.id("input-payment-city")).sendKeys("Hartford");
		driver.findElement(By.id("input-payment-postcode")).sendKeys("09876");
		
		new Select(driver.findElement(By.id("input-payment-country"))).selectByVisibleText("United States");
		Thread.sleep(1000);
		
		new Select(driver.findElement(By.id("input-payment-zone"))).selectByVisibleText("Connecticut");
		Thread.sleep(1000);
		
		driver.findElement(By.name("agree")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='button-register']")).click();
	}
	
	@Test (priority = 13)
	public  void commentsErrorMsgTest() throws InterruptedException {
		
		// Add comments
		driver.findElement(By.name("comment")).sendKeys("Adding comments.");
		Thread.sleep(1000);		
		
		// Agreeing to the conditions by selecting checkbox.
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		Thread.sleep(1000); 
		
		// Print Error msg.
		driver.findElement(By.id("button-payment-method")).click();
		System.out.println(driver.findElement(By.className("alert-dismissible")).getText());
		
	}
	
	@Test (priority = 14)
	public void contactUsTest() throws InterruptedException {
		
		//Click on contact us hyperlink 
		driver.findElement(By.linkText("Contact Us")).click();
		Thread.sleep(2000);
		
		// submit a contact request
		driver.findElement(By.id("input-enquiry")).sendKeys("Enquiry here");
		driver.findElement(By.className("btn-primary")).click();
		Thread.sleep(2000);
		
		// click continue
		driver.findElement(By.linkText("Continue")).click();
	}

}
	




