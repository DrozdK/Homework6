package tests;

import common.CommonActions;
import helpers.CatalogHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import pages.BasePage;

import static common.ConfigSetter.HOLD_BROWSER_OPEN;

public class BaseTestMobile {

        protected WebDriver driver = CommonActions.createDriverForMobileAdaptation();
        protected BasePage basePage = new BasePage(driver);
        protected CatalogHelper catalogHelperMobile = new CatalogHelper(driver);

        @AfterSuite(alwaysRun = true)
        public void close() {
            if (HOLD_BROWSER_OPEN) {
                driver.quit();
            }
        }
}
