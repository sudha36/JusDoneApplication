package com.jusdone.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jusdone.qa.pages.LandingPage;
import com.jusdone.qa.pages.LoginPage;
import com.jusdone.qa.pages.DashBoardPage;
import com.jusdone.qa.pages.RegistrationPage;
import com.jusdone.qa.testbase.Testbase;
import com.jusdone.qa.utilities.Testutil;

public class DashBoardTest extends Testbase{
	
	LandingPage landingpage;
	RegistrationPage registrationPage;
	LoginPage loginpage;
	DashBoardPage dashBoardPage;
	Testutil testutil;
	
	public DashBoardTest() {
		super();
		
	}
@BeforeMethod
public void setup()  {
	 initialization();
	 testutil = new Testutil();
	 landingpage = new  LandingPage();
	registrationPage = new  RegistrationPage();
	dashBoardPage = new DashBoardPage();
	landingpage.Clickbtn1();
	loginpage = new LoginPage();
	loginpage.ValidLogin(prop.getProperty("UName"), prop.getProperty("PWord"));
}

@Test(priority =1)
public void  verifyUserNameTest() {
	Assert.assertTrue(dashBoardPage.VerifyUserName());
}

@Test(priority =2)
public void  verifySearchBox() {
	Assert.assertTrue(dashBoardPage.VerifySearchBox());
}

@Test(priority =3)
public void  verifyTeamsLabel() {
	Assert.assertTrue(dashBoardPage.VerifyTeamsLabel());
}

@Test(priority =4)
public void  verifyDashBoardTab() {
	Assert.assertTrue(dashBoardPage.VerifyDashBoardTab());
}

@Test(priority =5)
public void  verifyTaskTabTest() {
	Assert.assertTrue(dashBoardPage.VerifyTaskTab());
}

@Test(priority =6)
public void  verifyTeamsTab() {
	Assert.assertTrue(dashBoardPage.VerifyTeamsTab());
	
	}

@Test(priority =7)
public void  verifyInvitesTab() {
	Assert.assertTrue(dashBoardPage.VerifyInvitesTab());
}

@Test(priority =8)
public void  verifySettingsTab() {
	Assert.assertTrue(dashBoardPage.VerifySettingsTab());
}

@Test(priority =9)
public void  verifyMenuBar() {
	Assert.assertTrue(dashBoardPage.VerifyMenuBar());
}

@Test(priority =10)
public void  VerifyCreateNewTeamBtn() {
	Assert.assertTrue(dashBoardPage.VerifyCreateNewTeamBtn());
}

@Test(priority =11)
public void  VerifyBellBtn() {
	Assert.assertTrue(dashBoardPage.VerifyBellBtn());
}

@Test(priority =12)
public void  VerifyLogOutBtn() {
	Assert.assertTrue(dashBoardPage.VerifyLogOutBtn());
	
}

@Test(priority=13)
public void EnteringTeamInputsTest() {
	dashBoardPage.ClickCreateNewTeamBtn();
	dashBoardPage.EnteringTeamInputs("Pirates", "Five", "anyAut","anyAut.com");
	
	}
@Test(priority=14)
public void CreateNewTaskLinkTest() {
	Assert.assertTrue(dashBoardPage.verifyCreateNewTaskLink());
	
}

@Test(priority=15)
public void ClickTaskTabTest() {
	dashBoardPage.ClickTaskTab();
}


@Test(priority=16, enabled=false)
public void ClickCreateNewTaskLinkTest() {
	dashBoardPage.ClickCreateNewTaskLink();
	
}

@Test(priority=17)
public void ClickLogOutBtnTest() {
	dashBoardPage.ClickLogOutBtn();
	
}

@AfterMethod
public void TearDown() {
	driver.quit();
}

}	
	


