package com.second.base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static java.lang.Double.parseDouble;
import static java.lang.Double.sum;


public class BasePage {

    WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    // LoginPage methods:
    public void enterUsername(By userNameLocator, String username) {
        driver.findElement(userNameLocator).sendKeys(username);
    }
    public void enterPass(By passwordLocator, String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }
    public void pressLogin(By logInBtnLocator) {
        driver.findElement(logInBtnLocator).click();
    }
    public boolean checkElementPresence(By productsTitleLocator) {
        return driver.findElement(productsTitleLocator).isDisplayed();
    }



    // ProductsAndCartPage methods:
    public void add4ItemsToCart(By firstItem, By secondItem, By thirdItem, By forthItem) {
        driver.findElement(firstItem).click();
        driver.findElement(secondItem).click();
        driver.findElement(thirdItem).click();
        driver.findElement(forthItem).click();
    }

    public void gotoCartPage(By gotoCartIcon) {
        driver.findElement(gotoCartIcon).click();
    }

    public int getNumberOfItemsInCart(By cartQuantity) {
        List<WebElement> numberOfCartItems = driver.findElements(cartQuantity);
        return numberOfCartItems.size();
    }


    // CheckoutPage methods:




    public Double getPriceFromWebElement(By checkoutTotalPrice) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        String text = driver.findElement(checkoutTotalPrice).getText();
        String price = text.replaceAll("[^\\d.]", "");
        return parseDouble(price);
    }

    public Double pricesInCart(By checkoutEachPrice){
        Double sumOfPrices = 0.0;
        List<WebElement> myElements = driver.findElements(checkoutEachPrice);
        for (WebElement element : myElements) {
            String text = element.getText().replaceAll("[^\\d.]", "");
            double price = parseDouble(text);
            sumOfPrices = sumOfPrices + price;
        }
        return sumOfPrices;
        }

    public void gotoCheckoutPage(By gotoCheckout, By checkout1name, By checkout1lastname, By checkout1postal, By checkout1continue){
        driver.findElement(gotoCheckout).click();
        driver.findElement(checkout1name).sendKeys("anyUserName");
        driver.findElement(checkout1lastname).sendKeys("anyUserLastName");
        driver.findElement(checkout1postal).sendKeys("12341234");
        driver.findElement(checkout1continue).click();
    }
    
    public Double checoutTaxPrice(By checkoutTaxPrice){
        String text = driver.findElement(checkoutTaxPrice).getText().replaceAll("[^\\d.]", "");
        return parseDouble(text);
    }

    public Double checkoutTotalPrice(By checkoutTotalPriceWithTaxes){
        String text = driver.findElement(checkoutTotalPriceWithTaxes).getText().replaceAll("[^\\d.]", "");
        return parseDouble(text);
    }


}