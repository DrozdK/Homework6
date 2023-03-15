package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

import static constants.Constant.Url.ONLINER_START_PAGE;

public class CatalogTestsMobileAdaptation extends BaseTestMobile{

    SoftAssert softly = new SoftAssert();

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
        Assert.assertEquals(catalogHelperMobile.getCatalogItems(), items);
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
        softly.assertTrue(driver.findElement(catalogHelperMobile.COMPUTER_ITEMS).isDisplayed());
        softly.assertTrue(catalogHelperMobile.getItemsFromComputersBlock().containsAll(items));
        softly.assertAll();
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
        softly.assertTrue(driver.findElement(catalogHelperMobile.COMPONENT_SUBDIRECTORY_ITEM_NAMES).isDisplayed());
        softly.assertTrue(driver.findElement(catalogHelperMobile.COMPONENT_SUBDIRECTORY_ITEM_PRODUCTS).isDisplayed());
        softly.assertTrue(driver.findElement(catalogHelperMobile.COMPONENT_SUBDIRECTORY_ITEM_PRICE).isDisplayed());
        softly.assertAll();
    }

    @AfterGroups("catalogTestsMobile")
    public void tearDown() {
        close();
    }
}