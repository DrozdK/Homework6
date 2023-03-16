package tests;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static constants.Constant.Url.ONLINER_START_PAGE;

public class CatalogTests extends BaseTest {

    @Test(groups = "catalogTests")
    public void shouldCheckCatalogItems() {
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
        basePage.open(ONLINER_START_PAGE);
        driver.findElement(catalogHelper.CATALOG_BUTTON).click();
        //then
        Assertions.assertThat(catalogHelper.getCatalogItems().containsAll(items)).isTrue();
    }

    @Test(groups = "catalogTests")
    public void shouldCheckComputerCatalog() {
        //given
        int id= 2;
        ArrayList<String> items = new ArrayList<>();
        items.add("Ноутбуки, компьютеры, мониторы");
        items.add("Комплектующие");
        items.add("Хранение данных");
        items.add("Сетевое оборудование");
        //when
        basePage.open(ONLINER_START_PAGE);
        driver.findElement(catalogHelper.CATALOG_BUTTON).click();
        catalogHelper.chooseCatalogItem(id);
        //then
        Assertions.assertThat(driver.findElement(catalogHelper.COMPUTER_ITEMS).isDisplayed()).isTrue();
        Assertions.assertThat(catalogHelper.getItemsFromComputersBlock().containsAll(items)).isTrue();
    }

    @Test(groups = "catalogTests")
    public void shouldCheckComponentsSubdirectory() {
        //given
        int id= 2;
        String name = "Комплектующие";
        //when
        basePage.open(ONLINER_START_PAGE);
        driver.findElement(catalogHelper.CATALOG_BUTTON).click();
        catalogHelper.chooseCatalogItem(id);
        catalogHelper.chooseComputerSubdirectory(name);
        //then
        Assertions.assertThat(driver.findElements(catalogHelper.COMPONENT_SUBDIRECTORY_ITEM_NAMES)).allMatch(WebElement::isDisplayed);
        Assertions.assertThat(driver.findElements(catalogHelper.COMPONENT_SUBDIRECTORY_ITEM_PRODUCTS)).allMatch(WebElement::isDisplayed);
        Assertions.assertThat(driver.findElements(catalogHelper.COMPONENT_SUBDIRECTORY_ITEM_PRICE)).allMatch(WebElement::isDisplayed);

    }

    @AfterGroups("catalogTests")
    public void tearDown() {
        close();
    }
}