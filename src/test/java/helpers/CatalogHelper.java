package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.xpath;

public class CatalogHelper {

    //locators
    public static final By CATALOG_BUTTON = By.xpath("//span[text()='Каталог' and contains(@class, 'main')]");
    public static final By COMPUTER_ITEMS = By.xpath("(//div[@class='catalog-navigation-list__aside-list'])[3]");
    public static final By COMPONENT_SUBDIRECTORY_ITEM_NAMES = By.xpath("//div[text()=' Комплектующие ']/..//span[contains(@class, 'title')]");
    public static final By COMPONENT_SUBDIRECTORY_ITEM_PRODUCTS = By.xpath("//div[text()=' Комплектующие ']/..//span[3]/text()[1]/..");
    public static final By COMPONENT_SUBDIRECTORY_ITEM_PRICE = By.xpath("//div[text()=' Комплектующие ']/..//span//following-sibling::text()[1]/..");

    //methods
    public static void getEnvironment(ChromeOptions chromeOptions) {
        chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver","D:\\Program Files\\drivers\\chromedriver110\\chromedriver.exe");
    }

    public static void chooseCatalogItem (WebDriver driver, int id) {
        driver.findElement(By.xpath("//li[@data-id='"+id+"']")).click();
    }

    public static void chooseComputerSubdirectory (WebDriver driver, String name) {
        driver.findElement(By.xpath("//div[text()=' "+name+" ']/..")).click();
    }

    public static List<String> getCatalogItems(WebDriver driver){
        List <String> items = new ArrayList<>();
        driver.findElements(xpath("//span[@class='catalog-navigation-classifier__item-title']/span"))
                .forEach((WebElement item)-> items.add(item.getText()));
        return items.subList(1, 10);
    }

    public static List<String> getItemsFromComputersBlock(WebDriver driver){
        List <String> items = new ArrayList<>();
        driver.findElements(xpath("(//div[@class='catalog-navigation-list__aside-list'])[3]/div"))
                .forEach((WebElement item)-> items.add(item.getText()));
        return items;
    }
}
