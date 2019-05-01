package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListingPage {

    WebDriver driver;

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
    }

//    public ShoppingCartPage addProductToCart(String bags) {
//        driver.findElement(By.linkText(bags)).click();
//        driver.findElement(By.linkText("Ruby on Rails Bag")).click();
//        driver.findElement(By.id("add-to-cart-button")).click();
//        System.out.println("correct");
//        return new ShoppingCartPage(driver);

    public ShoppingCartPage addProductToCart(String category, String product) {
        driver.findElement(By.linkText(category)).click();
        driver.findElement(By.linkText(product)).click();
        driver.findElement(By.id("add-to-cart-button")).click();
        return new ShoppingCartPage(driver);


    }



}
