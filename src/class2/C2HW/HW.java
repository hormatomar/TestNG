package class2.C2HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;
    /*TC 2: HRMS Application Negative Login:
    Open chrome browser
    Go to http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
    Enter valid username
    Leave password field empty
    Verify error message with text “Password cannot be empty” is displayed.*/

public class HW {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @Test
    public void verifyErrorMessage() {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("btnLogin")).click();

        SoftAssert soft = new SoftAssert();
        WebElement message = driver.findElement(By.id("spanMessage"));
        soft.assertTrue(message.isDisplayed());
        String actualMessage = message.getText();
        String expectedMessage = "Password cannot be empty";
        soft.assertEquals(actualMessage, expectedMessage);

        soft.assertAll();
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        driver.quit();
    }
}