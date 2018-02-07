package com.jusdone.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.jusdone.qa.testbase.Testbase;
import com.jusdone.qa.utilities.BrowserAlertHelper;

public class RegistrationPage extends Testbase{
	
	//In registration page get all elements of identification
	
	@FindBy(id = "name")
	WebElement  NameField;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement EmailAddressField;
	
	@FindBy(xpath="//*[@id='password']")
	WebElement PasswordField;
	
	@FindBy(xpath ="//*[@id='password-confirm']")
	WebElement ConfirmPwdField;
	
	@FindBy(xpath="//button[@type='submit']")
    WebElement RegisterBtnclick;
    
    @FindBy(xpath="//*[@id='sidebar']/div/p[1]")
	WebElement CorrectAcctName;
	
	@FindBy(xpath="html/body/div[1]/div/div/div/form/div[2]/span/strong")
	WebElement ExistingAcctError;

	@FindBy(xpath="html/body/div[1]/div/div/div/form/div[2]/span/strong")
	WebElement InvalidEmailError;
	
	@FindBy(xpath="html/body/div[1]/div/div/div/form/div[3]/span")
	WebElement PwdMatchError;
	
	@FindBy(xpath ="html/body/div[1]/div/div/div/h3")
	WebElement RegisterName;

	@FindBy(xpath = "/html/body/div[1]/div/div/div/form/p/a")
	WebElement SignInBtn;


    
  
    
  //Initializing the Page Objects:
  		public RegistrationPage(){
  			PageFactory.initElements(driver, this);
  		}
  		
  	// Clicking on Register Button and Returning to TeamsPage
  			public DashBoardPage ClickRegisterButton() {
  			JavascriptExecutor js = (JavascriptExecutor)driver;
  			js.executeScript("arguments[0].click();", RegisterBtnclick);
  			RegisterBtnclick.click();
  			return new DashBoardPage();
  		}
  			
  		// Verifying  Display of RegisterName 		
  			public boolean verifyRegisterName(){
  			JavascriptExecutor js = (JavascriptExecutor)driver;
  			js.executeScript("arguments[0].click();", RegisterName);
  			return RegisterName.isDisplayed();
  		}

  		// Verify SignInButton		
  			public boolean VerifySignInBtn(){
  					return SignInBtn.isEnabled();
  		}
  			
  		
  		
  		 //creating New Account in RegistationPage 
  		//Giving all inputs (generalized)
  		public DashBoardPage  VerifyValidInputs(String Name,  String Email, String Pwd, String ConfirmPwd) {
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].click();", NameField);
			NameField.sendKeys(Name);
			
			
			JavascriptExecutor jsE = (JavascriptExecutor)driver;
			 jsE.executeScript("arguments[0].click();", EmailAddressField);
			 EmailAddressField.sendKeys(Email);
			 
			
			JavascriptExecutor jsP = (JavascriptExecutor)driver;
			 jsP.executeScript("arguments[0].click();",  PasswordField);
			 PasswordField.sendKeys(Pwd);
			
			 
			
			JavascriptExecutor jsCp = (JavascriptExecutor)driver;
			 jsCp.executeScript("arguments[0].click();", ConfirmPwdField);
			ConfirmPwdField.sendKeys(ConfirmPwd);
			
			
			RegisterBtnclick.click();
			
			
			
			JavascriptExecutor jAcctNameMsg = (JavascriptExecutor)driver;
			 jAcctNameMsg.executeScript("arguments[0].click();", CorrectAcctName);
			String Actual = CorrectAcctName.getText();
			Assert.assertEquals(Actual, "Teja2");
			return new DashBoardPage();

		}
  		//Create account with invalid Inputs
		
public RegistrationPage ExistingUser (String Name,String Email, String Pwd, String ConfirmPwd) {
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].click();", NameField);
			NameField.sendKeys(Name);
			//NameField.sendKeys(Keys.ENTER);
			
			JavascriptExecutor jsE = (JavascriptExecutor)driver;
			 jsE.executeScript("arguments[0].click();", EmailAddressField);
			 EmailAddressField.sendKeys(Email);
			//.sendKeys(Keys.ENTER);
			
			JavascriptExecutor jsP = (JavascriptExecutor)driver;
			 jsP.executeScript("arguments[0].click();",  PasswordField);
			 PasswordField.sendKeys(Pwd);
			// PasswordField.sendKeys(Keys.ENTER);
			
			JavascriptExecutor jsCp = (JavascriptExecutor)driver;
			 jsCp.executeScript("arguments[0].click();", ConfirmPwdField);
			ConfirmPwdField.sendKeys(ConfirmPwd);
			//ConfirmPwdField.sendKeys(Keys.ENTER);
			
			RegisterBtnclick.click();
			
			JavascriptExecutor jExistingAcctError = (JavascriptExecutor)driver;
			jExistingAcctError.executeScript("arguments[0].click();", ExistingAcctError);
			String Actual = ExistingAcctError.getText();
			Assert.assertEquals(Actual, "The email has already been taken.");
			return new RegistrationPage();

		}
// Create account with SpecialCharacters
public void SpecialChracters (String Name,  String Email, String Pwd, String ConfirmPwd) {
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("arguments[0].click();", NameField);
	NameField.sendKeys(Name);
	//NameField.sendKeys(Keys.ENTER);
	
	JavascriptExecutor jsE = (JavascriptExecutor)driver;
	 jsE.executeScript("arguments[0].click();", EmailAddressField);
	 EmailAddressField.sendKeys(Email);
	// EmailAddressField.sendKeys(Keys.ENTER);
	
	JavascriptExecutor jsP = (JavascriptExecutor)driver;
	 jsP.executeScript("arguments[0].click();",  PasswordField);
	 PasswordField.sendKeys(Pwd);
	//.sendKeys(Keys.ENTER);
	
	JavascriptExecutor jsCp = (JavascriptExecutor)driver;
	 jsCp.executeScript("arguments[0].click();", ConfirmPwdField);
	ConfirmPwdField.sendKeys(ConfirmPwd);
	
}

//Create account with Password and ConfirmPassword are not matched

public RegistrationPage PwdandConfirmPasswordnotMatched (String Name,  String Email, String Pwd, String ConfirmPwd) {
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("arguments[0].click();", NameField);
	NameField.sendKeys(Name);
	//NameField.sendKeys(Keys.ENTER);
	
	JavascriptExecutor jsE = (JavascriptExecutor)driver;
	 jsE.executeScript("arguments[0].click();", EmailAddressField);
	 EmailAddressField.sendKeys(Email);
	// EmailAddressField.sendKeys(Keys.ENTER);
	
	JavascriptExecutor jsP = (JavascriptExecutor)driver;
	 jsP.executeScript("arguments[0].click();",  PasswordField);
	 PasswordField.sendKeys(Pwd);
	 //PasswordField.sendKeys(Keys.ENTER);
	
	JavascriptExecutor jsCp = (JavascriptExecutor)driver;
	 jsCp.executeScript("arguments[0].click();", ConfirmPwdField);
	ConfirmPwdField.sendKeys(ConfirmPwd);
	//ConfirmPwdField.sendKeys(Keys.ENTER);
	
	RegisterBtnclick.click();
	
	JavascriptExecutor  jsPwdError = (JavascriptExecutor)driver;
	jsPwdError.executeScript("arguments[0].click();", PwdMatchError);
	String Actual = PwdMatchError.getText();
	Assert.assertEquals(Actual, "The password confirmation does not match.");
	return new RegistrationPage();

}
 //Creating account with Blank NameField

public RegistrationPage BlankNameField (String Name,  String Email, String Pwd, String ConfirmPwd) {
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("arguments[0].click();", NameField);
	NameField.sendKeys(Name);
	//NameField.sendKeys(Keys.ENTER);
	
	JavascriptExecutor jsE = (JavascriptExecutor)driver;
	 jsE.executeScript("arguments[0].click();", EmailAddressField);
	 EmailAddressField.sendKeys(Email);
	 //EmailAddressField.sendKeys(Keys.ENTER);
	
	JavascriptExecutor jsP = (JavascriptExecutor)driver;
	 jsP.executeScript("arguments[0].click();",  PasswordField);
	 PasswordField.sendKeys(Pwd);
	// PasswordField.sendKeys(Keys.ENTER);
	
	JavascriptExecutor jsCp = (JavascriptExecutor)driver;
	 jsCp.executeScript("arguments[0].click();", ConfirmPwdField);
	ConfirmPwdField.sendKeys(ConfirmPwd);
	//ConfirmPwdField.sendKeys(Keys.ENTER);
	
	RegisterBtnclick.click();
	
	List<WebElement> Elements = driver.findElements(By.tagName("input"));
	Boolean ElementExists = false;
	for(int counter = 0; counter < Elements.size(); counter++){
	    if(Elements.get(counter).getText().equals("Please fill out this field."))
	    		{
	        ElementExists = true;
	    }
	}
	return new RegistrationPage();


}

//Click  SignInButton		
	public LoginPage ClickSignInBtn(){
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", SignInBtn);
       return new LoginPage();
}
	
		  
}	
  		
  		
  		
  		
  		
  		
  		
  		
  		
