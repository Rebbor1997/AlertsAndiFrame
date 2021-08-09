package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class DropDownRow {
    private final WebDriver driver;
    private UIElement uiElement;

    public DropDownRow(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, webElement);
    }
    public UIElement getUiElement(){
        return uiElement;
    }
}
