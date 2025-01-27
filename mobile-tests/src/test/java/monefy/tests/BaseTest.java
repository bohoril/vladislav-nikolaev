package monefy.tests;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import monefy.pages.MainPage;
import monefy.pages.OnboardingPage;
import monefy.pages.TransactionPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.URL;

public class BaseTest {
    protected AppiumDriver driver;
    private AppiumDriverLocalService service;

    protected OnboardingPage onboardingPage;
    protected MainPage mainPage;
    protected TransactionPage transactionPage;

    @BeforeClass
    public void setUp() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();

        File configFile = new File("src/test/resources/monefy-config.properties");
        Config config = ConfigFactory.parseFile(configFile);

        URL apkPath = getClass().getClassLoader().getResource(config.getString("apkName"));
        String appPath = null;
        if (apkPath != null) {
            appPath = new File(apkPath.getFile()).getAbsolutePath();
            System.out.println("APK path: " + appPath);
        } else {
            System.out.println("APK file not found.");
        }

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(config.getString("platformName"));
        options.setPlatformVersion(config.getString("platformVersion"));
        options.setDeviceName(config.getString("deviceName"));
        options.setApp(appPath);
        options.setAppPackage(config.getString("appPackage"));
        options.setAppActivity(config.getString("appActivity"));
        options.setAutomationName(config.getString("automationName"));

        driver = new AppiumDriver(service, options);

        initializePageObjects();
    }

    private void initializePageObjects() {
        onboardingPage = new OnboardingPage(driver);
        mainPage = new MainPage(driver);
        transactionPage = new TransactionPage(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

        if (service != null) {
            service.stop();
        }
    }

    protected void skipOnboarding() {
        onboardingPage.clickContinueButton();
        onboardingPage.waitForContinueButtonToHaveText("AMAZING");
        onboardingPage.clickContinueButton();
        onboardingPage.waitForContinueButtonToHaveText("I'M READY");
        onboardingPage.clickContinueButton();
        onboardingPage.clickCloseButton();
        mainPage.waitForExpenseButtonToBeVisible();
    }
}
