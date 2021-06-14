package bredah.page.cart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bredah.page.PageObject;
import io.qameta.allure.Step;

public class CartPage extends PageObject {
  
  @FindBy(css = ".cart_navigation > :nth-child(1)")
  private WebElement buttonProceedToCheckout;

  @Step("proceed to checkout")
  public void proceedToCheckout() {
    this.buttonProceedToCheckout.click();
  }
}
