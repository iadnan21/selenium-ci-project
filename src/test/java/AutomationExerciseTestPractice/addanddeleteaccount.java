package AutomationExerciseTestPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class addanddeleteaccount {


    WebDriver driver;
    String name = "Adnan";
    String email = "adnan" + System.currentTimeMillis() + "@test.com";

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void registerLoginAndDeleteAccount() {

        // 1–3 Launch & Verify Home Page
        driver.get("https://automationexercise.com");
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Home')]")).isDisplayed(),
                "Home page not visible");

        // 4 Click Signup / Login
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();

        // 5 Verify New User Signup
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed(),
                "New User Signup text not visible");

        // 6 Enter Name & Email
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);

        // 7 Click Signup
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        // 8 Verify ENTER ACCOUNT INFORMATION
        Assert.assertTrue(driver.findElement(By.xpath("//b[text()='Enter Account Information']")).isDisplayed(),
                "Enter Account Information not visible");

        // 9 Fill Account Info
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("Test@123");

        driver.findElement(By.id("days")).sendKeys("10");
        driver.findElement(By.id("months")).sendKeys("May");
        driver.findElement(By.id("years")).sendKeys("1998");

        // 10 & 11 Checkboxes
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        // 12 Address Details
        driver.findElement(By.id("first_name")).sendKeys("Mohd");
        driver.findElement(By.id("last_name")).sendKeys("Adnan");
        driver.findElement(By.id("company")).sendKeys("Test Company");
        driver.findElement(By.id("address1")).sendKeys("Test Address 1");
        driver.findElement(By.id("address2")).sendKeys("Test Address 2");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("state")).sendKeys("Uttar Pradesh");
        driver.findElement(By.id("city")).sendKeys("Lucknow");
        driver.findElement(By.id("zipcode")).sendKeys("226001");
        driver.findElement(By.id("mobile_number")).sendKeys("9999999999");

        // 13 Create Account
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        // 14 Verify Account Created
        Assert.assertTrue(driver.findElement(By.xpath("//b[text()='Account Created!']")).isDisplayed(),
                "Account Created message not visible");

        // 15 Continue
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        // 16 Verify Logged in as username
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).isDisplayed(),
                "User not logged in");

        // 17 Delete Account
        driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]")).click();

        // 18 Verify Account Deleted
        Assert.assertTrue(driver.findElement(By.xpath("//b[text()='Account Deleted!']")).isDisplayed(),
                "Account Deleted message not visible");

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
