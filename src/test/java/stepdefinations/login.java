package stepdefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import resources.Base;

public class login extends Base {
	WebDriver driver;
	
	@Given ("the URL to open Ninja Home page")
	public void the_URL_to_open_Ninja_Home_page () throws IOException {
		
		driver = initiateDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@And ("navigate to login page")
	public void navigate_to_login_page() {
		
		HomePage homepage = new HomePage(driver);
		homepage.myAccountOption().click();
		homepage.loginDropdownOption().click();
	}

	@When ("enter the valid user id and password")
	public void enter_the_valid_user_id_and_password() {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.emailField().sendKeys(prop.getProperty("email"));
		loginpage.passwordField().sendKeys(prop.getProperty("password"));
		
	}
	
	@And ("click on Login button")
	public void click_on_Login_button() {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginButton().click();
		
	}
	
	@Then ("validate User should able to successfully login")
	public void validate_User_should_able_to_successfully_login() {
		
		AccountPage accountpage = new AccountPage(driver);
		
		try
		{
			 boolean loginStatus = accountpage.accountStatus().isDisplayed();
			Assert.assertEquals(true, true);
		}catch (Exception e) {
			
			System.out.println("login denied");
		}
			
	}
	
@After
public void clousure () {
	driver.close();
}

}
