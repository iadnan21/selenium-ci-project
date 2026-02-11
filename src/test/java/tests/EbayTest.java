package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class EbayTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.cssSelector("#gh-ac")).sendKeys("OnePlus6T");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".gh-search-button.btn.btn--primary")).click();
        ((JavascriptExecutor) driver).executeScript("window.scroll(0,1000)");
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }
}

