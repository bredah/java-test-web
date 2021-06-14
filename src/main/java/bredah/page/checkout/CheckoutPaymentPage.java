package bredah.page.checkout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bredah.page.PageObject;
import io.qameta.allure.Step;

public class CheckoutPaymentPage extends PageObject {

  @FindBy(className = "bankwire")
  private WebElement linkPayByBankWire;

  @FindBy(className = "cheque")
  private WebElement linkPayByCheck;

  @FindBy(css = "form > .cart_navigation  > button")
  private WebElement buttonSubmitPayment;

  @Step("pay with bank wire")
  public void payWithBankWire() {
    this.linkPayByBankWire.click();
  }

  @Step("pay with check")
  public void payWithCheck() {
    this.linkPayByCheck.click();
  }

  @Step("submit payment")
  public void submitPayment() {
    this.buttonSubmitPayment.click();
  }

}
