package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.xpath;

public class CatalogHelper {

    //locators
    public static final By FEN_BUTTON = By.xpath("//span[text()='Фены']");
    public static final By CLOSE_LOCATE_WINDOW = By.xpath("//div[@class='popover-style__content']/div[2]/span[1]");
    public static final String DYSON_TAG = "//span[@class='schema-tags__text' and text()='Dyson']";

    //methods
    public static void selectManufacture(WebDriver driver, String manufacture) {
        driver.findElement(By.xpath("(//span[text()='"+manufacture+"'])[1]/..")).click();
    }

    public static void ScrollPage(WebDriver driver) {
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 250)");
    }

    public static void getEnvironment(ChromeOptions chromeOptions) {
        chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver","D:\\Program Files\\drivers\\chromedriver110\\chromedriver.exe");
    }

    public static List<String> getTags(WebDriver driver){
        List <String> tags = new ArrayList<>();
        driver.findElements(xpath("//span[@class='schema-tags__text']"))
                .forEach((WebElement questionEl)-> tags.add(questionEl.getText()));
        return tags;
    }
}
