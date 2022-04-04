package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	public WebDriver driver;
	Logger log;
	
	@BeforeMethod
	public void initiateBrowser() throws IOException {
		
		log = LogManager.getLogger(LoginTest.class.getName());
		
		driver =  initiateDriver();
		log.debug("browser open");
		
		driver.get(prop.getProperty("url"));
		log.debug("Url typed and Website Open");
	
		}

	
	@AfterMethod
	public void closer () throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test (dataProvider = "getLoginData")
	public void loginTest(String email, String password) {
		
		HomePage homepage = new HomePage (driver);
		
		homepage.myAccountOption().click();
		log.debug("clicked on my account option ");
		
		homepage.loginDropdownOption().click();
		log.debug("clicked on login option in dropdown");
		
		LoginPage login = new LoginPage (driver);
		
		login.emailField().sendKeys(email);
		login.passwordField().sendKeys(password);
		login.loginButton().click();
		
		
		
	}
	
	@DataProvider
	public String[][] getLoginData() {
		
		String [][] data = { {"sourabh@gmail.com","sk@1122"} ,{"sk256@gmail.com" , "sk@123"}};
		
		
		return data;
		
	}
	
	
	
	
	
	
	
	
	
	
}
