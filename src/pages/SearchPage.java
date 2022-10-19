package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.CommonUtilities;

public class SearchPage {

	WebDriver driver;
	
    @FindBy(id="click-to-refresh")
    WebElement refresh; 
        
    @FindBy(xpath="//*[@class='inbox-dataList']/ul/li[2]")
    List<WebElement> MailRecevied;
	
    @FindBy(id="click-to-refresh")
    WebElement mailList; 
    
	
    public SearchPage(WebDriver driver){

        this.driver = driver;
        
        PageFactory.initElements(driver, this);

    }


	public void searchMailPage(String screenshotPath) {
		// TODO Auto-generated method stub
		
		CommonUtilities comm = new CommonUtilities();
    	
    	comm.scrollToWebElemnt(driver,refresh);

        while(MailRecevied.isEmpty())
        {
        	MailRecevied = this.MailRecevied;
        }
        
        
        comm.screenshot(driver,screenshotPath,"Mail Received Page");
        
        MailRecevied.get(0).click();
        
	}
    
    
}
