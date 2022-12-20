package day7;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class CoreFunctions {
	
	static  WebDriver chromeBrowser;
	
	/*
	 * static {
	 * 
	 * chromeBrowser = new ChromeDriver();
	 * chromeBrowser.get("https://cosmocode.io/automation-practice/");
	 * 
	 * }
	 */
	
	private static void browserCapabilities() {
		
		// EdgeOptions
		//FirefoxOptions
		//SafariOptions
		
		ChromeOptions chromeOptions = new ChromeOptions();
		
		//This will make Selenium Webdriver to wait for the entire page to be loaded.
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		//This capability checks whether an expired (or) invalid TLS certificate is used while navigating during a session.
		chromeOptions.setAcceptInsecureCerts(true);
		
		// Specified when to interrupt an executing Script in a current browsing context.The default timeout 30,000 millisec.
		chromeOptions.setScriptTimeout(Duration.ofSeconds(30));
		
		// Specified the time interval in which web page needs to  be loaded in a current browser context. The default
		chromeOptions.setPageLoadTimeout(Duration.ofMillis(30000));
		
		//This specifies the time to wait for the implicit element location strategy while locating elements. The default
		chromeOptions.setImplicitWaitTimeout(Duration.ofSeconds(10));
		
		//Adding chrome extensions with the webdrivers..
		//chromeOptions.addExtensions(new File("/path/to/extension.crx"));
		
		chromeOptions.addArguments("start-maximized");
		chromeOptions.addArguments("--incognito");		
		//chromeOptions.addArguments("--headless"); // invisible mode of execution.
		//more capabilities at https://sites.google.com/a/chromium.org/chromedriver/capabilities
		
		// WebDriver driver = new ChromeDriver();
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		
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
		
		// driver.close();    // Closes only current tab.
		// driver.quit();      //  Closes all the browser instances / all the tabs.
		
		System.out.println("Current Page Source:"+ driver.getPageSource());
		//  driver.manage().deleteAllCookies();
		
		
	}
	
	public static void selenium101()  throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\valli\\NumpyNinja\\Hello-World\\src\\test\\resources\\drivers\\chromedriver.exe");
		chromeBrowser = new ChromeDriver();
		chromeBrowser.get("https://cosmocode.io/automation-practice/");
		
		WebElement frstNameTxt = chromeBrowser.findElement(By.id("firstname"));
		WebElement lastNameTxt = chromeBrowser.findElement(By.className("lastname"));
		WebElement genderRadio = chromeBrowser.findElement(By.xpath("//input[@value = 'Female']"));
		WebElement ageSelect = chromeBrowser.findElement(By.name("age"));
		
		frstNameTxt.sendKeys("Valli");
		lastNameTxt.sendKeys("Kamarsu");
		genderRadio.click();		
		Select age = new Select(ageSelect);
		age.selectByVisibleText("Under 40");
		
		String languages = "java # python  # vbscript # c # csharp";
		String[] lang = languages.split("#");
		
		for (String l : lang) {
			if(l.trim().equalsIgnoreCase("java")) {
				chromeBrowser.findElement(By.name("language_java")).click();
			}
			else if(l.trim().equalsIgnoreCase("python")) {
				chromeBrowser.findElement(By.name("language_python")).click();
			}
			else if(l.trim().equalsIgnoreCase("csharp")) {
				chromeBrowser.findElement(By.name("language_c#")).click();
			}
			else if(l.trim().equalsIgnoreCase("c")) {
				chromeBrowser.findElement(By.name("language_c")).click();
			}
			else if(l.trim().equalsIgnoreCase("vbscript")) {
				chromeBrowser.findElement(By.name("language_vbs")).click();
			}
		}
		
		/*
		 * String frstNameAttribute = frstNameTxt.getAttribute("maxlength");
		 * System.out.println("First Name Attribute is:"+frstNameAttribute);
		 * 
		 * String frstNameDomAttribute =frstNameTxt.getDomAttribute("maxlength");
		 * System.out.println("First Name DOM Attribute is:"+frstNameDomAttribute);
		 * 
		 * String color =
		 * chromeBrowser.findElement(By.id("submit_htmlform")).getCssValue(
		 * "background-color"); System.out.println("Color of the button is:"+color);
		 * 
		 * Point point = frstNameTxt.getLocation();
		 * System.out.println("For getLocation()");
		 * System.out.println("X coordinate is:"+point.getX());
		 * System.out.println("Y coordinate is:"+point.getY());
		 * 
		 * 
		 * Rectangle rect = frstNameTxt.getRect(); System.out.println("For getRect()");
		 * System.out.println("Height is:"+rect.getHeight());
		 * System.out.println("Width is:"+rect.getWidth());
		 * System.out.println("X coordinate is:"+rect.getX());
		 * System.out.println("Y coordinate is:"+rect.getY());
		 * 
		 * List<WebElement> links = chromeBrowser.findElements(By.partialLinkText("Click"));		
		System.out.println("Total number of links available in the website:" +links.size());
		
		List<WebElement> vLinks = chromeBrowser.findElements(By.partialLinkText("Click"));
				
		if (vLinks.size() > 0 ) {
			//chromeBrowser.findElement(By.partialLinkText("Click")).click();
			System.out.println("Links are available." );
		}
		else {
			System.out.println("There is no such link with the given property avaialble." );
		}
//		 */		
	}
	
	public static void hospName() {
		
		chromeBrowser = new EdgeDriver();
		chromeBrowser.get("https://westbengal.covidsafe.in/");
		
		
		
		int noOfHosp = chromeBrowser.findElements(By.xpath("//tbody/tr")).size();
		
		for(int i=1; i<=noOfHosp;i++) {
			WebElement hospname = chromeBrowser.findElement(By.xpath("//tbody/tr["+i+"]//strong"));
			System.out.println("Name of the Hospital is:"+hospname.getText());
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		//selenium101();
		//browserCapabilities();
		hospName();
	}

}
