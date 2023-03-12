import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args){
        ChromeOptions chromeOptions = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\drivers\\chromedriver110\\chromedriver.exe");
        chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get("https://onliner.by");
        driver.findElement(By.xpath("//span[text()='Телевизоры']")).click();
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 250)");
        driver.findElement(By.xpath("//input[@value='samsung']/following-sibling::span")).click();

        if (driver.findElement(By.xpath("//input[@value='samsung']")).isSelected()) {
            System.out.println("Still selected");
        }
        driver.quit();
    }
}
