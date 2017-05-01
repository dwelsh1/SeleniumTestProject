package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import util.SeleniumTools;


public class MapBase extends SeleniumTools{

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	
    @FindBy(how=How.XPATH, using="id(\"widget-zoom-in\")")
	public static WebElement ZoomIn;
 
    @FindBy(how=How.XPATH, using="id(\"scale\")/button[1]")
    public static WebElement Scale;
    
      
    public MapBase(WebDriver driver){
    	super(driver);
    	PageFactory.initElements(driver, this);
    }
	
}
    
    
    
