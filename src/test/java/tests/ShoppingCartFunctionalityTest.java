package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ShoppingCartFunctionalityTest extends BaseTest {

    @Test
    public void testAddItemsToCart()  {

        String aProduct = "Ruby on Rails Bag";

        LoginPage loginPage = new LoginPage(driver);

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
       
        ShoppingCartPage shoppingCartPage = loginPage.login("spree@example.com","spree123")
               .addProductToCart("Bags");

//  //    CheckOutPage checkOutPage1 = shoppingCartPage.checkOutItems();
    //    CheckOutPage checkOutPage = loginPage.login("spree@example.com","spree123").addProductToCart("Bags").checkOutItems();

        assertTrue(productDetailsPage.ProductDisplay(aProduct));

        Boolean shoppingCart = shoppingCartPage.checkShoppingCartPageDisplayed();
        assertTrue(shoppingCart);

        int rows = shoppingCartPage.quantityOfProduct();
        System.out.println("Row" +rows);
        assertEquals(1, rows);

        Boolean nameDisplayed = shoppingCartPage.checkProductName(aProduct);
        assertTrue(nameDisplayed);

    }


    }






