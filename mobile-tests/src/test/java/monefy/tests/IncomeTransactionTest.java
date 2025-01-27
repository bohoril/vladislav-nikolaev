package monefy.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IncomeTransactionTest extends BaseTest {
    @BeforeMethod
    public void beforeTest() {
        skipOnboarding();
    }

    @Test
    public void addIncomeRecord() {
        mainPage.clickIncomeButton();
        transactionPage.add100RecordWithCategory("Deposits");
        Assert.assertEquals(mainPage.getIncomeAmount(), 100);
    }
}
