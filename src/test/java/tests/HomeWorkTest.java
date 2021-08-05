package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWorkTest extends BaseTest {
    WebElement element;

    //Тест с iFrame на сайте http://the-internet.herokuapp.com/iframe
    @Test
    public void iFrameTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(0);

        WebElement element = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        element.clear();
        element.sendKeys("Некоторый текст");
        driver.switchTo().parentFrame();
        WebElement center = driver.findElement(By.xpath("//span[@class='tox-icon tox-tbtn__icon-wrap']/ancestor::button[@aria-label='Align center']"));
        center.click();
        Thread.sleep(3000);
    }

    //Тест с iFrame на сайте https://www.onliner.by/
    @Test
    public void iFrameTest2() throws InterruptedException {
        driver.get("https://www.onliner.by/");
        WebElement search = driver.findElement(By.xpath("//input[@class='fast-search__input']"));
        search.click();
        search.sendKeys("Тостеры");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='modal-iframe']")));
        WebElement element = driver.findElement(By.xpath("//input[@class='search__input']"));
        element.clear();
        element.sendKeys("Тостер Philips HD2581/90");

        WebElement close = driver.findElement(By.xpath("//span[@class= 'search__close']"));
        close.click();
        driver.switchTo().defaultContent();

        String text = search.getText();
        System.out.println(text);
        Thread.sleep(3000);
    }

    //Тест с js на скролирование сайта вниз
    @Test
    public void jsTest() throws InterruptedException {
        driver.get("https://www.onliner.by/");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)", element);

        Thread.sleep(3000);
    }

    //Тесты на сайте https://demoqa.com/
    @Test
    public void demoQATest() {
        driver.get("https://demoqa.com/alerts");

        WebElement simpleAlertButton = driver.findElement(By.id("alertButton"));
        simpleAlertButton.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    @Test
    public void demoQATest2() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebElement simpleAlertButton = driver.findElement(By.id("timerAlertButton"));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(simpleAlertButton)
                .click()
                .pause(5000)
                .build().perform();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    @Test
    public void iframeDemoQA() throws InterruptedException {
        driver.get("https://demoqa.com/frames");
        Actions actions = new Actions(driver);
        WebElement simpleAlertButton = driver.findElement(By.className("main-header"));
        actions
                .moveToElement(simpleAlertButton)
                .pause(3000).build().perform();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)", element);

        driver.switchTo().frame(driver.findElement(By.id("frame2")));
        JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
        jsExecutor1.executeScript("window.scrollTo(0, document.body.scrollHeight)", element);

        Thread.sleep(3000);
    }
}