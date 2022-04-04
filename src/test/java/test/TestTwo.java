package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import resources.Base;

@Test
public class TestTwo extends Base {

	WebDriver driver;

	public void LoginWithInvalidCred() throws IOException {

		driver = initiateDriver();

		driver.get(prop.getProperty("url"));

		HomePage homepage = new HomePage(driver);
		homepage.myAccountOption().click();
		homepage.loginDropdownOption().click();

		LoginPage login = new LoginPage(driver);
		login.emailField().sendKeys("sharma@gmail.com");
		login.passwordField().sendKeys("sk2@123");
		login.loginButton().click();
		
		AccountPage accountPage = new AccountPage(driver);
		
		
		try 
		{
		String loginStatus = accountPage.accountStatus().getText();	
		Assert.assertEquals("Account", loginStatus);
		System.out.println("Loggedin Successfully");
		
		}catch (Exception e){
			
			System.out.println("Log in denied");
		}
		
		driver.close();
		
		}
	
	

}
