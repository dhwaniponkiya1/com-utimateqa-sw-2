package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * BaseUrl = https://courses.ultimateqa.com/
 * 2. Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully *
 * click on the ‘Sign In’ link
 * * Verify the text ‘Welcome Back!’
 * 2. verifyTheErrorMessage
 * * click on the ‘Sign In’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Invalid email
 * or password.’
 */

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        WebElement signInLinkElement = driver.findElement(By.linkText("Sign In"));          //find sign in link
        signInLinkElement.click();          //click on sign in link

        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2")).getText();

        Assert.assertEquals(expectedText,actualText);           //comparing 2 texts
    }

    @Test
    public void verifyTheErrorMessage(){
        WebElement signInLinkElement = driver.findElement(By.linkText("Sign In"));          //find sign in link
        signInLinkElement.click();          //click on sign in link

        WebElement emailElement = driver.findElement(By.id("user[email]"));         //find email textbox
        WebElement passwordElement = driver.findElement(By.id("user[password]"));         //find password textbox

        emailElement.sendKeys("test@gmail.com");            //enter invalid username
        passwordElement.sendKeys("test@123");            //enter invalid password

        WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));            //find sign in button
        signInButton.click();           //click on sign in

        String expectedText = "Invalid email or password.";
        WebElement errorMessageElement = driver.findElement(By.className("form-error__list-item"));     //find error message element
        String actualText = errorMessageElement.getText();

        Assert.assertEquals(expectedText,actualText);           //comparing 2 texts

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
