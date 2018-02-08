package com.jusdone.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jusdone.qa.pages.LandingPage;
import com.jusdone.qa.pages.LoginPage;
import com.jusdone.qa.pages.TaskPage;

import com.jusdone.qa.pages.DashBoardPage;
import com.jusdone.qa.testbase.Testbase;
import com.jusdone.qa.utilities.Testutil;

public class LoginPageTest extends Testbase {
	LandingPage landingPage;
	LoginPage loginPage;
	TaskPage taskPage;
	Testutil testUtil;
	DashBoardPage teamsPage;
	
	
	public LoginPageTest() {
		super();
		
	}

	@BeforeMethod
	public void setup() {
		 initialization();
		 testUtil = new Testutil();
		 landingPage = new LandingPage();
		 loginPage = new  LoginPage();
		 teamsPage= new DashBoardPage();
	     loginPage = landingPage.Clickbtn1();
		
}
	
	 
	
	@Test(priority =1)
	public void  verifyLoginNameTest() {
	Assert.assertTrue(loginPage.verifyLoginName());
	}
	
	@Test(priority =2)
	public void   verifyLoginBtnTest() {
	Assert.assertTrue(loginPage. verifyLoginBtn());
	}
	
	@Test(priority =3)
	public void   verifyForgotPasswordTest() {
	Assert.assertTrue(loginPage.verifyForgotPassword());
	}
	
	@Test(priority =4)
	public void   verifyCtrAnAcctTest() {
	Assert.assertTrue(loginPage.verifyCtrAnAcct());
	}
	
	@Test(priority =5, enabled = false)
	public void   verifyRememberMeTest() {
	Assert.assertTrue(loginPage.verifyRememberMe());
	}
	
	@Test(priority =6)
	public void ValidLoginTest() {
		teamsPage =loginPage.ValidLogin(prop.getProperty("UName"),  prop.getProperty("PWord"));
	}
		@Test(priority =7)
	public void InValidLoginTest() {
		loginPage.InValidLogin("Tej@yahoo.com", "Teja123");
	}
		
		
		@Test(priority =8)
	public void BlankEmailTest() {
		loginPage.BlankEmail("", "Teja123");
	}
		
@AfterMethod
	public void teardown() {
		driver.quit();
}
}
