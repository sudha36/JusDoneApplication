package com.jusdone.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.jusdone.qa.utilities.Testutil;

public class Testbase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public Testbase(){
		
	
	try {
			prop = new Properties();
		//FileInputStream ip = new FileInputStream("C:\\Users\\Murali\\Desktop\\selenium\\JusDoneTest\\src\\main\\java\\com\\jusdonge\\qa\\config");
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/jusdonge/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
              e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
			
         }
	}
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium-Jar Files\\chromedriver_win32\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium-Jar Files\\geckodriver-v0.19.1-win64\\geckodriver.exe");	
			driver = new FirefoxDriver();
		}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
}
}