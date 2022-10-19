package test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import dev.failsafe.internal.util.Assert;
import pages.HomePage;
import pages.SendMailPage;
import pages.SearchPage;


public class Task2 {
	
	/*
	Task 2 
		Go to the site: https://temp-mail.org/en/
		Generate temporary email and copy the same using copy button.
		Go to your Gmail and send an email on this temporary email.
		Go back to the site https://temp-mail.org/en/
		Click to the newly received mail.
		Verify the Subject and Body of email (Using assertion)
		Take a screenshot of the Email.
	Note: Do not use Thread. Sleep() or Wait methods.

	*/

	    static HomePage objHomePage;

	    static SendMailPage objSendMail;
	    
	    static SearchPage objSearchPage;
	    
	    static WebDriver driver = null;
		
	    static String ScreenshotPath = "D:\\Automation\\Screenshot\\";
	    
	    static String driverPath = "D:\\Automation\\Software\\chromedriver_v106\\chromedriver.exe";

	    public static void main(String args[]){

	    System.setProperty("webdriver.chrome.driver", driverPath);
	        
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("start-maximized");
	    options.addArguments("disable-extensions");
	    
	    options.addArguments("disable-infobars");
	    options.setAcceptInsecureCerts(true);
	    options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
	    options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	    
	    //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    //capabilities.setCapability("chrome.switches", Arrays.asList("--disable-extensions"));
	    
	    driver = new ChromeDriver(options);
	    driver.manage().deleteAllCookies();
	    
		driver.get("https://temp-mail.org/en/");
		
		driver.manage().timeouts().implicitlyWait(05,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		test_Home_Page();
		
		driver.close();
		
		driver.quit();
	    }


	    public static void test_Home_Page(){

	    objHomePage = new HomePage(driver);

	    objHomePage.dashboard();
	    
	    String CopyMailAddress = objHomePage.copyText();
	    
	    SendMailPage objSendMail = new SendMailPage();
	    objSendMail.mailtrigger("sushant.yadav0893@gmail.com","vzsjwvvyjmzlukor",CopyMailAddress,"Hello World..!!","How r u?");
	    
	     objSearchPage = new SearchPage(driver);
	     objSearchPage.searchMailPage(ScreenshotPath);

	    }

}
