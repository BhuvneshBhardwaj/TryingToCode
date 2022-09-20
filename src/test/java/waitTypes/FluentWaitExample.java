package waitTypes;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FluentWaitExample {

	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		String baseUrl = "https://courses.letskodeit.com/practice";
		System.setProperty("webdriver.chrome.driver", "V://chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	@Test
	public void test() throws InterruptedException {

		//
		// WebElement searchBox = driver.findElement(By.id("search-courses"));
		// searchBox.sendKeys("python");
		// Get the handle
		
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent Handle: " + parentHandle);

		// Find Open Window button
		  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(30))
			       .pollingEvery(Duration.ofSeconds(5))
			       .ignoring(NoSuchElementException.class);
		WebElement openWindow = driver.findElement(By.id("openwindow"));
		openWindow.click();

		// Get all handles
		Set<String> handles = driver.getWindowHandles();

		// Switching between handles
		for (String handle : handles) {
			System.out.println(handle);
		}

		// Switch back to the parent window
	}

	@AfterMethod
	public void tearDown() throws Exception {
		//driver.close();
	}
}
