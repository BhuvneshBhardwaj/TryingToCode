package practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LetsCodeIt {
	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;

	@BeforeMethod
	public void setUp() {
		reports = new ExtentReports("V://report.html");
		test = reports.startTest("Test has been started");
		// defining chrome setup
		String baseUrl = "https://courses.letskodeit.com/practice";
		System.setProperty("webdriver.chrome.driver", "V://chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Browser Started");
	}

	@Test
	public void testMethodCheckBoxes() throws InterruptedException {
		boolean isChecked = false;
		// Radio Buttons
		driver.findElement(By.id("bmwradio")).click();
		driver.findElement(By.xpath("//input[@id='benzradio']")).click();
		// clicking every element single time
		List<WebElement> radioButtons = driver
				.findElements(By.xpath("//input[@type='radio' and contains(@name,'cars')]"));
		int sizeOfRadioButtons = radioButtons.size();
		for (int i = 0; i < sizeOfRadioButtons; i++) {
			radioButtons.get(i).click();
		}
		// single drop downs
		Select select = new Select(driver.findElement(By.id("carselect")));
		// Simple Way
		select.selectByIndex(1);
		select.selectByIndex(0);
		select.selectByIndex(2);

		List<WebElement> selectAllOptions = select.getOptions();
		int selectAllOptionsSize = selectAllOptions.size();
		for (int i = 0; i < selectAllOptionsSize; i++) {
			// selectAllOptions.get(2).click();
			// multiple select example
		}
		// Multiple Select
		Select selectMultiple = new Select(driver.findElement(By.xpath("//select[@id='multiple-select-example']")));
		selectMultiple.selectByValue("orange");

		// checkboxes
		List<WebElement> checkboxesList = driver
				.findElements(By.xpath("//input[@type='checkbox' and contains(@name, 'cars')]"));
		int noOFcheckboxes = checkboxesList.size();
		for (int i = 0; i < noOFcheckboxes; i++) {
			checkboxesList.get(i).click();

			// Switching to alerts and Explicit wait
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement textBox = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
			// textBox.click();
			textBox.sendKeys("Bhuvnesh");
			driver.findElement(By.id("confirmbtn")).click();
			// driver.switchTo().alert().accept();
			driver.switchTo().alert().dismiss();
			test.log(LogStatus.INFO, "The test has ended");
		}
	}

	@AfterMethod
	public void close() {
		driver.close();
		reports.endTest(test);
		reports.flush();
	}

}
