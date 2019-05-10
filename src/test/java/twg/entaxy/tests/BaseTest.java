package twg.entaxy.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import twg.entaxy.constants.Constants;
import twg.entaxy.utils.ReadProperties;

public class BaseTest implements Constants {

	WebDriver driver;
	ReadProperties config;

	@Parameters({ "browser" })
	@BeforeMethod
	public void setUpInParent(@Optional(browser_name) String browser) {
		config = new ReadProperties(config_file_path);
		String chrome_path = config.getPropertyValue(browser_name);
		String url_location = config.getPropertyValue(browser_url);
		if (browser.equalsIgnoreCase(browser_name)) {
			System.setProperty(webdriver_chrome_driver, chrome_path);
			driver = new ChromeDriver();
		}
		driver.get(url_location);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethodInBaseTest() {
		driver.quit();
	}

}
