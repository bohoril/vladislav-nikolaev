package monefy.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    @AndroidFindBy(id = "expense_button")
    private WebElement expenseButton;

    @AndroidFindBy(id = "income_button")
    private WebElement incomeButton;

    @AndroidFindBy(id = "expense_amount_text")
    private WebElement expenseAmount;

    @AndroidFindBy(id = "income_amount_text")
    private WebElement incomeAmount;

    public MainPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickExpenseButton() {
        click(expenseButton);
    }

    public boolean isExpenseButtonDisplayed() {
        waitForElementToBeVisible(expenseButton);
        return expenseButton.isDisplayed();
    }

    public void waitForExpenseButtonToBeVisible() {
        waitForElementToBeVisible(expenseButton);
    }

    public void clickIncomeButton() {
        click(incomeButton);
    }

    public int getExpenseAmount() {
        waitForElementToBeVisible(expenseAmount);
        return amountParser(expenseAmount.getText());
    }

    public int getIncomeAmount() {
        waitForElementToBeVisible(incomeAmount);
        return amountParser(incomeAmount.getText());
    }

    private int amountParser(String amount) {
        String parsedAmount = amount.replaceAll("[^0-9]", "");
        return Integer.parseInt(parsedAmount.substring(0, parsedAmount.length() - 2));
    }
}
