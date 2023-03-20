package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

import static constants.Constant.Url.ONLINER_START_PAGE;
import static enums.CatalogItems.*;
import static enums.SubCatalogItems.*;
import static enums.SubCatalogItems.NETWORK_EQUIPMENT;
import static pages.BasePage.open;

public class CatalogMobileAdaptationTests extends BaseTestMobile{

    SoftAssert softly = new SoftAssert();

    @BeforeMethod
    public void openCatalogPage() {
        open(ONLINER_START_PAGE);
        driver.findElement(catalogHelperMobile.CATALOG_BUTTON).click();
    }

    @Test(groups = "catalogTestsMobile")
    public void shouldCheckCatalogItems() {
        //given
        ArrayList<String> items = new ArrayList<>();
        items.add(ELECTRONIC.getText());
        items.add(COMPUTERS.getText());
        items.add(HOUSEHOLD_APPLIANCE.getText());
        items.add(FOR_EVERY_DAY.getText());
        items.add(BUILDIND_AND_REPAIR.getText());
        items.add(HOME_AND_GARDEN.getText());
        items.add(AUTO_AND_MOTO.getText());
        items.add(BEAUTY_AND_SPORT.getText());
        items.add(CHILDREN_AND_MOTHERS.getText());
        //then
        softly.assertEquals(catalogHelperMobile.getCatalogItems(), items);
    }

    @Test(groups = "catalogTestsMobile")
    public void shouldCheckComputerCatalog() {
        //given
        int id= 2;
        ArrayList<String> items = new ArrayList<>();
        items.add(LAPTOPS_COMPUTERS_MONITORS.getText());
        items.add(ACCESSORIES.getText());
        items.add(DATA_STORAGE.getText());
        items.add(NETWORK_EQUIPMENT.getText());
        //when
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
        //when
        catalogHelperMobile.chooseCatalogItem(id);
        catalogHelperMobile.chooseComputerSubdirectory(ACCESSORIES.getText());
        //then
        softly.assertTrue(driver.findElements(catalogHelperMobile.COMPONENT_SUBDIRECTORY_ITEM_NAMES).stream().allMatch(WebElement :: isDisplayed));
        softly.assertTrue(driver.findElements(catalogHelperMobile.COMPONENT_SUBDIRECTORY_ITEM_PRODUCTS).stream().allMatch(WebElement::isDisplayed));
        softly.assertTrue(driver.findElements(catalogHelperMobile.COMPONENT_SUBDIRECTORY_ITEM_PRICE).stream().allMatch(WebElement::isDisplayed));
        softly.assertAll();
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        close();
    }
}