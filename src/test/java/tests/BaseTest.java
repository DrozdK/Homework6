package tests;

import common.CommonActions;
import helpers.CatalogHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import pages.BasePage;

import static common.ConfigSetter.HOLD_BROWSER_OPEN;

public class BaseTest {

    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected CatalogHelper catalogHelper = new CatalogHelper(driver);

    @AfterSuite(alwaysRun = true)
    public void close() {
        if(HOLD_BROWSER_OPEN)
        {
            driver.quit();
        }
    }
}
