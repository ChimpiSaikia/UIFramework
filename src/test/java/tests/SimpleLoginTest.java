package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;


public class SimpleLoginTest extends BaseTest{


    @Test(groups = {"smoke"})
    //@Test
    public void testLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("spree@example.com","spree123");
        assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
    }

//    private void login(String emaiID, String password) {
//        driver.navigate().to("https://spree-vapasi.herokuapp.com");
//        driver.findElement(By.id("link-to-login")).click();
//        driver.findElement(By.id("spree_user_email")).sendKeys(emaiID);
//        driver.findElement(By.id("spree_user_password")).sendKeys(password);
//        driver.findElement(By.name("commit")).click();
    }






