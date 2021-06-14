package bredah.page.component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import bredah.page.PageObject;
import io.qameta.allure.Step;

public class CartModel extends PageObject {

  @FindBy(id = "layer_cart_product_title")
  private WebElement labelLastProductTitle;

  @FindBy(id = "layer_cart_product_price")
  private WebElement labelLastProductPrice;

  @FindBy(css = ".layer_cart_cart  > .button-container > .continue")
  private WebElement buttonContinueShopping;

  @FindBy(css = ".layer_cart_cart  > .button-container > :nth-child(2)")
  private WebElement buttonProceedToCheckout;

  @Step("continue shopping")
  public void continueShopping() {
    this.buttonContinueShopping.click();
  }

  @Step("proceed to checkout")
  public void proceedToCheckout() {
    waitUntil(ExpectedConditions.elementToBeClickable(this.buttonProceedToCheckout));
    this.buttonProceedToCheckout.click();
  }

}
