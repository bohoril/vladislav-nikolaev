package monefy.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TransactionPage extends BasePage {
    @AndroidFindBy(id = "amount_text")
    private WebElement amountInput;

    @AndroidFindBy(id = "keyboard_action_button")
    private WebElement chooseCategoryButton;

    @AndroidFindBy(id = "textCategoryName")
    private List<WebElement> categories;

    @AndroidFindBy(id = "buttonKeyboard0")
    private WebElement buttonKeyboard0;

    @AndroidFindBy(id = "buttonKeyboard1")
    private WebElement buttonKeyboard1;

    public TransactionPage(AppiumDriver driver) {
        super(driver);
    }

    public void waitForAmountInputToHaveText(String text) {
        waitForElementToHaveText(amountInput, text);
    }

    public void input100() {
        click(buttonKeyboard1);
        click(buttonKeyboard0);
        click(buttonKeyboard0);
    }

    public void clickCategoryButton() {
        click(chooseCategoryButton);
    }

    public void selectCategory(String category) {
        waitForElementsToBeVisible(categories);
        categories.stream()
                .filter(c -> c.getText().equalsIgnoreCase(category))
                .findFirst()
                .ifPresent(this::click);
    }

    public void add100RecordWithCategory(String category) {
        input100();
        waitForAmountInputToHaveText("100");
        clickCategoryButton();
        selectCategory(category);
    }
}
