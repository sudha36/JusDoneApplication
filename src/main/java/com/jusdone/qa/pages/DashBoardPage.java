package com.jusdone.qa.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.jusdone.qa.testbase.Testbase;
import com.jusdone.qa.utilities.Testutil;

public class DashBoardPage extends Testbase {
	
	@FindBy(xpath ="//div[@class='user-info']")
	WebElement UserName;
	
	@FindBy(xpath="//*[contains(text(),'Dashboard')]")
	WebElement DashBoardTab;
	
	@FindBy(xpath="/html/body/div/div[1]/div/nav/ul/li[2]/a/span")
	WebElement TaskTab;
	
	@FindBy(xpath="//*[contains(text(),'Teams')]")
	WebElement TeamsTab;
	
	@FindBy(xpath="//*[contains(text(),'Invites')]")
	WebElement InvitesTab;
	
	@FindBy(xpath="//*[contains(text(),'Settings')]")
	WebElement SettingsTab;
	
	@FindBy(xpath = "//button[@type='button']")
	WebElement MenuBar;
	
	@FindBy(xpath="//input[@type='text']" )
	WebElement SearchBox;
	 
	@FindBy(xpath="//h4[@class='text-primary']")
	WebElement TeamsLabel;
	
	@FindBy(linkText="Create New Team")
	WebElement CreateNewTeamBtn;
	
	@FindBy(xpath="//i[@class='fa fa-bell']")
	WebElement BellBtn;
	
	@FindBy(xpath="/html/body/div/nav/div[2]/ul/li[2]/a")
	WebElement LogOutBtn;
	
	@FindBy(xpath="//div[@class='modal-content']")
	WebElement TeamsDialogBox;
	
	@FindBy(xpath="//input[@id='team-name']")
	WebElement TeamNameBox;
	
	@FindBy(xpath="//input[@id='team_size']")
	WebElement TeamSizeBox;
	
	@FindBy(xpath="//input[@id='company_name']")
	WebElement CompanyNameBox;
	
	@FindBy(xpath="//input[@id='company_url']")
	WebElement CompanyURLBox;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement AddBtn;
	
	@FindBy(xpath="//*[@class='close'']")
	WebElement CloseBtn;
	
	@FindBy(xpath ="html/body/div[1]/nav/div[1]/a[1]/img")
	WebElement JusDoneImage;

@FindBy(xpath="html/body/div[1]/div[1]/div/div/div[1]/div/div[2]/div[1]/h5")
	WebElement TeamNameLabel;
	
	@FindBy(xpath="html/body/div[1]/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div/div/center/ul/li[2]/a")
	WebElement CreateNewTaskLink;
	
	
	//Initializing the Page Objects:
			public DashBoardPage(){
				PageFactory.initElements(driver, this);
			}
	
	//Test the UserName is Displayed
		public boolean  VerifyUserName() {
	    return  UserName.isDisplayed();
	}
		
		//Test the SearchBox is Displayed
	public boolean  VerifySearchBox() {
	    return  SearchBox.isDisplayed();
	}
	
	//verify  the TeamsLabel  is Displayed
	public boolean  VerifyTeamsLabel() {
	    return  TeamsLabel.isDisplayed();
	}
	
	//verify  the DashBoard isEnabled
	public boolean  VerifyDashBoardTab() {
	    return  DashBoardTab.isEnabled();
	}
	
	//verify  the TeamsTab  isEnabled
	public boolean  VerifyTeamsTab() {
	    return  TeamsTab.isEnabled();
	}
	
	//verify  the TaskTab  isEnabled
	public boolean  VerifyTaskTab() {
	    return  TaskTab.isEnabled();
	}
	//verify  the InvitesTab  isEnabled
	public boolean  VerifyInvitesTab() {
	    return  InvitesTab.isEnabled();
	}
	
	//verify  the SettingsTab isEnabled
	public boolean  VerifySettingsTab() {
	    return  SettingsTab.isEnabled();
	}
	
	//verify  the MenuBar  isEnabled
	public boolean  VerifyMenuBar() {
	    return  MenuBar.isEnabled();
	}
	
	//verify  the CreateNewTeamBtn  isEnabled
	public boolean  VerifyCreateNewTeamBtn() {
	    return  CreateNewTeamBtn.isEnabled();
	}
	//verify  the  BellBtn is enabled
	public boolean  VerifyBellBtn() {
	    return  BellBtn.isEnabled();
	}
	
	//verify  the LogOutBtn  isEnabled
	public boolean  VerifyLogOutBtn() {
	    return  LogOutBtn.isEnabled();
	}
	
	//ClickCreateNewTeamBtn
	public void  ClickCreateNewTeamBtn() {
	CreateNewTeamBtn.click();
	}
	
	//Click TaskTabButton
	public void  ClickTaskTab() {
		TaskTab.click();
		}
	
	//Create New Team in the HomePage(DashBoradPage)
	
	public DashBoardPage EnteringTeamInputs(String TeamName, String TeamSize, String CompanyName, String CompanyURL) {
		TeamNameBox.sendKeys(TeamName);
		TeamSizeBox.sendKeys(TeamSize);
		CompanyNameBox.sendKeys(CompanyName);
		CompanyURLBox.sendKeys(CompanyURL);
		AddBtn.click();
		return new DashBoardPage();
		
	}
	
	// Verifying JusDone Image  is Displayed
			public boolean verifyJusDoneImage(){
				try {
					Thread.sleep(3000);
					} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return JusDoneImage.isDisplayed();
			}

	// Verifying CreateNewTaskLink is Enabled
			public boolean verifyCreateNewTaskLink(){
				return CreateNewTaskLink.isEnabled();
			}

	// Clicking CreateNewTask Link 
					public void ClickCreateNewTaskLink() {
						CreateNewTaskLink.click();
					}	

		// Clicking LogOut button 
					public void ClickLogOutBtn() {
						LogOutBtn.click();
					}	
			
	
}


