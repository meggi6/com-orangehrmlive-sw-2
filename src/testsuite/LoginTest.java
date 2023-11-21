package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Write down the following test into ‘LoginTest’ class
 *  * 1. userSholdLoginSuccessfullyWithValidCredentials * Enter “Admin” username
 *  * * Enter “admin123 password * Click on ‘LOGIN’ button
 *  * * Verify the ‘Dashboard’ text is display
 */
public class LoginTest extends BaseTest {
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    //Before annotation run in the beginning of all tests
    @Before
    //Browser set-up method
    public void setUp(){
        openBrowser(baseUrl);
    }

    //After annotation method run at the end of all tests
    @After
    //Browser closing method
    public void tearDown(){
        closeBrowser();
    }

    //Test annotation for executing the method
    @Test
    //Method for Successfully login
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        //Find username field element and enter username
        WebElement userNameFieldElement = driver.findElement(By.name("username"));
        userNameFieldElement.sendKeys("Admin");
        //Find password field element and enter password
        WebElement passwordFieldElement = driver.findElement(By.name("password"));
        passwordFieldElement.sendKeys("admin123");
        //Find login button element and click on it
        WebElement loginButtonElement = driver.findElement(By.tagName("button"));
        loginButtonElement.click();
        //Expected text according to requirement
        String expectedDashboardText = "Dashboard";
        //Find Dashboard text element and get it's text
        WebElement dashboardTextElement = driver.findElement(By.className("oxd-topbar-header-breadcrumb-module"));
        String actualDashboardText = dashboardTextElement.getText();
        //Verify expected and actual text
        Assert.assertEquals("dashboard text is not matching", expectedDashboardText, actualDashboardText);
    }
}
