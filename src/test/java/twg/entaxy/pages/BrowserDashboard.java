package twg.entaxy.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowserDashboard {

	WebDriver driver;

	@FindBy(xpath = "//a[@href='/dashboard']")
	WebElement dashboardElement;

	@FindBy(xpath = "//a[@title='New account']")
	WebElement addNewAccountElement;

	@FindBy(xpath = "//button[@aria-label='Close']")
	WebElement newAccountCloseElement;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement newAccountSaveElement;

	@FindBy(xpath = "//div[contains(text(),'Institution')]")
	WebElement newAccountInstitutionElement;

	@FindBy(xpath = "//input[@name='name']")
	WebElement newAccountNameElement;

	@FindBy(name = "openingBalance")
	WebElement newAccountOpeningBalanceElement;

	@FindBy(name = "openingBalanceDate")
	WebElement newAccountOpeningBalanceDateElement;

	@FindBy(xpath = "(//div/span/following-sibling::div)[2]")
	WebElement newAccountCurrencyElement;

	@FindBy(xpath = "(//input[@aria-autocomplete='list']/../../../div)[3]")
	WebElement newAccountCurrencyPathElement;

	@FindBy(xpath = "(//tbody/tr/following-sibling::tr/td/following-sibling::td)[1]")
	WebElement accountLastUpdatedDateElement;

	@FindBy(xpath = "(//tbody/tr/following-sibling::tr/td/following-sibling::td)[2]")
	WebElement accountLastUpdatedAmountElement;

	@FindBy(xpath = "(//tbody/tr/following-sibling::tr/td)[1]")
	WebElement accountLastUpdatedNameElement;

	@FindBy(xpath = "//a[@title='Edit account']")
	WebElement editAccountElement;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButtonElement;

	@FindBy(xpath = "//a[@title='Import transaction']/following-sibling::button")
	WebElement newTransactionElement;

	@FindBy(name = "description")
	WebElement newTransactionDescriptionElement;

	@FindBy(name = "category")
	WebElement newTransactionCategoryElement;

	@FindBy(name = "amount")
	WebElement newTransactionAmountElement;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement newTransactionSaveElement;

	@FindBy(xpath = "//ul/li/a")
	WebElement currentAccountElement;

	@FindBy(xpath = "//a[@title='Import transaction']")
	WebElement importTransactionElement;
	
	@FindBy(xpath="//div/ul/div/div/span")
	List<WebElement> importTransactionOptionsElement;
	
	public BrowserDashboard(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnDashboard() {
		dashboardElement.click();
	}

	public void clickOnAddNewAccount() {
		addNewAccountElement.click();
	}

	public void clickOnNewAccountClose() {
		newAccountCloseElement.click();
	}

	public void clickOnNewAccountSave() {
		newAccountSaveElement.click();
	}

	public void setNewAccountInstitution() throws Exception {
		newAccountInstitutionElement.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
	}

	public void setNewAccountName(String name) {
		newAccountNameElement.clear();
		newAccountNameElement.sendKeys(name);
	}

	public void setNewAccountOpeningBalance(String balance) {
		newAccountOpeningBalanceElement.clear();
		newAccountOpeningBalanceElement.sendKeys(balance);
	}

	public void setNewAccountOpeningBalanceDate(String date) {
		newAccountOpeningBalanceDateElement.clear();
		newAccountOpeningBalanceDateElement.sendKeys(date);
	}

	public void setNewAccountCurrency() throws Exception {
		newAccountCurrencyElement.click();
		Robot robot = new Robot();
		int count = 1;
		String currency = "(XPF) CFP Franc";
		while (count > 0) {
			for (int i = 0; i < count; i++) {
				robot.keyPress(KeyEvent.VK_DOWN);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			String text = newAccountCurrencyPathElement.getText();
			if (!text.equals(currency)) {
				count++;
			} else {
				count = 0;
			}
		}
	}

	public void createNewAccount(String accountName, String balance, String date) throws Exception {
		clickOnAddNewAccount();
		setNewAccountInstitution();
		setNewAccountName(accountName);
		setNewAccountOpeningBalance(balance);
		setNewAccountOpeningBalanceDate(date);
		clickOnNewAccountSave();
		Thread.sleep(2000);
	}

	public String getAccountLastUpadtedDate() {
		clickOnDashboard();
		String date = accountLastUpdatedDateElement.getText();
		return date;
	}

	public String getAccountLastUpdatedAmount() {
		clickOnDashboard();
		String amount = accountLastUpdatedAmountElement.getText();
		return amount;
	}

	public String getAccountLastUpdatedName() {
		clickOnDashboard();
		String name = accountLastUpdatedNameElement.getText();
		return name;
	}

	public void clickOnEditAccount() {
		editAccountElement.click();
	}

	public boolean getStatusOfSaveButton() {
		boolean saveButtonStatus = saveButtonElement.isEnabled();
		return saveButtonStatus;
	}

	public void clickOnNewTransaction() {
		newTransactionElement.click();
	}

	public void setNewTransactionDescription(String description) {
		newTransactionDescriptionElement.sendKeys(description);
	}

	public void setNewTransactionCategory(String category) {
		newTransactionCategoryElement.sendKeys(category);
	}

	public void setNewTransactionAmount(String amount) {
		newTransactionAmountElement.sendKeys(amount);
	}

	public void clickOnNewTransactionSave() {
		newTransactionSaveElement.click();
	}

	public void setNewTransaction(String description, String category, String amount) {
		clickOnNewTransaction();
		setNewTransactionDescription(description);
		setNewTransactionCategory(category);
		setNewTransactionAmount(amount);
		clickOnNewTransactionSave();
	}

	public void clickOnCurrentAccount() {
		currentAccountElement.click();
	}

	public void clickOnImportTransaction() {
		importTransactionElement.click();
	}
	
	public void selectImportTransaction(String option1, String option2, String option3) {
		for(WebElement element: importTransactionOptionsElement)
		{
			if(element.getText().equals(option1)|| element.getText().equals(option2) || element.getText().equals(option3))
			{
				element.click();
				break;
			}
		}
	}
}
