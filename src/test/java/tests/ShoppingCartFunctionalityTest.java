package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.ProductListingPage;
import pages.ShoppingCartPage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ShoppingCartFunctionalityTest extends BaseTest {

    @Test
    public void testAddItemsToCart() throws InterruptedException {

        String aProduct = "Ruby on Rails Bag";
        ProductListingPage productListingPage =new ProductListingPage(driver);
        productListingPage.addProductToCart();
        Boolean display = driver.findElement(By.linkText(aProduct)).isDisplayed();
        assertTrue(display);

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Boolean shoppingCart = shoppingCartPage.checkShoppingCartPageDisplayed();
        assertTrue(shoppingCart);

        int rows = shoppingCartPage.quantityOfProduct();
        assertEquals(1, rows);

        Boolean nameDisplayed = shoppingCartPage.checkProductName(aProduct);
        assertTrue(nameDisplayed);
    }



//    public void IsProductInCart() {
//        List<WebElement> element = driver.findElement(By.id("cart-detail")).findElements(By.className("line-item"));
//        int rows = element.size();
//        assertEquals(1, rows);
//        String name = element.get(0).getText();
//        System.out.println(name);
//        Boolean nameDisplayed = name.contains("Ruby on Rails Bag");
//        assertTrue(nameDisplayed);

//        for (Iterator<WebElement> productIterator = element.iterator(); productIterator.hasNext(); ) {
//            WebElement next = productIterator.next();
//            System.out.println("Products " + next.getText());
//        }
    }






