package twg.entaxy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlockstackBrowser {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[contains(text(),'Create new ID')]/..")
	WebElement createNewIDElement;
	
	@FindBy(name="username")
	WebElement usernameElement;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement checkAvailabilityElement;
	
	@FindBy(name="password")
	WebElement createPasswordElement;
	
	@FindBy(name="passwordConfirm")
	WebElement confirmPasswordElement;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement registerIDElement;
	
	@FindBy(name="email")
	WebElement emailElement;
	
	@FindBy(xpath="//div[contains(text(),'Next')]/..")
	WebElement emailNextElement;
	
	public BlockstackBrowser(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickOnCreateNewID()
	{
		createNewIDElement.click();
	}
	
	public void setUsername(String uname)
	{
		usernameElement.sendKeys(uname);
	}
	
	public void clickOnCheckAvailability()
	{
		checkAvailabilityElement.click();
	}
	
	public void setPassword(String password)
	{
		createPasswordElement.sendKeys(password);
	}
	
	public void setConfirmPassword(String confirmPassword)
	{
		confirmPasswordElement.sendKeys(confirmPassword);
	}
	
	public void clickOnRegisterID()
	{
		registerIDElement.click();
	}
	
	public void setEmail(String email)
	{
		emailElement.sendKeys(email);
	}
	
	public void clickOnEmailNext()
	{
		emailNextElement.click();
	}
	
	public void evaluateUsername()
	{
		clickOnCreateNewID();
		setUsername("vino12345");
		clickOnCheckAvailability();
		clickOnCheckAvailability();
		setPassword("Anbalagan@007");
		setConfirmPassword("Anbalagan@007");
		clickOnRegisterID();
		setEmail("123nandhu@gmail.com");
		clickOnEmailNext();
	}
}
