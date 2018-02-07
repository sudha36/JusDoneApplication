package com.jusdone.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jusdone.qa.pages.DashBoardPage;
import com.jusdone.qa.pages.LandingPage;
import com.jusdone.qa.pages.LoginPage;
import com.jusdone.qa.pages.RegistrationPage;
import com.jusdone.qa.pages.TaskPage;
import com.jusdone.qa.testbase.Testbase;
import com.jusdone.qa.utilities.Testutil;

public class TaskPageTest extends Testbase{
	LandingPage landingPage;
	RegistrationPage  registrationPage;
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	TaskPage taskPage;
	Testutil testUtil;

	public TaskPageTest() {
		super();
	}

	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new Testutil();
		landingPage= new LandingPage();
		 registrationPage = new RegistrationPage();
		loginPage = new LoginPage();
		dashBoardPage = new DashBoardPage();
		taskPage = new TaskPage();
		landingPage.Clickbtn1();
		loginPage.ValidLogin(prop.getProperty("UName"), prop.getProperty("PWord"));
		dashBoardPage.ClickTaskTab();
	}

	// Verifying CreateNewTask Link is Displayed
	@Test(priority=1)
	public void verifyCreateNewTaskLinkTest(){
		Assert.assertTrue(taskPage.verifyCreateNewTaskLink());
	}

	// Verifying Members link is Displayed
	@Test(priority=2)
	public void verifyMembersLinkTest(){
		Assert.assertTrue(taskPage.verifyMembersLink());
	}

	// Verifying Settings link is Displayed
	@Test(priority=3)
	public void verifySettingsLinkTest(){
		Assert.assertTrue(taskPage.verifySettingsLink());
	}
	// Clicking on CreateTaskButton
	@Test(priority=4)
	public void ClickCreateNewTaskLinkTest() {
		taskPage.ClickCreateNewTaskLink();
	}

	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	

}
