package bredah.page.checkout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bredah.page.PageObject;
import io.qameta.allure.Step;

public class CheckoutAddressPage extends PageObject {

  @FindBy(name = "processAddress")
  private WebElement buttonProceedToCheckout;

  @Step("submit address")
  public void submitAddress() {
    this.buttonProceedToCheckout.click();
  }

}
