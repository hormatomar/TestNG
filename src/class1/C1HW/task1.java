package class1.C1HW;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class task1 {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("This is pre condition");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("This is post condition");
    }

    @Test(priority = 1)
    public void openBrowser(){
        System.out.println("Please enter your PIN");
    }
    @Test(priority=2)
    public void login(){
        System.out.println("Please choose your option");
    }
    @Test(priority=3)
    public void tearDown(){
        System.out.println("Order was placed!");
    }
}