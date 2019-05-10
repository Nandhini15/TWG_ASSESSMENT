package twg.entaxy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {

	WebDriver driver;

	@FindBy(xpath = "//span[text()='Sign in with Blockstack']/..")
	WebElement blockStackElement;

	@FindBy(xpath = "//span[contains(text(),'Take it for a test drive')]/..")
	WebElement testDriveElement;

	@FindBy(name = "us-entrypoint-button")
	WebElement iFrameFeedbackElement;

	@FindBy(name = "us-entrypoint-widgetApp")
	WebElement iFrameWidgetElement;

	@FindBy(xpath = "//button[@class='container']")
	WebElement feedbackElement;

	@FindBy(id = "FormControl1_input")
	WebElement feedbackTitleElement;

	@FindBy(xpath = "//input[@id='FormControl2_input']")
	WebElement feedbackEmailElement;

	@FindBy(id = "FormControl4_input")
	WebElement feedbackMessageElement;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement feedbackSubmitElement;

	@FindBy(xpath = "//span[contains(text(),'Close')]/..")
	WebElement feedbackCloseElement;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnBlockStack() {
		blockStackElement.click();
	}

	public void clickOnTestDrive() {
		testDriveElement.click();
	}

	public void clickOnFeedBackElement() {
		driver.switchTo().frame(iFrameFeedbackElement);
		feedbackElement.click();
	}

	public void setFeedbackTitle(String title) {
		driver.switchTo().frame(iFrameWidgetElement);
		feedbackTitleElement.sendKeys(title);
	}

	public void setFeedbackEmail(String email) {

		feedbackEmailElement.sendKeys(email);
	}

	public void setFeedbackMessage(String message) {
		feedbackMessageElement.sendKeys(message);
	}

	public void clickOnFeedbackSubmit() {
		feedbackSubmitElement.click();
	}

	public void clickOnFeedbackClose() {
		feedbackCloseElement.click();
	}

	public String getFeedbackEmail() {
		driver.switchTo().frame(iFrameWidgetElement);
		String valueEntry = feedbackEmailElement.getAttribute("value");
		return valueEntry;
	}

	public void submitFeedback(String title, String email, String message) {

		clickOnFeedBackElement();
		setFeedbackTitle(title);
		setFeedbackEmail(email);
		setFeedbackMessage(message);
		clickOnFeedbackSubmit();
		clickOnFeedbackClose();
	}
}
