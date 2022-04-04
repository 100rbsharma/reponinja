package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	WebDriver driver;
	
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		
		
	@FindBy (xpath = "//a[@class = \"dropdown-toggle\"]/span [text() = \"My Account\"]")
	private WebElement myAccountOption; 
	
	@FindBy (linkText = "Register")
	private WebElement registerDropdownOption;
	
	@FindBy (linkText = "Login")
	private WebElement loginDropdownOption;
	
	
		public WebElement myAccountOption () {
				return myAccountOption;
			}
	
		public WebElement registerDropdownOption () {
			return registerDropdownOption;
			}	
		
		public WebElement loginDropdownOption () {
			return loginDropdownOption;
			}	
	
}
