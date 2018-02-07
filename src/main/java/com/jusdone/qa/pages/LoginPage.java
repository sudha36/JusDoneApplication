package com.jusdone.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.jusdone.qa.testbase.Testbase;

public class LoginPage  extends Testbase{
	
	@FindBy(xpath="html/body/div[1]/div/div/div/form/a")
	WebElement LoginName;
	
	@FindBy(xpath = "//*[@id='email']")
	WebElement UserName;
	
	@FindBy(xpath="//*[@id='password']")
	WebElement PassWord;
				
	@FindBy(xpath="html/body/div[1]/div/div/div/form/div[4]/button")
	WebElement LoginBtn;
	
	@FindBy(xpath="html/body/div[1]/div/div/div/form/div[3]/a")
	WebElement ForgotPassword;
	
	@FindBy(xpath="html/body/div[1]/div/div/div/form/div[3]/div/label")
	WebElement RememberMe;
	
	@FindBy(xpath="html/body/div[1]/div/div/div/form/a")
	WebElement CtrAnAcct;
	
	@FindBy(xpath="html/body/div[1]/div/div/div/form/div[1]/span/strong")
	WebElement ErrorMessage;
	
	
	
	
	
	
	//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
	
		//Verify LoginName in LoginPage
		public boolean  verifyLoginName() {
	    return  LoginName.isDisplayed();
		}
		
		//Verify LoginBtn in LoginPage
		public boolean  verifyLoginBtn() {
		    return  LoginBtn.isEnabled();
		}
		
		//Verify ForgotPassword
		public boolean  verifyForgotPassword() {
		    return  ForgotPassword.isEnabled();
		}
		
		//Verify CreateAnAccount in LoginPage
		public boolean  verifyCtrAnAcct() {
		    return  CtrAnAcct.isEnabled();
		}
		
		//Verify RememberMe in LoginPage
		public boolean  verifyRememberMe() {
		    return  RememberMe.isSelected();
		}
		
		//Create ValidCredentials
		public DashBoardPage ValidLogin(String UName, String PWord) {
			UserName.sendKeys(UName);
		     PassWord.sendKeys(PWord);
		     LoginBtn.click();
		     return new DashBoardPage();
		}
		//Create InvalidCredentials
		public LoginPage InValidLogin(String UName, String PWord) {
			UserName.sendKeys(UName);
		     PassWord.sendKeys(PWord);
		     LoginBtn.click();
		     JavascriptExecutor jErrorMsg = (JavascriptExecutor)driver;
				jErrorMsg.executeScript("arguments[0].click();", ErrorMessage);
				String Actual = ErrorMessage.getText();
				Assert.assertEquals(Actual, "These credentials do not match our records.");
				return new LoginPage();
			}
		
		//Give BlankEmail in LoginPage
		public LoginPage BlankEmail(String UName, String PWord) {
			UserName.sendKeys(UName);
		     PassWord.sendKeys(PWord);
		     LoginBtn.click();
		     List<WebElement> Elements = driver.findElements(By.tagName("input"));
		 	Boolean ElementExists = false;
		 	for(int counter = 0; counter < Elements.size(); counter++){
		 	    if(Elements.get(counter).getText().equals("Please fill out this field."))
		 	    		{
		 	        ElementExists = true;
		 	    }
		 	}
		 	return new LoginPage();
		}
}
	
	
	
	
	
  
	
	
	



