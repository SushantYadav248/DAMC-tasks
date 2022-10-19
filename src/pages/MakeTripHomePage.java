package pages;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.CommonUtilities;

public class MakeTripHomePage {

	WebDriver driver;
	
	@FindBy(xpath="//*[@class='langCardClose']")
	List<WebElement> Alert1;
	 
	@FindBy(id="fromCity")
    WebElement fromCity ;
	
	@FindBy(xpath="//*[@id='toCity']/following::input[1]")
    WebElement toCity;
	
	@FindBy(xpath="(//*[contains(@class,'todayPrice')]/preceding-sibling::p)[2]")
    WebElement toDate;
	
	@FindBy(xpath="//a[text()='Search']")
    WebElement searchBtn ;
	
	
    public MakeTripHomePage(WebDriver driver){

        this.driver = driver;
        
        PageFactory.initElements(driver, this);

    }

    public void dashboard(String strfromCity,String strtoCity){
    	
    	CommonUtilities comm = new CommonUtilities();
       
    	comm.checkAlert(driver,Alert1);
    	
    	comm.dropDown(driver,fromCity , strfromCity);
    	
    	comm.dropDown(driver,toCity , strtoCity);
    	
    	toDate.click();
    	
    	searchBtn.click();
    }
    
	
	}


