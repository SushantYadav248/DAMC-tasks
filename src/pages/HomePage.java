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

public class HomePage {


	WebDriver driver;
	
    @FindBy(id="click-to-copy")

    WebElement objCopy;    

    @FindBy(xpath="//*[@class='emailbox-input opentip']")

    List<WebElement> load;


    public HomePage(WebDriver driver){

        this.driver = driver;
        
        PageFactory.initElements(driver, this);

    }


    public void copyClick(){

    	objCopy.click();
    }


    public void loadText(){

    	while(load.isEmpty())
		{
			load = this.load;
		}
    }  

    public String copyText(){
	    String actualCopedText = "";
		try {
	    	Toolkit toolkit = Toolkit.getDefaultToolkit();
		    Clipboard clipboard = toolkit.getSystemClipboard();
			actualCopedText = (String) clipboard.getData(DataFlavor.stringFlavor);
		} catch (UnsupportedFlavorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
    	return actualCopedText;
    }


    public void dashboard(){

        this.loadText();

        this.copyClick();
        
    }
    
	
	}


