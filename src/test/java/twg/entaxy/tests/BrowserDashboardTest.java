package twg.entaxy.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;
import twg.entaxy.pages.BrowserDashboard;
import twg.entaxy.pages.LandingPage;

public class BrowserDashboardTest extends BaseTest {

	LandingPage lPage;
	BrowserDashboard browserDashboard;

	@BeforeMethod
	public void beforeMethodInBrowserDashboard() {
		lPage = PageFactory.initElements(driver, LandingPage.class);
		browserDashboard = PageFactory.initElements(driver, BrowserDashboard.class);
		lPage.clickOnTestDrive();
	}

	@Test
	public void newAccountDateValidation() throws Exception
	{
		browserDashboard.createNewAccount("saving", "800", "02-05-2019");
	}
	

	@Test
	public void testNegativeOpeningBalance() throws Exception 
	{
		browserDashboard.createNewAccount("saving", "800", "02-05-2019");
		String accountLastUpdatedAmount = browserDashboard.getAccountLastUpdatedAmount();
		Assert.assertEquals("-800", accountLastUpdatedAmount);
	}
	
	@Test
	public void testSaveButtonValidation() throws Exception
	{
		browserDashboard.createNewAccount("saving", "800", "02-05-2019");
		browserDashboard.clickOnEditAccount();
		boolean statusOfSaveButton = browserDashboard.getStatusOfSaveButton();
		Assert.assertEquals(true, statusOfSaveButton);
	}
	
	
	@Test
	public void accountNameValidation() throws Exception
	{
		browserDashboard.createNewAccount("<html>script</html>", "800", "02-05-2019");
		String accountLastUpdatedName = browserDashboard.getAccountLastUpdatedName();
		Assert.assertEquals("<html>script</html>", accountLastUpdatedName);
	}
	
	@Test
	public void accountLastUpdatedDateValidation() throws Exception
	{
		browserDashboard.createNewAccount("saving", "800", "02-05-2019");
		String accountLastUpadtedDate = browserDashboard.getAccountLastUpadtedDate();
		Assert.assertEquals("Jan 1, 2018", accountLastUpadtedDate);
	}
	
	@Test
	public void testTransactionDuplication() throws Exception
	{
		browserDashboard.createNewAccount("saving", "800", "02-05-2019");
		browserDashboard.setNewTransaction("amazon", "shopping", "500");
	}

	@Test
	public void importTransactionValidation() throws Exception
	{
		browserDashboard.createNewAccount("saving", "800", "02-05-2019");	
		browserDashboard.clickOnImportTransaction();
		browserDashboard.selectImportTransaction("Microsoft Money","CSV","Intuit Quicken");
	}
	
}
