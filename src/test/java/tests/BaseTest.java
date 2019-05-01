package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest{

    WebDriver driver;
    @BeforeMethod(alwaysRun=true)
    public void setUp() throws IOException {

        String currentUsersWorkingDir = System.getProperty("user.dir");
        System.out.println("Dir is  " + currentUsersWorkingDir);
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream(currentUsersWorkingDir+"/src/config.properties");
        properties.load(file);

        String browserName = properties.getProperty("browser");
       // if (browserName != null && !browserName.isEmpty()) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", currentUsersWorkingDir + "/src/test/resources/chromedriver");
            driver = new ChromeDriver();
            }
        else{
            System.out.println("No browser value is given");
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String url = properties.getProperty("url");
        driver.navigate().to(url);

    }
    @AfterMethod(alwaysRun=true)
    public void tearDown() {
        System.out.println("In tear down");
        driver.close();
        //driver.quit();
    }


}
