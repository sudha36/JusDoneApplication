package com.jusdone.qa.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jusdone.qa.pages.LandingPage;
import com.jusdone.qa.pages.LoginPage;
import com.jusdone.qa.pages.RegistrationPage;
import com.jusdone.qa.testbase.Testbase;
import com.jusdone.qa.utilities.Testutil;

// creating Objects 
public class LandingPageTest extends Testbase{
	  LandingPage landingpage;
	 RegistrationPage  registrationPage;
	 LoginPage loginPage;
	 Testutil testUtil;
	Logger log = Logger.getLogger(LandingPageTest.class);
	 
	
	public LandingPageTest() {
		super();
		
	}
@BeforeMethod
public void setup()  {
	log.info("****************************** Starting test cases execution  *****************************************");
	 initialization();
	 landingpage = new  LandingPage();
	 testUtil = new Testutil();
}

//validating the Landingpage Title

@Test(priority = 1)

 public void Landingpagetitletest() {
	log.info("****************************** starting test case *****************************************");

	log.info("****************************** LandingPageTest*****************************************");
	
	String Title = landingpage.validatelandingpagetitle();
	Assert.assertEquals(Title, "jusDone","Mismatched Title "+Title);
	
	log.info("****************************** ending test case *****************************************");

	log.info("****************************** LandingPageTest *****************************************");
	}

//validate the signupLogo
	@Test(priority = 2)
	public void SignUpLogoTest() {
		log.info("****************************** starting test case *****************************************");

		log.info("****************************** LandingPageTest *****************************************");


	boolean logo = landingpage.validateSignuplogo();
	Assert.assertTrue(logo);
	
	log.info("****************************** Ending test case *****************************************");

	log.info("******************************LandingPageTest*****************************************");


	}
	
	//validate the LoginLogo
	@Test(priority = 3)
	public void LoginLogoTest() {
		log.info("****************************** starting test case *****************************************");

		log.info("******************************LandingPageTest *****************************************");

	boolean logo = landingpage.validateLoginLogo();
	Assert.assertTrue(logo);
	
	log.info("****************************** Ending test case *****************************************");

	log.info("****************************** LandingPageTest *****************************************");

	}
	
	@Test(priority = 4)
	public void AboutusLogoTest() {
		log.info("****************************** starting test case *****************************************");

		log.info("******************************LandingPageTest  *****************************************");

	boolean logo = landingpage.validateAboutusLogo();
	Assert.assertTrue(logo);
	log.info("****************************** Ending test case *****************************************");

	log.info("****************************** LandingPageTest *****************************************");

	}
	@Test(priority = 5)
	public void ContactusLogoTest() {
		log.info("****************************** starting test case *****************************************");

		log.info("****************************** LandingPageTest *****************************************");

	boolean logo = landingpage.validateAboutusLogo();
	Assert.assertTrue(logo);
	log.info("****************************** Ending test case *****************************************");

	log.info("******************************LandingPageTest*****************************************");

	}
	
	@Test(priority =6)
	public void  ClickbtnTest() {
		log.info("****************************** starting test case *****************************************");

		log.info("******************************LandingPageTest  *****************************************");

		registrationPage = landingpage.Clickbtn();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			testUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("****************************** Ending test case *****************************************");

		log.info("****************************** LandingPageTest *****************************************");

	}	
		
	@Test(priority =7)
	public void  Clickbtn1Test() {
		log.info("****************************** starting test case *****************************************");

		log.info("******************************LandingPageTest*****************************************");

		driver.navigate().back();
		
		loginPage = landingpage.Clickbtn1();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			
			testUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("****************************** Ending test case *****************************************");

		log.info("****************************** LandingPageTest *****************************************");

		
	}	
		
	
@AfterMethod
public void teardown() {
	driver.quit();
	log.info("****************************** Browser is closed *****************************************");
}


}
