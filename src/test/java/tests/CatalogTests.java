package tests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static constants.Constant.Url.ONLINER_START_PAGE;

public class CatalogTests extends BaseTest {

    SoftAssert softly = new SoftAssert();

    @BeforeGroups("catalogTests")
    public void setUp(){
        basePage.open(ONLINER_START_PAGE);
    }

    @Test(groups = "catalogTests")
    void shouldCheckCatalogItems() {
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
        driver.findElement(catalogHelper.CATALOG_BUTTON).click();
        //then
        Assert.assertEquals(catalogHelper.getCatalogItems(), items);
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
        driver.findElement(catalogHelper.CATALOG_BUTTON).click();
        catalogHelper.chooseCatalogItem(id);
        //then
        softly.assertTrue(driver.findElement(catalogHelper.COMPUTER_ITEMS).isDisplayed());
        softly.assertTrue(catalogHelper.getItemsFromComputersBlock().containsAll(items));
        softly.assertAll();
    }

    @Test(groups = "catalogTests")
    public void shouldCheckComponentsSubdirectory() {
        //given
        int id= 2;
        String name = "Комплектующие";
        //when
        driver.findElement(catalogHelper.CATALOG_BUTTON).click();
        catalogHelper.chooseCatalogItem(id);
        catalogHelper.chooseComputerSubdirectory(name);
        //then
        softly.assertTrue(driver.findElement(catalogHelper.COMPONENT_SUBDIRECTORY_ITEM_NAMES).isDisplayed());
        softly.assertTrue(driver.findElement(catalogHelper.COMPONENT_SUBDIRECTORY_ITEM_PRODUCTS).isDisplayed());
        softly.assertTrue(driver.findElement(catalogHelper.COMPONENT_SUBDIRECTORY_ITEM_PRICE).isDisplayed());
        softly.assertAll();
    }

    @AfterGroups("catalogTests")
    public void tearDown() {
        close();
    }
}
