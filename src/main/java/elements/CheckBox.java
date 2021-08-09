package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CheckBox {
    private final UIElement element;
    private List<UIElement> options = new ArrayList<>();

    public CheckBox(WebDriver driver, By by) {
        this.element = new UIElement(driver, by);
        for (WebElement element:driver.findElements(by)) {
            options.add(new UIElement(driver, element));
        }
    }

    public void click(){
        this.element.click();
    }

    public boolean isSelected(){
        return this.element.isSelected();
    }

    // Метод нажатия чекбокса, независимо включен или выключен,
    // если нужно чтобы был именно включен, то ставится "!=", а не "=="
    public void changeState(boolean makeSelected){
        if (this.isSelected() == makeSelected) this.click();
    }

    public void selectByText(String optionName){
        for (UIElement element: options) {
            String textValue = element.getParent().findElement(By.tagName("strong")).getText();
            if (textValue.equalsIgnoreCase(optionName)) {
                element.click();
                break;
            }
        }
    }
}
