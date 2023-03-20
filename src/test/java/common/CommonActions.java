package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static constants.Constant.Device.IPHONE_XR_DEVICE;
import static constants.Constant.TimeoutVariable.IMPLICIT_WAIT;

public class CommonActions {

    public static WebDriver createDriver(String type) {
        WebDriver driver = null;
        switch(type) {
            case "web":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "mobile":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                Map<String, String> props = new HashMap<>();
                props.put("deviceName", IPHONE_XR_DEVICE);
                options.setExperimentalOption("mobileEmulation",props);
                driver = new ChromeDriver(options);
                break;
            default:
                Assert.fail("Incorrect platform or browser name: " + ConfigSetter.PLATFORM_AND_BROWSER);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        return driver;
    }
}
