package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
    WebDriver driver;

    public ProductDetailsPage(WebDriver driver){
        this.driver =driver;
    }

    public boolean ProductDisplay(String product){
        Boolean display = driver.findElement(By.linkText(product)).isDisplayed();
        return display;

    }
}