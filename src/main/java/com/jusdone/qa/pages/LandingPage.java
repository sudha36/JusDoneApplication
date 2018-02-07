package com.jusdone.qa.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jusdone.qa.testbase.Testbase;
public class LandingPage extends Testbase {

	@FindBy(xpath= "/html/body/div[1]/div/ul/li[2]/label")
	WebElement SignUpLogo;
	
	@FindBy(xpath= "/html/body/div[1]/div/ul/li[1]/label")
	WebElement LoginLogo;
	
	@FindBy(xpath= "/html/body/div[1]/div/ul/li[4]/label")
	WebElement AboutusLogo;
	
	@FindBy(xpath= "/html/body/div[1]/div/ul/li[3]/label")
	WebElement ContactusLogo;
	
	//Initializing the Page Objects:
		public LandingPage(){
			PageFactory.initElements(driver, this);
		}
	
	public String  validatelandingpagetitle() {
		 return driver.getTitle();
		
	}
	//validate Signuplogo
	public boolean validateSignuplogo(){
		return SignUpLogo.isDisplayed();
	}
	//validate LoginLogo
	public boolean validateLoginLogo(){
		return LoginLogo.isDisplayed();
}
	//validate AboutusLogo
	public boolean validateAboutusLogo(){
		return AboutusLogo.isDisplayed();
}
	//validate ContactusLogo
	public boolean validateContactusLogo(){
		return ContactusLogo.isDisplayed();
	}	
	//Click on SignupLogo and displayed RegistrationPage
	public RegistrationPage Clickbtn() {
		  SignUpLogo.click();
		return new RegistrationPage();
	}
	//Click on LoginLogo and displayed Loginpage
	public LoginPage Clickbtn1() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",LoginLogo);
		
	     return new LoginPage();
}
	
}
