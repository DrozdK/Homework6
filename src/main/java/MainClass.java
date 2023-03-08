import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
       // driver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
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
