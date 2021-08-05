package utils;

import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waits {
    private WebDriverWait wait;
    private WebDriver driver;



    public Waits(WebDriver driver, int  timeout){
        this.driver = driver;
        wait = new WebDriverWait(driver, timeout);
    }

    public Waits(WebDriver driver){
        this.driver = driver;
        ReadProperties readProperties = new ReadProperties();
        wait = new WebDriverWait(driver, readProperties.getTimeOut() );
    }
    public WebElement waitForVisibility (By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForVisibility (WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public WebElement waitForPresent (By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> waitForVisibilityAllElements (By by){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public Boolean waitForInvisibility (By by){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public Boolean waitForAttribute(By by, String attributeValue, String attributeName){
        return wait.until(ExpectedConditions.attributeToBe(by, attributeName, attributeValue));
    }

    public Boolean waitForWindows(int windowCount){
        return wait.until(ExpectedConditions.numberOfWindowsToBe(windowCount));
    }

    public WebElement waitForClick(By by){
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public WebElement waitForClickable(WebElement webElement){
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
