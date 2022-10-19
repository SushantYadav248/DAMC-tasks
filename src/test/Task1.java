package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.MakeTripHomePage;
import pages.MakeTripSearchPage;


public class Task1 {
	
	/*
	Task 1: 
		Go to the MMT site: https://www.makemytrip.com/flights/
		Find flights from Delhi to Mumbai
		Click to the Sorted By: Departure 
		Print the Airline name and price having 2nd lowest price. (Note: Results should be Sorted By Departure)
    */
	
	    static MakeTripHomePage objMakeTripHome;

	    static MakeTripSearchPage objMakeTripSearch;
	    
	    static WebDriver driver = null;
		
	    static String driverPath = "D:\\Automation\\Software\\chromedriver_v106\\chromedriver.exe";

	    public static void main(String args[]){

	    System.setProperty("webdriver.chrome.driver", driverPath);
	        
		driver = new ChromeDriver();

		driver.get("https://www.makemytrip.com/flights/");		
		
		driver.manage().timeouts().implicitlyWait(05,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		test_Home_Page();
		
		driver.close();
		
		driver.quit();
	    }


	    public static void test_Home_Page(){

	    objMakeTripHome = new MakeTripHomePage(driver);
	    objMakeTripHome.dashboard("Delhi","Mumbai");
	    
	    objMakeTripSearch = new MakeTripSearchPage(driver);
	    objMakeTripSearch.searchFlightPage();

	    }

}
