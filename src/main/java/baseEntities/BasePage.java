package baseEntities;

import core.BrowserService;
import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

public abstract class BasePage {
    protected static final int WAIT_FOR_PAGE_LOADING_SEC = 15;
    protected WebDriver driver;
    protected ReadProperties properties;
    protected abstract void openPage();
    public abstract boolean isPageOpened();

    public BasePage(WebDriver driver, boolean openPageByUrl) {
        this.driver = driver;
        
        properties = new ReadProperties();

        PageFactory.initElements(this.driver, this);

        if (openPageByUrl) {
            openPage();
        }

    }
}
