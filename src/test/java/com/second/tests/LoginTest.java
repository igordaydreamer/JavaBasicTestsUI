package com.second.tests;
import com.second.base.BasePage;
import com.second.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;




public class LoginTest {
    WebDriver driver;
    String baseurl ="https://www.saucedemo.com";


    @BeforeTest
    public void openBrowser() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\JavaFirstProjectSecondTry\\src\\main\\resources\\executables\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseurl);
    }

    @Test
    public void testLoginFn(){
        LoginPage lp = new LoginPage(driver);
        lp.doLogin();
        assert lp.productPageLoad();
    }

    @AfterTest
    public void closeBrowser(){
                driver.close();
    }

}
