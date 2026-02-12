package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

class EbayTest {
    static WebDriver driver = new ChromeDriver();
    public static void main(String[] args) {
        driver.get("https://www.ebay.com/");
        driver.findElement(By.cssSelector("#gh-ac")).sendKeys("OnePlus6T");
        ((JavascriptExecutor) driver).executeScript("window.scroll(0,1000)");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void quit(){
        driver.quit();
    }
}

