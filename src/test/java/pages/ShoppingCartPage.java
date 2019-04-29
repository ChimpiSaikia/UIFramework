package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ShoppingCartPage {

    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public int quantityOfProduct() {
        List<WebElement> element = driver.findElement(By.id("cart-detail")).findElements(By.className("line-item"));
        int rows = element.size();
        return rows;
    }

    public boolean checkProductName(String aProduct){
        List<WebElement> element = driver.findElement(By.id("cart-detail")).findElements(By.className("line-item"));
        String name = element.get(0).getText();
        System.out.println(name);
        //Boolean nameDisplayed = name.contains(aProduct);
        return name.contains(aProduct);
    }

    public boolean checkShoppingCartPageDisplayed(){
        Boolean shoppingCart = driver.findElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")).isDisplayed();
        return shoppingCart;

    }
}

