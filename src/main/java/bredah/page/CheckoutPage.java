package bredah.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class CheckoutPage extends PageObject{

  @FindBy(css = ".cart_navigation > .standard-checkout")
  private WebElement buttonProceedToCheckout;
  
  @Step("proceed to checkout")
  public void proceedToCheckout() {
    this.buttonProceedToCheckout.click();
  }

}
