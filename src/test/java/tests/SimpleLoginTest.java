package tests;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;


public class SimpleLoginTest extends BaseTest{

    @Test(groups = {"smoke"})
    //@Test
    public void testLogin(){
        Reporter.log("Application Launched successfully! ");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("spree@example.com","spree123");
        Reporter.log("Sign In successfully ! ");
        assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

    }
}






