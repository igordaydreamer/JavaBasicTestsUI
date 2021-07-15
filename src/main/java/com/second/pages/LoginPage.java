package com.second.pages;
import com.second.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    // Locators:
    By userName = By.id("user-name");
    By userPassword = By.id("password");
    By logInBtn = By.id("login-button");
    By productsTitle = By.xpath("//span[contains(text(),'Products')]");

    public void doLogin(){
        BasePage bp = new BasePage(driver);
        bp.enterUsername(userName,"standard_user");
        bp.enterPass(userPassword, "secret_sauce");
        bp.pressLogin(logInBtn);
    }

    public boolean productPageLoad(){
        BasePage bp = new BasePage(driver);
        return bp.checkElementPresence(productsTitle);
    }
}
