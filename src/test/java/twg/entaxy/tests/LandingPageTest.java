package twg.entaxy.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import twg.entaxy.pages.LandingPage;

public class LandingPageTest extends BaseTest{
	
	LandingPage lPage;
	
	@BeforeMethod
	public void beforeMethodInLandingPage()
	{
		lPage = PageFactory.initElements(driver, LandingPage.class);
	}
	
	@Test
	public void testFeedbackEmail()
	{
		lPage.submitFeedback("Feedback title", "email@gmail.com", "Feedback Message");
		lPage.clickOnFeedBackElement();
		String feedbackEmail = lPage.getFeedbackEmail();
		Assert.assertTrue(feedbackEmail.equals("email@gmail.com"));
	}
	

}
