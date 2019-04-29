package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListingPage {

    WebDriver driver;

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart(){
        driver.navigate().to("https://spree-vapasi.herokuapp.com");
        driver.findElement(By.linkText("Bags")).click();
        driver.findElement(By.linkText("Ruby on Rails Bag")).click();
        driver.findElement(By.id("add-to-cart-button")).click();

    }
}
