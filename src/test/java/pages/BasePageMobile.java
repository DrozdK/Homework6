package pages;

import org.openqa.selenium.WebDriver;

public class BasePageMobile {

    protected static WebDriver driverMobile;

    public BasePageMobile(WebDriver driverMobile) {
        BasePageMobile.driverMobile = driverMobile;
    }

    public static void open(String url) {
        driverMobile.get(url);
    }
}
