package com.second.pages;
import com.second.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductsAndCartPage {
    WebDriver driver;
    public ProductsAndCartPage(WebDriver driver){
        this.driver=driver;
    }

    By add1Backpack = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    By add1BikeLight = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
    By add1Jacket = By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']");
    By add1RedTShirt = By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']");
    By gotoCartIcon = By.id("shopping_cart_container");
    By cartQuantity = By.cssSelector(".cart_quantity");

    public void addItemsToCart(){
        BasePage bp = new BasePage(driver);
        bp.add4ItemsToCart(add1Backpack,add1Jacket,add1BikeLight,add1RedTShirt);
        bp.gotoCartPage(gotoCartIcon);
    }

    public int listOfItemsInCart(){
        BasePage bp = new BasePage(driver);
        return bp.getNumberOfItemsInCart(cartQuantity);
    }
}
