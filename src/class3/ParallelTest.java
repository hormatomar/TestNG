package class3;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.CommonMethods;

public class ParallelTest extends CommonMethods {


    //@Test -- perform login

    @Test(groups = "regression", enabled = true)
    public void adminLogin(){
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
    }

    @Test(groups = "regression")
    public void validationOfTitle(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Human Management System";

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Test is passed");
        }else{
            System.out.println("Test is failed");
        }
    }

    @Test(groups = "regression")
    public void validationOfTitle2(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Human Management System";

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Test is passed");
        }else{
            System.out.println("Test is failed");
        }
    }

    //post condition @after method -- close browser

}