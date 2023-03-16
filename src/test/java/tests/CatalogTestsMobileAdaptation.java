package tests;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.ArrayList;

import static constants.Constant.Url.ONLINER_START_PAGE;

public class CatalogTestsMobileAdaptation extends BaseTestMobile{

    @Test(groups = "catalogTestsMobile")
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
        driver.findElement(catalogHelperMobile.CATALOG_BUTTON).click();
        //then
        Assertions.assertThat(catalogHelperMobile.getCatalogItems().containsAll(items)).isTrue();
    }

    @Test(groups = "catalogTestsMobile")
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
        driver.findElement(catalogHelperMobile.CATALOG_BUTTON).click();
        catalogHelperMobile.chooseCatalogItem(id);
        //then
        Assertions.assertThat(driver.findElement(catalogHelperMobile.COMPUTER_ITEMS).isDisplayed()).isTrue();
        Assertions.assertThat(catalogHelperMobile.getItemsFromComputersBlock().containsAll(items)).isTrue();
    }

    @Test(groups = "catalogTestsMobile")
    public void shouldCheckComponentsSubdirectory() {
        //given
        int id= 2;
        String name = "Комплектующие";
        //when
        basePage.open(ONLINER_START_PAGE);
        driver.findElement(catalogHelperMobile.CATALOG_BUTTON).click();
        catalogHelperMobile.chooseCatalogItem(id);
        catalogHelperMobile.chooseComputerSubdirectory(name);
        //then
        Assertions.assertThat(driver.findElements(catalogHelperMobile.COMPONENT_SUBDIRECTORY_ITEM_NAMES)).allMatch(WebElement::isDisplayed);
        Assertions.assertThat(driver.findElements(catalogHelperMobile.COMPONENT_SUBDIRECTORY_ITEM_PRODUCTS)).allMatch(WebElement::isDisplayed);
        Assertions.assertThat(driver.findElements(catalogHelperMobile.COMPONENT_SUBDIRECTORY_ITEM_PRICE)).allMatch(WebElement::isDisplayed);
    }

    @AfterGroups("catalogTestsMobile")
    public void tearDown() {
        close();
    }
}