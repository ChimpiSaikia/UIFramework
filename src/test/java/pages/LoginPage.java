package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id ="link-to-login")
    WebElement login_link;

    @FindBy(id ="spree_user_email")
    WebElement emailID;

    @FindBy(id ="spree_user_password")
    WebElement password;

    @FindBy(name ="commit")
    WebElement commit;



    public LoginPage(WebDriver driver) {
        this.driver =driver;
        PageFactory.initElements(driver, this);
    }


    public ProductListingPage login(String emaiID, String passwordText) {

            login_link.click();
            emailID.sendKeys(emaiID);
            password.sendKeys(passwordText);
            commit.click();
//        driver.navigate().to("https://spree-vapasi.herokuapp.com");
//        driver.findElement(By.id("link-to-login")).click();
//        driver.findElement(By.id("spree_user_email")).sendKeys(emaiID);
//        driver.findElement(By.id("spree_user_password")).sendKeys(password);
//        driver.findElement(By.name("commit")).click();

        return new ProductListingPage(driver);
    }
}
