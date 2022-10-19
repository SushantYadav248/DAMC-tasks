package common;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonUtilities {
	

	public void scrollToWebElemnt(WebDriver driver ,WebElement wb)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", wb);
	}
	
	public void dropDown(WebDriver driver,WebElement wb , String sValue)
	{
		wb.sendKeys(sValue);
		
		List<WebElement> optionsDrop = driver.findElements(By.xpath("//li[contains(@id,'react')]"));

		for(int optionsIterator = 0;  optionsIterator<optionsDrop.size(); optionsIterator++)
		{
			if(optionsDrop.get(optionsIterator).getText().contains(sValue))
			{
				optionsDrop.get(optionsIterator).click();
				break;
			}
		}
		
	}
	
	public void screenshot(WebDriver driver,String screenshotPath,String PageName)
	{
		try {
		TakesScreenshot scrShot =((TakesScreenshot)driver);

		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		
		PageName = screenshotPath + PageName + ".png";
		//Move image file to new destination
		File DestFile=new File(PageName);

		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		
		}catch(Exception e)
		{
			System.out.println("Error at time of capture screenshot");
		}
	}

	public void checkAlert(WebDriver driver,List<WebElement> alertVisible)
	{
		//List<WebElement> alertVisible = driver.findElements(objProperty);
		
		if(!(alertVisible.isEmpty()))
		{
			alertVisible.get(0).click();
		}
		
	}
	
}
