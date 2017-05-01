package util;

import org.apache.commons.io.FileUtils;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;

public class SeleniumTools {

    WebDriver driver;
    String response;

    // Instantiate Webdriver
    public SeleniumTools(WebDriver driver){
        this.driver = driver;
    }

    public SeleniumTools() {
        // TODO Auto-generated constructor stub
    }

    //Load website
    public void loadURL(String url){
        this.driver.get(url);
        this.driver.getWindowHandle();
        this.driver.manage().window().maximize();
    }


    //Click an element on the page
    public void clickElement (String locator, String path){
        if (locator.equals("xpath")) {
            WebDriverWait wait = new WebDriverWait(driver, 25);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
            this.driver.findElement(By.xpath(path)).click();
        } else if (locator.equals("id")) {
            WebDriverWait wait = new WebDriverWait(driver, 25);
            wait.until(ExpectedConditions.elementToBeClickable(By.id(path)));
            this.driver.findElement(By.id(path)).click();
        }
    }

    //Wait for a clickable element on the page
    public void waitForClickable (String locator, String path){
        if (locator.equals("xpath")) {
            WebDriverWait wait = new WebDriverWait(driver, 25);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
        } else if (locator.equals("id")) {
            WebDriverWait wait = new WebDriverWait(driver, 25);
            wait.until(ExpectedConditions.elementToBeClickable(By.id(path)));
        }
    }

    //Wait for a specific string of text to appear on the page
    public void waitForText (String locator, String path, String text) {
        if (locator.equals("xpath")) {
            WebDriverWait wait = new WebDriverWait(driver, 45);
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(path), text));
        } else if (locator.equals("id")) {
            WebDriverWait wait = new WebDriverWait(driver, 45);
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(path), text));
        }
    }

    //Validate a text string against a text string on the page
    public void validateText (String locator, String path, String text) {
        if (locator.equals("xpath")) {
            WebDriverWait wait = new WebDriverWait(driver, 25);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
            org.junit.Assert.assertThat(driver.findElement(By.xpath(path)).getText(), CoreMatchers.containsString(text));
        } else if (locator.equals("id")) {
            WebDriverWait wait = new WebDriverWait(driver, 25);
            wait.until(ExpectedConditions.elementToBeClickable(By.id(path)));
            org.junit.Assert.assertThat(driver.findElement(By.id(path)).getText(), CoreMatchers.containsString(text));
        }
    }


    public void getPageTitle (){
        driver.getTitle();
        System.out.println("Page title is: " + driver.getTitle());
    }


    //Take a screen shot of the current page and save it
    public void takeScreenshot(String filename) throws Exception {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:/Automation/Screenshots" + filename));
    }

 
    public void sleep (long l) {
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Quit webdriver
    public void quitDriver() { this.driver.quit(); }
}
