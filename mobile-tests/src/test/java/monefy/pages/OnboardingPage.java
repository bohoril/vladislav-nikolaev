package monefy.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class OnboardingPage extends BasePage {
    @AndroidFindBy(id = "buttonContinue")
    private WebElement continueButton;

    @AndroidFindBy(id = "buttonClose")
    private WebElement closeButton;

    public OnboardingPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickContinueButton() {
        click(continueButton);
    }

    public void waitForContinueButtonToHaveText(String text) {
        waitForElementToHaveText(continueButton, text);
    }

    public void clickCloseButton() {
        click(closeButton);
    }
}
