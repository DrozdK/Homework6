package tests;

import common.CommonActions;
import helpers.CatalogHelper;
import helpers.CatalogHelperMobile;
import org.openqa.selenium.WebDriver;
import pages.BasePageMobile;

import static common.ConfigSetter.HOLD_BROWSER_OPEN;

public class BaseTestMobile {

        protected WebDriver driverMobile = CommonActions.createDriverMobile();
        protected CatalogHelperMobile catalogHelperMobile = new CatalogHelperMobile(driverMobile);
        protected BasePageMobile basePageMobile = new BasePageMobile(driverMobile);

        public void close() {
            if (HOLD_BROWSER_OPEN) {
                driverMobile.quit();
            }
        }
}
