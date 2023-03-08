import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

import static helpers.CatalogHelper.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestExample {

    private static final ChromeOptions chromeOptions = new ChromeOptions();
    private static final String url = "https://onliner.by";

    @Test
    public void shouldCheckFilterWhenDysonSelected() {
        //given
        String dyson = "Dyson";
        //when
        getEnvironment(chromeOptions);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(url);

        driver.findElement(FEN_BUTTON).click();
        driver.findElement(CLOSE_LOCATE_WINDOW).click();
        ScrollPage(driver);
        selectManufacture(driver, dyson);
        //given
        String tag = driver.findElement(By.xpath(DYSON_TAG)).getText();
        //then
        assertThat(tag).isEqualTo(dyson);
        //when
        driver.quit();
    }

    @Test
    public void shouldSelectSeveralManufactures() {
        //given
        ArrayList<String> manufactures = new ArrayList<>();
        manufactures.add("Dyson");
        manufactures.add("Rowenta");
        manufactures.add("BaByliss");
        manufactures.add("BaByliss PRO");
        //when
        getEnvironment(chromeOptions);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(url);

        driver.findElement(FEN_BUTTON).click();
        driver.findElement(CLOSE_LOCATE_WINDOW).click();
        ScrollPage(driver);
        selectManufacture(driver, manufactures.get(0));
        selectManufacture(driver, manufactures.get(1));
        selectManufacture(driver, manufactures.get(2));
        selectManufacture(driver, manufactures.get(3));
        //then
        assertThat(getTags(driver).containsAll(manufactures)).isTrue();
        //when
        driver.quit();
    }
}
