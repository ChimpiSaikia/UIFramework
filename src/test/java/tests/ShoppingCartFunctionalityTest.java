package tests;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ShoppingCartFunctionalityTest extends BaseTest {

    @Test(dataProvider = "getValidCategoryAndProduct", groups = "smoke")
    public void testValidCategoryAndProduct(String category, String product){
        String aProduct = "Ruby on Rails Bag";
        LoginPage loginPage = new LoginPage(driver);

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        ShoppingCartPage shoppingCartPage = loginPage.login("spree@example.com","spree123")
                .addProductToCart(category,product);
        Reporter.log("Added product " +product+ " successfully");

        assertTrue(driver.findElement(By.linkText(product)).isDisplayed());

        assertTrue(productDetailsPage.ProductDisplay(product));

        Boolean shoppingCart = shoppingCartPage.checkShoppingCartPageDisplayed();
        assertTrue(shoppingCart);

        int rows = shoppingCartPage.quantityOfProduct();
        System.out.println("Row" +rows);
        //assertEquals(1, rows);

        assertTrue(shoppingCartPage.checkProductName(product));

    }

    @DataProvider(name="getValidCategoryAndProduct")
    public  Object[][] getValidCategoryAndProduct(){
        return new Object[][]
                {
                        {"Bags","Ruby on Rails Bag"},
                        {"Mugs","Ruby on Rails Mug"}
                };
    }
//    @Test
//    public void testAddItemsToCart()  {
//
//        String aProduct = "Ruby on Rails Bag";
//
//       LoginPage loginPage = new LoginPage(driver);
//
//        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
//
//        ShoppingCartPage shoppingCartPage = loginPage.login("spree@example.com","spree123")
//               .addProductToCart("Bags","Ruby on Rails Bag");
//
////  //    CheckOutPage checkOutPage1 = shoppingCartPage.checkOutItems();
//    //    CheckOutPage checkOutPage = loginPage.login("spree@example.com","spree123").addProductToCart("Bags").checkOutItems();
//
//        assertTrue(productDetailsPage.ProductDisplay(aProduct));
//
//        Boolean shoppingCart = shoppingCartPage.checkShoppingCartPageDisplayed();
//        assertTrue(shoppingCart);
//
//        int rows = shoppingCartPage.quantityOfProduct();
//        System.out.println("Row" +rows);
//        assertEquals(1, rows);
//
//        Boolean nameDisplayed = shoppingCartPage.checkProductName(aProduct);
//        assertTrue(nameDisplayed);
//
//    }


    }






