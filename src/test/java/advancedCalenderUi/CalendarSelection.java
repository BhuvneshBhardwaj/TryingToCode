package advancedCalenderUi;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeMethod;

public class CalendarSelection {
	private WebDriver driver;
	private String baseUrl;

	@BeforeMethod
	public void setUp() {

		// defining chrome setup
		baseUrl = "https://www.expedia.com/";
		System.setProperty("webdriver.chrome.driver", "V://chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// test.log(LogStatus.INFO, "Browser Started");
	}
	@Test(enabled = false)
	public void test1() throws Exception {
		driver.get(baseUrl);
		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchElementException.class);
	
		// Click flights tab
		WebElement clickOnFlightTab = fWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='uitk-tab-anchor']")));
		clickOnFlightTab.click();
		// Find departing field
		WebElement departingField = driver.findElement(By.xpath("//button[@aria-label='Going to']"));
		// Click departing field
		departingField.click();
		Thread.sleep(3000);
		// Find the date to be selected
		WebElement dateToSelect = driver
				.findElement(By.xpath("//section[@class='cal-month'][position()=1]//a[text()='31']"));
		// Click the date
		dateToSelect.click();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}