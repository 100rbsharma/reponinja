package dummytest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import resources.Base;

@Test
public class TestOne extends Base {
	
	WebDriver driver;
	
	public void LoginWithValidCred () throws IOException {
		
		driver = initiateDriver();
		driver.get(prop.getProperty("url"));
		
		HomePage homepage = new HomePage(driver);
		homepage.myAccountOption().click();
		homepage.loginDropdownOption().click();
		
		LoginPage login = new LoginPage(driver);
		login.emailField().sendKeys(prop.getProperty("email"));
		login.passwordField().sendKeys(prop.getProperty("password"));
		login.loginButton().click();
		
		AccountPage accountPage = new AccountPage(driver);
		String loginStatus = accountPage.accountStatus().getText();
		
		try 
		{
			
		Assert.assertEquals("Account", loginStatus);
		System.out.println("Loggedin Successfully");
		
		}catch (Exception e){
			
			System.out.println("Log in denied");
		}
		
		driver.close();
	}

}
