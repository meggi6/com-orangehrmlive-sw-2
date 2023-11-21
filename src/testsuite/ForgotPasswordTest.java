package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *  Write down the following test into ‘ForgotPasswordTest’ class
 *  * 1. userShouldNavigateToForgotPasswordPageSuccessfully
 *  * * click on the ‘Forgot your password’ link * Verify the text ‘Reset Password’
 */
public class ForgotPasswordTest extends BaseTest {
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
    //Method for navigation to forgot password page
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        //Find forgot password link and click on it
        WebElement forgotPasswordLink =driver.findElement(By.xpath("//p[@class= 'oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        forgotPasswordLink.click();
        //Expected text as per requirement
        String expectedResetPasswordText = "Reset Password";
        //Find Reset Password text element and get it's text
        WebElement resetPasswordElement = driver.findElement(By.className("orangehrm-forgot-password-title"));
        String actualResetPasswordText = resetPasswordElement.getText();
        //Verify expected and actual text
        Assert.assertEquals("Text is not matching", expectedResetPasswordText, actualResetPasswordText);
    }
}
