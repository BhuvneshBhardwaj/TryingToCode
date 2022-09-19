package log4Jocdes;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_TestCase {

	private static final Logger log = LogManager.getLogger(TestNG_TestCase.class.getName());

	@BeforeClass
	public void beforeClass() {
		String  		baseUrl = "https://letskodeit.teachable.com";

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "V://chromedriver_win32/chromedriver.exe");
		log.error("unable to set for chrome ");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@Test
	public void testMethod() throws Exception {
		log.info("This message is from test method");
	}

	@AfterClass
	public void afterClass() {
	}
}