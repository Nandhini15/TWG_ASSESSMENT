package twg.entaxy.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import twg.entaxy.pages.BrowserDashboard;
import twg.entaxy.pages.LandingPage;

public class BrowserDashboardTest extends BaseTest {

	LandingPage lPage;
	BrowserDashboard browserDashboard;

	@BeforeMethod
	public void beforeMethodInBrowserDashboard() {
		lPage = PageFactory.initElements(driver, LandingPage.class);
		browserDashboard = PageFactory.initElements(driver, BrowserDashboard.class);
	}

	@Test
	public void newAccountDateValidation() throws Exception
	{
		lPage.clickOnTestDrive();
		browserDashboard.createNewAccount("saving", "800", "02-05-2019");
	}
	

	@Test
	public void testNegativeOpeningBalance() throws Exception 
	{
		lPage.clickOnTestDrive();
		browserDashboard.createNewAccount("saving", "-800", "02-05-2019");
	}
	
	@Test
	public void testSaveButtonEnableValidation() throws Exception
	{
		lPage.clickOnTestDrive();
		browserDashboard.createNewAccount("saving", "800", "02-05-2019");
		browserDashboard.clickOnEditAccount();
		boolean statusOfSaveButton = browserDashboard.getStatusOfSaveButton();
		Assert.assertEquals(true, statusOfSaveButton);
	}
	
	
	@Test
	public void accountNameValidation() throws Exception
	{
		lPage.clickOnTestDrive();
		browserDashboard.createNewAccount("<html>script</html>", "800", "02-05-2019");
		String accountLastUpdatedName = browserDashboard.getAccountLastUpdatedName();
		Assert.assertEquals("<html>script</html>", accountLastUpdatedName);
	}
	
	@Test
	public void accountLastUpdatedDateValidation() throws Exception
	{
		lPage.clickOnTestDrive();
		browserDashboard.createNewAccount("saving", "800", "02-05-2019");
		String accountLastUpadtedDate = browserDashboard.getAccountLastUpadtedDate();
		Assert.assertEquals("Jan 1, 2018", accountLastUpadtedDate);
	}
	
	@Test
	public void testTransactionDuplication() throws Exception
	{
		lPage.clickOnTestDrive();
		browserDashboard.createNewAccount("saving", "800", "02-05-2019");
		browserDashboard.setNewTransaction("amazon", "shopping", "500");
	}

	@Test
	public void importTransactionValidation() throws Exception
	{
		lPage.clickOnTestDrive();
		browserDashboard.createNewAccount("saving", "800", "02-05-2019");	
		browserDashboard.clickOnImportTransaction();
		browserDashboard.selectImportTransaction("Microsoft Money","CSV","Intuit Quicken");
	}
	
}
