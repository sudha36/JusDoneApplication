package com.jusdone.qa.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jusdone.qa.pages.LandingPage;
import com.jusdone.qa.pages.LoginPage;
import com.jusdone.qa.pages.DashBoardPage;
import com.jusdone.qa.pages.RegistrationPage;
import com.jusdone.qa.testbase.Testbase;
import com.jusdone.qa.utilities.BrowserAlertHelper;
import com.jusdone.qa.utilities.Testutil;

public class RegistrationPageTest extends Testbase{
	LandingPage landingpage;
	RegistrationPage registrationPage;
	String sheetName;
	DashBoardPage teamsPage;
	LoginPage loginPage;
	BrowserAlertHelper browserAlertHelper;
	
	static Testutil testutil;
	
	public RegistrationPageTest() {
		super();
		
	}
@BeforeMethod()
public void setup() {
	 initialization();
	 testutil = new Testutil();
	 landingpage = new  LandingPage();
	registrationPage = new  RegistrationPage();
	registrationPage = landingpage.Clickbtn();
	
	//landingpage.Clickbtn();
	//signUppage.ClickSignUpbtn();
}


@Test(priority=1)
public void verifyRegisterNameTest(){
	Assert.assertTrue(registrationPage.verifyRegisterName());

}

@Test(priority=2)
public void  VerifySignInBtnTest(){
	Assert.assertTrue(registrationPage.VerifySignInBtn());
	
}

@DataProvider
public  Object[][] validFields(){
	Object data[][] = Testutil.getTestData("validInputs");
	return data;
}


@Test(priority=3, dataProvider="validFields",enabled = false)
public void VerifyValidInputs(String Name,  String Email, String Pwd, String ConfirmPwd) {
	registrationPage.VerifyValidInputs(Name, Email, Pwd, ConfirmPwd);
	try {
		  testutil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
e.printStackTrace();
}
	
}

@DataProvider
public  Object[][] Invalid(){
	Object data[][] = Testutil.getTestData("ExistingUser");
	return data;
}

@Test(priority=4, dataProvider="Invalid")
public void ExistingUser(String Name,  String Email, String Pwd, String ConfirmPwd) {
	registrationPage.ExistingUser(Name, Email, Pwd, ConfirmPwd);
	try {
		  testutil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
e.printStackTrace();
}
	
}


@DataProvider
public  Object[][]SpecialCtrs(){
	Object data[][] = Testutil.getTestData("SpecialCharaters");
	return data;
}


@Test(priority=5,dataProvider="SpecialCtrs")
public void SpecialChracters (String Name,  String Email, String Pwd, String ConfirmPwd) {
	registrationPage.SpecialChracters(Name, Email, Pwd, ConfirmPwd);
	registrationPage.ClickRegisterButton();
	try {
		  testutil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
e.printStackTrace();
}
}

@DataProvider
public  Object[][]diffPwd(){
	Object data[][] = Testutil.getTestData("PwdNotMacthed");
	return data;
}
@Test(priority=5,dataProvider="diffPwd")
public void  PwdandConfirmPasswordnotMatched (String Name,  String Email, String Pwd, String ConfirmPwd) {
	registrationPage.PwdandConfirmPasswordnotMatched(Name, Email, Pwd, ConfirmPwd);
	try {
		  testutil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
e.printStackTrace();
}
	
}

@DataProvider
public  Object[][]BlankField(){
	Object data[][] = Testutil.getTestData("BlankNameField");
	return data;
}

@Test(priority=6,dataProvider="BlankField")
public void  BlankNameField (String Name,  String Email, String Pwd, String ConfirmPwd) {
	registrationPage.BlankNameField(Name, Email, Pwd, ConfirmPwd);try {
		  testutil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
e.printStackTrace();
}
	
}
@Test(priority=7)
public void ClickSignInBtnTest() {
	
		registrationPage.ClickSignInBtn();
	
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}


