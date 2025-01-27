package monefy.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected AppiumDriver driver;
    protected WebDriverWait wait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    protected void waitForElementToBeVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for element: " + element);
        }
    }

    protected void waitForElementsToBeVisible(List<WebElement> elements) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for elements: " + elements);
        }
    }

    protected void waitForElementToHaveText(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for element to have text: " + element);
        }
    }

    protected void click(WebElement element) {
        waitForElementToBeVisible(element);
        element.click();
    }

    protected void sendKeys(WebElement element, String text) {
        waitForElementToBeVisible(element);
        element.sendKeys(text);
    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
}
