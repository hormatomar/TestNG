package class3.C3HW;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CommonMethods;

public class HW extends CommonMethods {
   /* TC 1: HRMS Add Employee:
    Open chrome browser
    Go to HRMS
    Login into the application
    Add 5 different Employees and create login credentials by providing:
    First Name
    Last Name
    Username
    Password
    Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
    Close the browser
    Specify group for this test case, add it into specific suite and execute from xml file.*/

    @DataProvider
    public Object[][] data(){
        Object[][] newEmployee = new Object[5][7];
        newEmployee[0][0] = "Hormat";
        newEmployee[0][1] = "Omar";
        newEmployee[0][2] = "hormatomar";
        newEmployee[0][3] = "School11254$*";
        newEmployee[0][4] = "School11254$*";
        newEmployee[0][5] = "NewEmployee";
        newEmployee[0][6] = "Employee 1";

        newEmployee[1][0] = "Jack";
        newEmployee[1][1] = "Wilson";
        newEmployee[1][2] = "Javkwilson";
        newEmployee[1][3] = "Melonam32541%*";
        newEmployee[1][4] = "Melonam32541%*";
        newEmployee[1][5] = "NewEmployee";
        newEmployee[1][6] = "Employee 2";

        newEmployee[2][0] = "Mary";
        newEmployee[2][1] = "Thomas";
        newEmployee[2][2] = "MaryThomas";
        newEmployee[2][3] = "Ferosi445876%*";
        newEmployee[2][4] = "Ferosi445876%*";
        newEmployee[2][5] = "NewEmployee";
        newEmployee[2][6] = "Employee 3";

        newEmployee[3][0] = "Karson";
        newEmployee[3][1] = "Garcia";
        newEmployee[3][2] = "KarsonGarsia";
        newEmployee[3][3] = "Lweslk234987^*";
        newEmployee[3][4] = "Lweslk234987^*";
        newEmployee[3][5] = "NewEmployee";
        newEmployee[3][6] = "Employee 4";

        newEmployee[4][0] = "Jorge";
        newEmployee[4][1] = "Davis";
        newEmployee[4][2] = "Jorgedavis";
        newEmployee[4][3] = "Nsddf234098&*";
        newEmployee[4][4] = "Nsddf234098&*";
        newEmployee[4][5] = "NewEmployee";
        newEmployee[4][6] = "Employee 5";

        return newEmployee;
    }

    // Login into the application
    @Test (priority = 1, groups = "addingNewEmployee", dataProvider = "data")
    public void adminLogin(String firstName, String lastName, String userName, String password, String confirm,
                           String folderName, String fileName){
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.cssSelector("a#menu_pim_viewPimModule")).click();

        // adding a new employee
        driver.findElement(By.cssSelector("input#btnAdd")).click();
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("chkLogin")).click();
        driver.findElement(By.id("user_name")).sendKeys(userName);
        driver.findElement(By.cssSelector("input#user_password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#re_password")).sendKeys(confirm);
        driver.findElement(By.id("btnSave")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img#empPic")));

        // taking a screenshot
        CommonMethods.takeScreenShot(folderName, fileName);
    }

}