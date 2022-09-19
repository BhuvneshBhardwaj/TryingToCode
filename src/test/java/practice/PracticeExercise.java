package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeExercise {
	WebDriver driver;
	String baseUrl;
	@BeforeMethod
	public void setup() {
		baseUrl = "https://letskodeit.teachable.com/";
		System.setProperty("webdriver.chrome.driver", "V://chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		
		
	}
	@Test
	public void executeTest() {
		
		
	}

}
