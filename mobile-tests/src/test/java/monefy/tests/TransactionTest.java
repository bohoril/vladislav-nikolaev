package monefy.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TransactionTest extends BaseTest {
    @BeforeMethod
    public void beforeTest() {
        skipOnboarding();
    }

    @Test
    public void addExpenseRecord() {
        mainPage.clickExpenseButton();
        transactionPage.add100RecordWithCategory("Bills");
        Assert.assertEquals(mainPage.getExpenseAmount(), 100);
    }

    @Test
    public void addIncomeRecord() {
        mainPage.clickIncomeButton();
        transactionPage.add100RecordWithCategory("Deposits");
        Assert.assertEquals(mainPage.getIncomeAmount(), 100);
    }
}
