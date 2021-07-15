package com.second.pages;


import com.second.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage  {
    WebDriver driver;
    public CheckoutPage(WebDriver driver){
        this.driver=driver;
    }

    By gotoCheckout = By.id("checkout");
    By checkout1name = By.id("first-name");
    By checkout1lastname = By.id("last-name");
    By checkout1postal = By.id("postal-code");
    By checkout1continue = By.id("continue");
    By checkoutEachPrice = By.cssSelector(".inventory_item_price");
    By checkoutTaxPriceCSS = By.cssSelector(".summary_tax_label");
    By checkoutTotalPriceWithTaxes = By.cssSelector(".summary_total_label");
    By checkoutFinishBtn = By.id("finish");


    public Double totalPrice(){
        BasePage bp = new BasePage(driver);
        ProductsAndCartPage pcp = new ProductsAndCartPage(driver);
        pcp.addItemsToCart();
        bp.gotoCheckoutPage(gotoCheckout, checkout1name, checkout1lastname, checkout1postal, checkout1continue);
        return bp.pricesInCart(checkoutEachPrice);
    }

    public Double taxPrice(){
        BasePage bp = new BasePage(driver);
        return bp.checoutTaxPrice(checkoutTaxPriceCSS);
    }
    public Double totalWithTaxes(){
        BasePage bp = new BasePage(driver);
        return bp.checkoutTotalPrice(checkoutTotalPriceWithTaxes);
    }


}
