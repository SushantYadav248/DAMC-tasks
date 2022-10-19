package pages;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.CommonUtilities;

public class MakeTripSearchPage {

	WebDriver driver;
	
	@FindBy(xpath="//*[text()='OKAY, GOT IT!']")
	List<WebElement> Alert1;
	
	@FindBy(xpath="//*[text()='Departure']")
	WebElement DepartureBtn;
	
	@FindBy(xpath="//div[contains(@class,'fli-list') and contains(@id,'flight_list')]")
	 List<WebElement> fightList;
	 
    public MakeTripSearchPage(WebDriver driver){

        this.driver = driver;
        
        PageFactory.initElements(driver, this);
    }


	public void searchFlightPage() {
		
		CommonUtilities comm = new CommonUtilities();
	       
    	comm.checkAlert(driver,Alert1);
    	
    	DepartureBtn.click();
    	
    	comm.scrollToWebElemnt(driver, DepartureBtn);
		
		if(fightList.size()>=2)
		{
		int priceInt;
		String AirLineName,flightCode,priceText;
		
		LinkedList<String> listAirLineName = new LinkedList<String>();       
		LinkedList<Integer> listAirLinePrice = new LinkedList<Integer>();       
		
		for(int iIterator=1;iIterator<=fightList.size();iIterator++)
		{
			
			 AirLineName = driver.findElement(By.xpath("(//p[contains(@class,'airlineName')])[" + iIterator + "]")).getText();
			
			 flightCode = driver.findElement(By.xpath("(//p[contains(@class,'fliCode')])[" + iIterator + "]")).getText();
			
			priceText = driver.findElement(By.xpath("(//*[@class='priceSection']/descendant::p[1])[" + iIterator + "]")).getText().trim();
			
			priceText = priceText.replaceAll(",", "").trim();
			
			priceText = priceText.replace("₹", "").trim();
            
			priceInt = Integer.parseInt(priceText);
		
			AirLineName = AirLineName + " " + flightCode ;
			
			listAirLineName.add(AirLineName);
			
			listAirLinePrice.add(priceInt);
			
		//	System.out.println(AirLineName + " " + priceInt);
			
		}
		 
		
		int temp;
		String tempAirLine;
		for (int i = 0; i < listAirLinePrice.size(); i++)   
        {  
            for (int j = i + 1; j < listAirLinePrice.size(); j++)   
            {  
                if (listAirLinePrice.get(i) > listAirLinePrice.get(j))   
                {  
                    temp = listAirLinePrice.get(i);  
                    listAirLinePrice.set(i, listAirLinePrice.get(j));  
                    listAirLinePrice.set(j, temp);
                    
                    
                    tempAirLine = listAirLineName.get(i);  
                    listAirLineName.set(i, listAirLineName.get(j));  
                    listAirLineName.set(j, tempAirLine);
                    
                }  
            }  
        }  
		System.out.println("AirLines Name :"+listAirLineName);
		
		System.out.println("AirLines Prices :"+listAirLinePrice);
		
		System.out.println("Second Lowest AirLine Name :" + listAirLineName.get(1) + "\nSecond Lowest AirLine Price :" + listAirLinePrice.get(1));

		}else {
		    System.out.println("Only Single flight available");
		    throw new ArithmeticException("Only Single flight available");
		}
		
	}
    
    
}
