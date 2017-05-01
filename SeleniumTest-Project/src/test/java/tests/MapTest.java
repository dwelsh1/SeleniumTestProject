package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.chrome.ChromeDriver;
import util.SeleniumTools;
import pageobjects.MapBase;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MapTest{


	private static Properties props;
    static SeleniumTools seleniumTools = new SeleniumTools();

    @BeforeClass
    public static void setup() throws IOException {
    	    System.setProperty("webdriver.chrome.driver", "C:/Automation/Vendor/chromedriver.exe");
            seleniumTools = new SeleniumTools(new ChromeDriver());
            props = new Properties();
            InputStream in = MapTest.class.getClassLoader().getResourceAsStream("exampleMap.properties");
            props.load(in);
            in.close();
    }

    @AfterClass
    public static void cleanup() {seleniumTools.quitDriver();}

 

    @Test(timeout = 30000)
    public void testZoom() throws Exception{
        seleniumTools.loadURL(props.getProperty("mapurl") + props.getProperty("scale") );
    	seleniumTools.sleep(5000);
        seleniumTools.getPageTitle();
        seleniumTools.waitForClickable("xpath",".//*[@id='widget-zoom-in']");
        seleniumTools.clickElement("xpath",".//*[@id='widget-zoom-in']");
        seleniumTools.sleep(2000);
        seleniumTools.clickElement("xpath",".//*[@id='widget-zoom-in']");
        seleniumTools.sleep(2000);
        seleniumTools.clickElement("xpath",".//*[@id='widget-zoom-out']");
        seleniumTools.waitForText("xpath", ".//*[@id=\"scale\")/button[1]", "ft");
        seleniumTools.validateText("xpath", ".//*[@id=\"scale\")/button[1]", props.getProperty("scale"));
        seleniumTools.takeScreenshot("scale.png");
        seleniumTools.sleep(5000);
        seleniumTools.quitDriver();
    }
    
}
