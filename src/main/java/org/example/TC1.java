package org.example;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TC1 {
    static WebDriver driver;
    @Test
    public void open() {
        driver = new ChromeDriver();
        driver.get("https://www.youtube.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public static void quit(){
        driver.quit();
    }
}
