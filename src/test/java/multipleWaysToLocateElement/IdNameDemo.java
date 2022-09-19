package multipleWaysToLocateElement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import tutorialselenium.ChromeSetUP;

public class IdNameDemo {

	private static final Logger log = LogManager.getLogger(ChromeSetUP.class.getName());
	public static void main(String[] args) {
		WebDriver driver;
		driver = new FirefoxDriver();
		String baseURL = "http://www.google.com";
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		driver.findElement(By.id("lst-ib")).sendKeys("letskodeit");		
		driver.findElement(By.name("btnG")).click();
	}

}
