package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ShoppingCartFunctionalityTest extends BaseTest{

    @Test
    public void testAddItemsToCart() throws InterruptedException {
        driver.navigate().to("https://spree-vapasi.herokuapp.com");
        driver.findElement(By.linkText("Bags")).click();
        driver.findElement(By.linkText("Ruby on Rails Bag")).click();
        driver.findElement(By.id("add-to-cart-button")).click();
        Boolean display = driver.findElement(By.linkText("Ruby on Rails Bag")).isDisplayed();
        assertTrue(display);
        Boolean shoppingCart = driver.findElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")).isDisplayed();
        assertTrue(shoppingCart);
        List<WebElement> element = driver.findElement(By.id("cart-detail")).findElements(By.className("line-item"));
        int rows = element.size();
        assertEquals(1,rows);
        String name = element.get(0).getText();
        System.out.println(name);
        Boolean nameDisplayed = name.contains("Ruby on Rails Bag");
        assertTrue(nameDisplayed);

        for (Iterator<WebElement> productIterator = element.iterator(); productIterator.hasNext(); ) {
            WebElement next =  productIterator.next();
         System.out.println("Products "+next.getText());
        }
    }

}
