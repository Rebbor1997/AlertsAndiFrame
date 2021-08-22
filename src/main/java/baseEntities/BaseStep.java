package baseEntities;

import core.BrowserService;
import org.openqa.selenium.WebDriver;


public abstract class BaseStep {
    public WebDriver driver;

    public BaseStep(WebDriver driver) {
        this.driver= driver;
    }
}
