package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DropDownMenu {
    private UIElement uiElement;
    private WebDriver driver;
    private List<DropDownRow> rowList = new ArrayList<>();

    public DropDownMenu(WebDriver driver, By by) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, by);

        for (WebElement element: this.uiElement.findElements(By.tagName("li"))) {
            rowList.add(new DropDownRow(driver, element));
        }
    }

    public int rowsCount(){
        return rowList.size();
    }

    public UIElement getElementFrom(int rowIndex){
        return rowList.get(rowIndex).getUiElement();
    }

    public UIElement getElementFromCell(String expectedText, int rowIndex){
        for (DropDownRow row: rowList) {
            if (row.getUiElement().getText().equalsIgnoreCase(expectedText)){
                return row.getUiElement();
            }
        }
        return null;
    }
}
