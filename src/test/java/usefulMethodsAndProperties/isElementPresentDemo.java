package usefulMethodsAndProperties;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class isElementPresentDemo {

	private WebDriver driver;
	private String baseUrl;
	private GenericMethods gm;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		gm = new GenericMethods(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testMethod() throws Exception {
		driver.get(baseUrl);
		
		boolean result1 = gm.isElementPresent("name", "id");
		System.out.println("Is Element Present: " + result1);
		
		boolean result2 = gm.isElementPresent("name-not-present", "id");
		System.out.println("Is Element Present: " + result2);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
