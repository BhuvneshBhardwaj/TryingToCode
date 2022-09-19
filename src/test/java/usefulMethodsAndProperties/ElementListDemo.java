package usefulMethodsAndProperties;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementListDemo {

	private WebDriver driver;
	private String baseUrl;
	private GenericMethods gm;

	@BeforeMethod
	public void setUp() throws Exception {
		String baseUrl = "https://letskodeit.teachable.com/pages/practice";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "V://chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		gm = new GenericMethods(driver);
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testMethod() throws Exception {
		driver.get(baseUrl);
		
		List<WebElement> elementList = gm.getElementList("//input[@type='text']", "xpath");
		
		int size = elementList.size();
		System.out.println("Size of the element list is: " + size);
		
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		//driver.quit();
	}
}
