package AutomationExerciseTestPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class loginwithcorrectPassword {
    WebDriver driver;
//    String name = "Adnan";
//    String email = "adnan" + System.currentTimeMillis() + "@test.com";
    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void checkDetails() {

        driver.get("https://automationexercise.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Home')]")).isDisplayed());

        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".login-form")));

        driver.findElement(By.xpath("//input[@data-qa='login-email']"))
                .sendKeys("adnanali8808@gmail.com");

        driver.findElement(By.xpath("//input[@data-qa='login-password']"))
                .sendKeys("1906@Adnan");

        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        Assert.assertTrue(
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[contains(text(),'Logged in as')]")
                )).isDisplayed(),
                "Username is not visible"
        );

        driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]")).click();

        Assert.assertTrue(
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//b[contains(text(),'Account Deleted!')]")
                )).isDisplayed(),
                "Account Deleted message not visible"
        );
    }

    @AfterClass
    public void clear(){
        driver.quit();
    }
}

