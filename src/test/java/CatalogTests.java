import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

import static helpers.CatalogHelper.*;

public class CatalogTests {

    private static final ChromeOptions chromeOptions = new ChromeOptions();
    private static final String url = "https://onliner.by";

    @Test
    public void shouldCheckCatalogItems(SoftAssertions softly) {
        //given
        ArrayList<String> items = new ArrayList<>();
        items.add("Электроника");
        items.add("Компьютеры и сети");
        items.add("Бытовая техника");
        items.add("На каждый день");
        items.add("Стройка и ремонт");
        items.add("Дом и сад");
        items.add("Авто и мото");
        items.add("Красота и спорт");
        items.add("Детям и мамам");
        //when
        getEnvironment(chromeOptions);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(url);

        driver.findElement(CATALOG_BUTTON).click();
        //then
        softly.assertThat(getCatalogItems(driver).equals(items)).isTrue();
        //when
        driver.quit();
    }

    @Test
    public void shouldCheckComputerCatalog(SoftAssertions softly) {
        //given
        int id= 2;
        ArrayList<String> items = new ArrayList<>();
        items.add("Ноутбуки, компьютеры, мониторы");
        items.add("Комплектующие");
        items.add("Хранение данных");
        items.add("Сетевое оборудование");
        //when
        getEnvironment(chromeOptions);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(url);

        driver.findElement(CATALOG_BUTTON).click();
        chooseCatalogItem(driver, id);
        //then
        softly.assertThat(driver.findElement(COMPUTER_ITEMS).isDisplayed()).isTrue();
        softly.assertThat(getItemsFromComputersBlock(driver).containsAll(items)).isTrue();
        softly.assertAll();
        //when
        driver.quit();
    }

    @Test
    public void shouldCheckComponentsSubdirectory(SoftAssertions softly) {
        //given
        int id= 2;
        String name = "Комплектующие";
        //when
        getEnvironment(chromeOptions);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(url);

        driver.findElement(CATALOG_BUTTON).click();
        chooseCatalogItem(driver, id);
        chooseComputerSubdirectory(driver, name);
        //then
        softly.assertThat(driver.findElement(COMPONENT_SUBDIRECTORY_ITEM_NAMES).isDisplayed()).isTrue();
        softly.assertThat(driver.findElement(COMPONENT_SUBDIRECTORY_ITEM_PRODUCTS).isDisplayed()).isTrue();
        softly.assertThat(driver.findElement(COMPONENT_SUBDIRECTORY_ITEM_PRICE).isDisplayed()).isTrue();
        softly.assertAll();
        //when
        driver.quit();
    }
}
