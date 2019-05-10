package twg.entaxy.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import twg.entaxy.pages.BlockstackBrowser;
import twg.entaxy.pages.LandingPage;

public class BlockstackBrowserTest extends BaseTest{
	
	LandingPage landingPage;
	BlockstackBrowser blockstackBrowser;
	
	@BeforeMethod
	public void beforeMethodInBlockstackBrowser()
	{
		landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.clickOnBlockStack();
	}
	
	@Test
	public void blockstackUsernameValidation() throws InterruptedException
	{
		blockstackBrowser = PageFactory.initElements(driver, BlockstackBrowser.class);
		Thread.sleep(20000);
		blockstackBrowser.evaluateUsername();
	}
}
