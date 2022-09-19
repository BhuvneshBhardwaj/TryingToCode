package practice;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplictWait {
	WebDriver driver ;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "V://chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		String baseUrl = "https://www.makemytrip.com/";
		driver.get(baseUrl );
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

	}
	@Test
	public void testingCode() {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement holidayPackages = driverWait.until
				(ExpectedConditions.visibilityOfElementLocated
						(By.xpath("//a[@href='https://www.makemytrip.com/holidays-india/']")));
		holidayPackages.click();
		WebElement destination =  driverWait.until
				(ExpectedConditions.visibilityOfElementLocated(By.id("toCity")));
		destination.click();
		driver.findElement(By.xpath("//input[@type='text' and @xpath='3']")).sendKeys("Himachal");
		driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();
		//fluent wait example 
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
			       .pollingEvery(Duration.ofSeconds(5))
			       .ignoring(NoSuchElementException.class);
			
		
		
	}
	
}
