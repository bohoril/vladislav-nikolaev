package monefy.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OnboardingTest extends BaseTest {
    @Test
    public void testOnboardingFlow() {
        onboardingPage.clickContinueButton();
        onboardingPage.waitForContinueButtonToHaveText("AMAZING");
        onboardingPage.clickContinueButton();
        onboardingPage.waitForContinueButtonToHaveText("I'M READY");
        onboardingPage.clickContinueButton();
        onboardingPage.clickCloseButton();

        Assert.assertTrue(mainPage.isExpenseButtonDisplayed());
    }
}
