package tutorialselenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeSetUP {
	
	private static final Logger log = LogManager.getLogger(ChromeSetUP.class.getName());

	public static void main(String[] args) {
		// http://chromedriver.storage.googleapis.com/index.html
		String baseURL = "http://www.google.com";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "V://chromedriver_win32/chromedriver.exe");
		log.error("unable to set for chrome ");
		driver = new ChromeDriver();
		
		driver.get(baseURL);

	}

}
